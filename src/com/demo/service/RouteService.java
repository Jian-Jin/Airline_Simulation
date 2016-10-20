package com.demo.service;

import java.util.List;

import com.demo.model.Route;

public interface RouteService {

	public List<Route> getAircraftRoutes(int userId, String planeName);

	public void addRoute(int userId, String planeToSet, String planeCurrentLocation, String depatureTime, String airportToGo);
	
	public void deleteUserRouteByAircraftId(int userId, int aircraftId);
}
