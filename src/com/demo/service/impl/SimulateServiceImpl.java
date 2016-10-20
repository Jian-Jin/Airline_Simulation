package com.demo.service.impl;

import java.util.*;

import org.springframework.beans.factory.InitializingBean;

import com.demo.DAO.AircraftDAO;
import com.demo.DAO.AirportDAO;
import com.demo.DAO.DemandDAO;
import com.demo.DAO.RouteDAO;
import com.demo.DAO.UserProfitDAO;
import com.demo.model.Aircraft;
import com.demo.model.Airport;
import com.demo.model.Demand;
import com.demo.model.Route;
import com.demo.model.UserProfit;
import com.demo.service.AirportService;
import com.demo.service.SimulateService;

public class SimulateServiceImpl implements SimulateService, InitializingBean{
	private AircraftDAO aircraftDao;
	private AirportDAO airportDao;
	private RouteDAO routeDao;
	private DemandDAO demandDao;
	private UserProfitDAO userProfitDao;
	private AirportService airportService;
	private static int numberDays = 90;
	private double basicProfit = 0;
	private double fuelPrice = 0;
	// key airport ID
	private Map<Integer,Airport> airports = new HashMap<Integer,Airport>();
	// key: timezone -- key:cluster value:list
	private Map<Integer,Map<Integer,List<Demand>>> demands = new HashMap<Integer,Map<Integer,List<Demand>>>();
	

	@Override
	public void afterPropertiesSet() throws Exception {
		List<Airport> list = airportDao.getAllAirport();
		for(Airport a :list){
			airports.put(a.getId(), a);
		}
		List<Demand> dlist = demandDao.getDemands();
		for(Demand d : dlist){
			Map<Integer,List<Demand>> clusterMap = demands.get(d.getTimeZone());
			if(clusterMap == null){
				clusterMap = new HashMap<Integer,List<Demand>>();
				demands.put(d.getTimeZone(),clusterMap);
			}
			List<Demand> l = clusterMap.get(d.getCluster());
			if(l==null){
				l = new ArrayList<Demand>();
				clusterMap.put(d.getCluster(), l);
			}
			l.add(d);
		}
	}
	
	@Override
	public void runSimulate(double fuelPrice, double basicProfit) {
		this.basicProfit = basicProfit;
		this.fuelPrice = fuelPrice;
		List<Route> allRoutes = routeDao.getAllRoutes();
		// key: userAircraftId
		Map<Integer,List<Route>> map = new HashMap<Integer,List<Route>>();
		for(Route r : allRoutes){
			List<Route> list = map.get(r.getUserAircraftId());
			if(list == null){
				list = new ArrayList<Route>();
				map.put(r.getUserAircraftId(), list);
			}
			list.add(r);
		}
		List<Route> wholeRoutes = new ArrayList<Route>();

		// populate map with routes of DayNum(90) days
		for(int userAircraftId : map.keySet()){
			List<Route> list = map.get(userAircraftId);
			Route head = list.get(0);
			Route tail = list.get(list.size()-1);
			int dayDelta = 0;
			if(isBefore(tail.getArrivalTime(), head.getDepartureTime())){
				dayDelta = (tail.getArrivalDay()-head.getDepartureDay());
			}else{
				dayDelta = tail.getArrivalDay()-head.getDepartureDay()+1;
			}
			int originalDelta = dayDelta;
			int currentDay = tail.getArrivalDay();
			List<Route> newlist = new ArrayList<Route>();
			newlist.addAll(list);
			// repeat each user's routes list until 90 days
			while(true){
				boolean flag = false;
				for(Route r : list){
					Route copy = r.getCopy();
					copy.setDepartureDay(r.getDepartureDay()+dayDelta);
					copy.setArrivalDay(r.getArrivalDay()+dayDelta);
					newlist.add(copy);
					currentDay = copy.getArrivalDay();
					if(currentDay>numberDays){
						flag = true;
						break;
					}
				}
				if(flag) break;
				dayDelta += originalDelta;
			}
			map.put(userAircraftId, newlist);
			wholeRoutes.addAll(newlist);
		}
		//key - airportId Value:Map<Key:day Value:List<ROUTE>>
		Map<Integer, Map<Integer,List<Route>>> airportMap = new HashMap<Integer,Map<Integer,List<Route>>>();
		for(int id : map.keySet()){
			List<Route> list = map.get(id);
			for(Route r : list){
				Map<Integer,List<Route>> dayMap = airportMap.get(r.getFromAirport());
				if(dayMap == null){
					dayMap = new HashMap<Integer,List<Route>>();
					airportMap.put(r.getFromAirport(), dayMap);
				}
				List<Route> routes = dayMap.get(r.getDepartureDay());
				if(routes == null){
					routes = new ArrayList<Route>();
					dayMap.put(r.getDepartureDay(), routes);
					
				}
				routes.add(r);
			}
		}
		for(int airportId : airportMap.keySet()){
			Airport airport = airports.get(airportId);
			
			Map<Integer,List<Route>> dayMap = airportMap.get(airportId);
			for(int day: dayMap.keySet()){
				List<Route> routesOfDay = dayMap.get(day);
				assignSeat(routesOfDay,airport);
			}
		}
		calculateProfit(wholeRoutes);
	}
	
