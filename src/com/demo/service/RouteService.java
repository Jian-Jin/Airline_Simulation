package com.demo.service;

import java.util.List;

import com.demo.model.Route;

public interface RouteService {

	public List<Route> getAircraftRoutes(int userId, String planeName);

	int addRoute(int userId, String planeToSet, String planeCurrentLocation, String depatureTimeLocal, String airportToGo, int dayPlus);

	
	public void deleteUserRouteByAircraftId(int userId, int aircraftId);
	
	public void deleteUserRoute(int userId);
	
	public void undoUserRoute(int userId, String planeName);

	public List<Route> getProfitDetails(int userId);
}
