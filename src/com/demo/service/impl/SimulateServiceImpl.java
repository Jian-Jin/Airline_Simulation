package com.demo.service.impl;

import java.util.*;

import org.springframework.beans.factory.InitializingBean;

import com.demo.DAO.AircraftDAO;
import com.demo.DAO.AirportDAO;
import com.demo.DAO.DemandDAO;
import com.demo.DAO.RouteDAO;
import com.demo.DAO.UserDAO;
import com.demo.DAO.UserProfitDAO;
import com.demo.model.Aircraft;
import com.demo.model.Airport;
import com.demo.model.Demand;
import com.demo.model.Route;
import com.demo.model.UserProfit;
import com.demo.service.AirportService;
import com.demo.service.SimulateService;
import com.demo.service.Utils;

public class SimulateServiceImpl implements SimulateService, InitializingBean {
	private AircraftDAO aircraftDao;
	private AirportDAO airportDao;
	private RouteDAO routeDao;
	private DemandDAO demandDao;
	private UserProfitDAO userProfitDao;
	private AirportService airportService;
	private UserDAO userDao;

	private static int numberDays = 90;
	private double basicProfit = 0;
	private double fuelPrice = 0;
	private static double firstOfficerSuggestSalary = 75000;
	private static double captainSuggestSalary = 100000;
	// key airport ID
	private Map<Integer, Airport> airports = new HashMap<Integer, Airport>();
	// key: timezone -- key:cluster value:list of Demand
	private Map<Integer, Map<Integer, List<Demand>>> demands = new HashMap<Integer, Map<Integer, List<Demand>>>();

	@Override
	public void afterPropertiesSet() throws Exception {
		List<Airport> list = airportDao.getAllAirport();
		for (Airport a : list) {
			airports.put(a.getId(), a);
		}
		List<Demand> dlist = demandDao.getDemands();
		for (Demand d : dlist) {
			Map<Integer, List<Demand>> clusterMap = demands.get(d.getTimeZone());
			if (clusterMap == null) {
				clusterMap = new HashMap<Integer, List<Demand>>();
				demands.put(d.getTimeZone(), clusterMap);
			}
			List<Demand> l = clusterMap.get(d.getCluster());
			if (l == null) {
				l = new ArrayList<Demand>();
				clusterMap.put(d.getCluster(), l);
			}
			l.add(d);
		}
	}