	private void calculateProfit(List<Route> routes){
		Calendar calendar = Calendar.getInstance();
		String time = calendar.getTime().toString();
		userProfitDao.clearSimulateTime();
		userProfitDao.storeSimulateTime(time);
		Map<Integer,Double> userProfitMap = new HashMap<Integer,Double>();
		Map<Integer,Aircraft> userCraftMap = new HashMap<Integer,Aircraft>();
		for(Route route : routes){
			
			int userPlaneId = route.getUserAircraftId();
			Aircraft a = userCraftMap.get(userPlaneId);
			if(a == null){
				a = aircraftDao.getPlaneByUserAircraftId(userPlaneId).get(0);
				userCraftMap.put(userPlaneId, a);
			}
			int userId = route.getUserId();
			int peopleOnBoard = route.getPeopleOnboard();
			double firstClassRatio = a.getFirstClassRatio()/100d;
			double busClassRatio = a.getBusinessClassRatio()/100d;
			double econClassRatio = (100d - firstClassRatio -busClassRatio)/100d;
			// profit unit is cent
			double profit = peopleOnBoard*econClassRatio*basicProfit
					+ peopleOnBoard*busClassRatio*basicProfit*1.25
					+ peopleOnBoard*firstClassRatio*basicProfit*1.5;
			
			Airport fromAirport = airports.get(route.getFromAirport());
			Airport toAirport = airports.get(route.getToAirport());
			double distanceInMile = airportService.distance(fromAirport, toAirport);
			profit *= distanceInMile;
			double cost = toAirport.getLandingFee() + getFlyTime(route.getDepartureTime(),route.getArrivalTime())*a.getFuelBurn()*fuelPrice;
			double netRevenue = profit/100 - cost;
			Double userprofit = userProfitMap.get(userId);
			if(userprofit == null){
				userprofit = netRevenue;
			}else{
				userprofit += netRevenue;
			}
			userProfitMap.put(userId, userprofit);
		}
		userProfitDao.clearUserProfit();
		// store to db
		for(int userId : userProfitMap.keySet()){
			userProfitDao.storeUserProfit(userId, userProfitMap.get(userId));
		}
	}
	
	private void assignSeat(List<Route> routesOfDay, Airport airport){
		int timezone = airport.getTimeZone();
		Map<Integer,List<Demand>> clustermap = demands.get(timezone);
		Map<Integer,List<Route>> clusterRoutes = new HashMap<Integer,List<Route>>();
		for(Route r :routesOfDay){
			boolean found = false;
			for(int cluster : clustermap.keySet()){
				List<Demand> dlist = clustermap.get(cluster);
				for(Demand d : dlist){
					if(d.getZulu()==Integer.valueOf(r.getDepartureTime().split(":")[0])){
						List<Route> routes = clusterRoutes.get(cluster);
						if(routes == null){
							routes = new ArrayList<Route>();
							clusterRoutes.put(cluster, routes);
						}
						routes.add(r);
						found = true;
						break;
					}
				}
				if(found)break;
			}
		}
		
		for(int cluster : clusterRoutes.keySet()){
			double ratio = clustermap.get(cluster).get(0).getAmount();
			double totalnum = (double)airport.getScaled()*ratio/100;
			List<Route> routes = clusterRoutes.get(cluster);
			int totalweight = 0;
			for(Route r : routes){
				totalweight += airports.get(r.getToAirport()).getScaled();
			}
			for(Route r : routes){
				double percent = (double)airports.get(r.getToAirport()).getScaled()/(double)totalweight;
				int seat = (int)(totalnum * percent);
				r.setPeopleOnboard(seat);
			}
			
		}
	}
	
	private boolean isBefore(String t1, String t2){
		String[] time1 = t1.split(":");
		String[] time2 = t2.split(":");
		int hour1 = Integer.valueOf(time1[0]);
		int hour2 = Integer.valueOf(time2[0]);
		int min1 = Integer.valueOf(time1[1]);
		int min2 = Integer.valueOf(time2[1]);
		return hour1<hour2 || (hour1==hour2 && min1<min2);
		
	}
	
	private double getFlyTime(String departTime, String arrivalTime){
		String[] time1 = departTime.split(":");
		String[] time2 = arrivalTime.split(":");
		int hour1 = Integer.valueOf(time1[0]);
		int hour2 = Integer.valueOf(time2[0]);
		int min1 = Integer.valueOf(time1[1]);
		int min2 = Integer.valueOf(time2[1]);
		if(hour2<hour1) hour2+= 24;
		int minsDelta = (hour2-hour1)*60+min2-min1;
		double result = (double)minsDelta/60d;
		return result;
	}
	

	@Override
	public List<UserProfit> getProfits() {
		List<UserProfit> result =  userProfitDao.getAllProfit();
		int rank = 1;
		for(UserProfit up : result){
			up.setRank(rank++);
		}
		return result;
	}

	@Override
	public String getSimulateRunTime() {
		return userProfitDao.getSimulateTime();
	}

	public AircraftDAO getAircraftDao() {
		return aircraftDao;
	}

	public void setAircraftDao(AircraftDAO aircraftDao) {
		this.aircraftDao = aircraftDao;
	}

	public AirportDAO getAirportDao() {
		return airportDao;
	}

	public void setAirportDao(AirportDAO airportDao) {
		this.airportDao = airportDao;
	}

	public RouteDAO getRouteDao() {
		return routeDao;
	}

	public void setRouteDao(RouteDAO routeDao) {
		this.routeDao = routeDao;
	}

	public DemandDAO getDemandDao() {
		return demandDao;
	}

	public void setDemandDao(DemandDAO demandDao) {
		this.demandDao = demandDao;
	}

	public UserProfitDAO getUserProfitDao() {
		return userProfitDao;
	}

	public void setUserProfitDao(UserProfitDAO userProfitDao) {
		this.userProfitDao = userProfitDao;
	}

	public AirportService getAirportService() {
		return airportService;
	}

	public void setAirportService(AirportService airportService) {
		this.airportService = airportService;
	}


	
	

}
