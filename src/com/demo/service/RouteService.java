package com.demo.service;

import java.util.List;

import com.demo.model.Route;

public interface RouteService {

	public List<Route> getAircraftRoutes(int userId, String planeName);

	int addRoute(int userId, String planeToSet, String planeCurrentLocation, String depatureTime, String airportToGo, boolean dayPlus);

	
	public void deleteUserRouteByAircraftId(int userId, int aircraftId);
	
	public void deleteUserRoute(int userId);
}