	/* 
	 * The major logic of simulation run
	 * parameters are inputed from user
	 */
	@Override
	public void runSimulate(double fuelPrice, double basicProfit) {
		System.out.println("Started run simulation at " + new Date());
		List<String> downPlaneList = aircraftDao.getDownPlanes();
		Set<String> downPlanes = new HashSet<String>();
		downPlanes.addAll(downPlaneList);
		// use previous price if zero
		if (fuelPrice != 0)
			this.basicProfit = basicProfit;
		if (basicProfit != 0)
			this.fuelPrice = fuelPrice;
		List<Route> allRoutes = routeDao.getAllRoutes();
		// assign aircarft info to each route object
		assignAircraft(allRoutes);

		// key: userAircraftId, a unique id of table user_aircraft
		Map<Integer, List<Route>> map = new HashMap<Integer, List<Route>>();
		for (Route r : allRoutes) {
			List<Route> list = map.get(r.getUserAircraftId());
			if (list == null) {
				list = new ArrayList<Route>();
				map.put(r.getUserAircraftId(), list);
			}
			list.add(r);
		}
		List<Route> wholeRoutes = new ArrayList<Route>();

		// populate map with routes of DayNum(90) days by repeating each route cycle
		for (int userAircraftId : map.keySet()) {
			List<Route> list = map.get(userAircraftId);
			Route head = list.get(0);
			Route tail = list.get(list.size() - 1);
			int dayDelta = 0;
			if (Utils.isBefore(tail.getArrivalTimeZulu(), head.getDepartureTimeZulu())) {
				dayDelta = (tail.getArrivalDayZulu() - head.getDepartureDayZulu());
			} else {
				dayDelta = tail.getArrivalDayZulu() - head.getDepartureDayZulu() + 1;
			}
			int originalDelta = dayDelta;
			int currentDay = tail.getArrivalDayZulu();
			List<Route> newlist = new ArrayList<Route>();
			newlist.addAll(list);
			// repeat each user's routes list until 90 days
			while (true) {
				boolean flag = false;
				for (Route r : list) {
					Route copy = r.getCopy();
					copy.setDepartureDayZulu(r.getDepartureDayZulu() + dayDelta);
					copy.setArrivalDayZulu(r.getArrivalDayZulu() + dayDelta);
					newlist.add(copy);
					currentDay = copy.getArrivalDayZulu();
					if (currentDay > numberDays) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
				dayDelta += originalDelta;
			}
			map.put(userAircraftId, newlist);
			wholeRoutes.addAll(newlist);
		}
		// key - airportId Value:Map<Key:day(1-90) Value:List<ROUTE>>
		Map<Integer, Map<Integer, List<Route>>> airportMap = new HashMap<Integer, Map<Integer, List<Route>>>();
		for (int id : map.keySet()) {
			List<Route> list = map.get(id);
			for (Route r : list) {
				Map<Integer, List<Route>> dayMap = airportMap.get(r.getFromAirport());
				if (dayMap == null) {
					dayMap = new HashMap<Integer, List<Route>>();
					airportMap.put(r.getFromAirport(), dayMap);
				}
				List<Route> routes = dayMap.get(r.getDepartureDayZulu());
				if (routes == null) {
					routes = new ArrayList<Route>();
					dayMap.put(r.getDepartureDayZulu(), routes);

				}
				routes.add(r);
			}
		}
		for (int airportId : airportMap.keySet()) {
			Airport airport = airports.get(airportId);
			System.out.println("Simualtion airport:" + airport.getName());
			Map<Integer, List<Route>> dayMap = airportMap.get(airportId);
			for (int day : dayMap.keySet()) {
				System.out.println("Day:" + day);

				List<Route> routesOfDay = dayMap.get(day);
				assignSeat(routesOfDay, airport, downPlanes);
			}
		}
		calculateProfit(wholeRoutes);
	}

	private void assignAircraft(List<Route> routes) {
		for (Route route : routes) {
			int userPlaneId = route.getUserAircraftId();
			Aircraft a = aircraftDao.getPlaneByUserAircraftId(userPlaneId).get(0);
			route.setAircraft(a);

		}
	}

	class RouteProfit {
		public double cost = 0;
		public double revenue = 0;
		public double profit = 0;
		public int repeatTimes = 0;
		public int competitorNumTotal;
		public int seats;

		public RouteProfit() {
		}
	}

	private void calculateProfit(List<Route> routes) {
		// key:userAircraftId"#"sequence value:final profit
		Map<String, RouteProfit> routeProfitMap = new HashMap<String, RouteProfit>();
		Calendar calendar = Calendar.getInstance();
		String time = calendar.getTime().toString();
		userProfitDao.clearSimulateTime();
		userProfitDao.storeSimulateTime(time);
		// a map to store user's final profit
		Map<Integer, Double> userProfitMap = new HashMap<Integer, Double>();
		for (Route route : routes) {

			Aircraft a = route.getAircraft();
			int userId = route.getUserId();
			int peopleOnBoard = Math.min(a.getMaxSeat(), route.getPeopleOnboard());
			// adjust the demand based on staff salary
			peopleOnBoard = adjustDemandByStaffSalary(a, peopleOnBoard);
			peopleOnBoard = Math.min(a.getMaxSeat(), peopleOnBoard);
			double firstClassRatio = a.getFirstClassRatio() / 100d;
			double busClassRatio = a.getBusinessClassRatio() / 100d;
			double econClassRatio = (100d - firstClassRatio - busClassRatio) / 100d;
			// profit unit is cent
			double profit = peopleOnBoard * econClassRatio * basicProfit
					+ peopleOnBoard * busClassRatio * basicProfit * 1.25
					+ peopleOnBoard * firstClassRatio * basicProfit * 1.5;

			Airport fromAirport = airports.get(route.getFromAirport());
			Airport toAirport = airports.get(route.getToAirport());
			double distanceInMile = airportService.distance(fromAirport, toAirport);
			profit *= distanceInMile;
			double cost = toAirport.getLandingFee()
					+ Utils.getFlyTime(route.getDepartureTimeZulu(), route.getArrivalTimeZulu()) * a.getFuelBurn()
							* fuelPrice;
			double netProfit = profit / 100 - cost;
			Double userprofit = userProfitMap.get(userId);
			if (userprofit == null) {
				userprofit = netProfit;
			} else {
				userprofit += netProfit;
			}
			userProfitMap.put(userId, userprofit);
			String key = route.getUserAircraftId() + "#" + route.getSequence();
			RouteProfit routeProfit = routeProfitMap.get(key);
			if (routeProfit == null) {
				routeProfit = new RouteProfit();
				routeProfitMap.put(key, routeProfit);
			}
			routeProfit.cost += cost;
			routeProfit.revenue += profit / 100;
			routeProfit.profit += netProfit;
			routeProfit.repeatTimes++;
			routeProfit.competitorNumTotal += route.getCompetitorNum();
			routeProfit.seats += peopleOnBoard;
		}
		userProfitDao.clearUserProfit();
		deductStaffSalary(userProfitMap);
		// store to db the overall rank
		for (int userId : userProfitMap.keySet()) {
			userProfitDao.storeUserProfit(userId, userProfitMap.get(userId));
			// update user bank account
			userDao.addUserMoney(userId, userProfitMap.get(userId));
		}
		// update each route profit
		updateRouteProfit(routeProfitMap);
	}
	
	/**
	 * deduct the quarterly salary from user's profit
	 */
	private void deductStaffSalary(Map<Integer, Double> userProfitMap){
		for(int userId :userProfitMap.keySet()){
			double currentProfit = userProfitMap.get(userId);
			List<Aircraft> planes = aircraftDao.getUserPlanes(userId);
			for(Aircraft a : planes){
				currentProfit -= (a.getAttendantSalary()/4+a.getFirstOfficerSalary()/4
						+a.getCaptainSalary()/4+a.getSupportSalary()/4);
			}
			userProfitMap.put(userId, currentProfit);
			
		}
	}

	/*
	 * Make it 3 captains per aircraft and 3 first officers per aircraft.  
	 * Lets make demand between 0% and 49% = 0.  Between 50% - 99% = 75% and anything above 100% incease by 10% only. 
	 */
	private int adjustDemandByStaffSalary(Aircraft a, int peopleOnBoard) {
		double result = peopleOnBoard;
		double ratio1 = a.getCaptainSalary()/captainSuggestSalary;
		if(ratio1<0.5){
			result = 0;
		}else if(ratio1<1){
			result *= 0.75;
		}else{
			result *= 1.1;
		}
		
		double ratio2 = a.getFirstOfficerSalary()/firstOfficerSuggestSalary;
		if(ratio2<0.5){
			result = 0;
		}else if(ratio2<1){
			result *= 0.75;
		}else{
			result *= 1.1;
		}
		System.out.println("adjust demand for "+a.getCustomizedName()+" from "+peopleOnBoard + " to "+(int)result);
		return (int)result;
		
	}

	private void updateRouteProfit(Map<String, RouteProfit> routeProfitMap) {
		for (String key : routeProfitMap.keySet()) {
			RouteProfit rp = routeProfitMap.get(key);
			String[] ss = key.split("#");
			int userAircraftId = Integer.valueOf(ss[0]);
			int sequence = Integer.valueOf(ss[1]);
			int competitorAvg = rp.competitorNumTotal / rp.repeatTimes;
			int seatAvg = rp.seats / rp.repeatTimes;
			routeDao.updateProfit(userAircraftId, sequence, rp.cost, rp.revenue, rp.profit, competitorAvg, seatAvg);
		}
	}

	private void assignSeat(List<Route> routesOfDay, Airport airport, Set<String> downPlanes) {
		int timezone = airport.getTimeZone();
		Map<Integer, List<Demand>> clustermap = demands.get(timezone);
		Map<Integer, List<Route>> clusterRoutes = new HashMap<Integer, List<Route>>();
		for (Route r : routesOfDay) {
			// skip down planes when assign seats
			if (downPlanes.contains(r.getAircraft().getName()))
				continue;
			boolean found = false;
			for (int cluster : clustermap.keySet()) {
				List<Demand> dlist = clustermap.get(cluster);
				for (Demand d : dlist) {
					if (d.getZulu() == Integer.valueOf(r.getDepartureTimeZulu().split(":")[0])) {
						List<Route> routes = clusterRoutes.get(cluster);
						if (routes == null) {
							routes = new ArrayList<Route>();
							clusterRoutes.put(cluster, routes);
						}
						routes.add(r);
						found = true;
						break;
					}
				}
				if (found)
					break;
			}
		}

		for (int cluster : clusterRoutes.keySet()) {
			System.out.println("cluster:" + cluster);
			double ratio = clustermap.get(cluster).get(0).getAmount();
			double totalnum = (double) airport.getScaled() * airport.getMultiplier() * ratio / 100;
			List<Route> routes = clusterRoutes.get(cluster);
			int totalweight = 0;
			for (Route r : routes) {
				totalweight += airports.get(r.getToAirport()).getScaled();
				r.setCompetitorNum(routes.size() - 1);
			}
			for (Route r : routes) {
				double percent = (double) airports.get(r.getToAirport()).getScaled() / (double) totalweight;
				int seat = (int) (totalnum * percent);
				r.setPeopleOnboard(seat);
				System.out.println(r.toString());
			}

		}
	}

	@Override
	public List<UserProfit> getProfits() {
		List<UserProfit> result = userProfitDao.getAllProfit();
		int rank = 1;
		for (UserProfit up : result) {
			up.setRank(rank++);
			up.setProfitString(Utils.convertToComma(up.getProfit()));
			up.setBalanceString(Utils.convertToComma(up.getBalance()));
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

	@Override
	public void deleteUserProfit(int userId) {
		userProfitDao.deleteUserProfit(userId);

	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
