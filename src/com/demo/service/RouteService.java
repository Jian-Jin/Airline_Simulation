package com.demo.service;

import java.util.List;

import com.demo.model.Route;

public interface RouteService {

	List<Route> getAircraftRoutes(int userId, String planeName);

	void addRoute(int userId, String planeToSet, String planeCurrentLocation, String depatureTime, String airportToGo);
	
}
