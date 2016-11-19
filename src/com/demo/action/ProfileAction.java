package com.demo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.model.Aircraft;
import com.demo.model.Airport;
import com.demo.model.User;
import com.demo.service.AircraftService;
import com.demo.service.AirportService;
import com.demo.service.RouteService;
import com.demo.service.UserService;
import com.demo.service.Utils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport {
	private User user;
	private List<Airport> userAirports;
	private List<Aircraft> userPlanes;
	private List<Airport> airportList;
	private String errorMsg;
	private UserService userService;
	private String balance;
	private AircraftService aircraftService;
	private AirportService airportService;
	private RouteService routeService;
	private String aircraftCustomizeNameToDelete;
	private String airportToChange;
	private String osudotNumber;
	private String password;

	public String getUserProfile() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		User curUser = userService.getUserById(userId);
		setBalance(Utils.convertToMillion(curUser.getMoney()));
		setUser(curUser);
		return SUCCESS;
	}

	public String getUserAirport() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		List<Airport> userAirports = airportService.getMyAirport(userId);
		setUserAirports(userAirports);
		List<Airport> changeList = airportService.getAllAirport();
		if (userAirports != null && userAirports.size() != 0) {
			for (Airport cur : changeList) {
				if (cur.getName().equals(userAirports.get(0).getName())) {
					changeList.remove(cur);
					break;
				}
			}
		}
		setAirportList(changeList);
		return SUCCESS;
	}

	public String getUserAircrafts() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		List<Aircraft> aircrafts = aircraftService.getUserPlanes(userId);
		setUserPlanes(aircrafts);
		return SUCCESS;
	}

	public String deleteUserAircrafts() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		if (aircraftCustomizeNameToDelete == null || aircraftCustomizeNameToDelete.isEmpty()) {
			setErrorMsg("Please choose an aircraft to delete");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		Aircraft deleteAirtcraft = null;
		List<Aircraft> userPlanes = aircraftService.getUserPlanes(userId);
		for (Aircraft aircraft : userPlanes) {
			if (aircraft.getCustomizedName().equals(aircraftCustomizeNameToDelete)) {
				deleteAirtcraft = aircraft;
				userPlanes.remove(aircraft);
				break;
			}
		}
		setUserPlanes(userPlanes);
		int user_aircraftId = aircraftService.getUserAircraftId(userId, aircraftCustomizeNameToDelete);
		double cost = deleteAirtcraft.getCost() * 1000000;
		// increase the money
		double money = userService.getUserMoney(userId);
		money += cost * 0.5;
		userService.updateUserMoney(userId, money);
		routeService.deleteUserRouteByAircraftId(userId, user_aircraftId);
		aircraftService.deleteUserAircraft(userId, aircraftCustomizeNameToDelete);
		return SUCCESS;
	}

	public String changeUserAirport() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		if (airportToChange == null || airportToChange.isEmpty()) {
			setErrorMsg("Please choose a hub to change");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		Airport newAirport = airportService.getAirport(airportToChange);
		Airport oldAirport = airportService.getMyAirport(userId).get(0);
		userAirports = new ArrayList<>();
		userAirports.add(newAirport);
		setUserAirports(userAirports);
		double newcost = newAirport.getCost() * 1000000;
		double oldcost = oldAirport.getCost() * 1000000;
		// change the money
		double money = userService.getUserMoney(userId);
		money = money + oldcost - newcost;
		userService.updateUserMoney(userId, money);
		routeService.deleteUserRoute(userId);
		airportService.updateUserAirport(userId, newAirport.getId());
		List<Airport> changeList = airportService.getAllAirport();
		for (Airport cur : changeList) {
			if (cur.getName().equals(newAirport.getName()))
				;
		}
		setAirportList(changeList);
		return SUCCESS;
	}

	public String updateOsudotnumber() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		if (osudotNumber == null || osudotNumber.isEmpty()) {
			setErrorMsg("Please enter your osu dot number");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		userService.updateUserOsudotnumber(userId, osudotNumber);
		User curUser = userService.getUserById(userId);
		setBalance(Utils.convertToMillion(curUser.getMoney()));
		setUser(curUser);
		return SUCCESS;
	}

	public String setOsudotnumber() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		User curUser = userService.getUserById(userId);
		setBalance(Utils.convertToMillion(curUser.getMoney()));
		setUser(curUser);
		return SUCCESS;
	}

	public String updatePassword() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		if (password == null || password.isEmpty()) {
			setErrorMsg("Please enter your new passwordr");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		userService.updatePassword(userId, password);
		User curUser = userService.getUserById(userId);
		setBalance(Utils.convertToMillion(curUser.getMoney()));
		setUser(curUser);
		return SUCCESS;
	}

	public String setPassword() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		User curUser = userService.getUserById(userId);
		setBalance(Utils.convertToMillion(curUser.getMoney()));
		setUser(curUser);
		return SUCCESS;
	}

	public List<Airport> getUserAirports() {
		return userAirports;
	}

	public void setUserAirports(List<Airport> userAirports) {
		this.userAirports = userAirports;
	}

	public List<Aircraft> getUserPlanes() {
		return userPlanes;
	}

	public void setUserPlanes(List<Aircraft> userPlanes) {
		this.userPlanes = userPlanes;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public AircraftService getAircraftService() {
		return aircraftService;
	}

	public void setAircraftService(AircraftService aircraftService) {
		this.aircraftService = aircraftService;
	}

	public AirportService getAirportService() {
		return airportService;
	}

	public void setAirportService(AirportService airportService) {
		this.airportService = airportService;
	}

	public RouteService getRouteService() {
		return routeService;
	}

	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}

	public String getAircraftCustomizeNameToDelete() {
		return aircraftCustomizeNameToDelete;
	}

	public void setAircraftCustomizeNameToDelete(String aircraftCustomizeNameToDelete) {
		this.aircraftCustomizeNameToDelete = aircraftCustomizeNameToDelete;
	}

	public List<Airport> getAirportList() {
		return airportList;
	}

	public void setAirportList(List<Airport> airportList) {
		this.airportList = airportList;
	}

	public String getAirportToChange() {
		return airportToChange;
	}

	public void setAirportToChange(String airportToChange) {
		this.airportToChange = airportToChange;
	}

	public String getOsudotNumber() {
		return osudotNumber;
	}

	public void setOsudotNumber(String osudotNumber) {
		this.osudotNumber = osudotNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
