package com.demo.service;

import java.util.List;
import com.demo.model.Airport;

public interface AirportService {
   public Airport getAirport(String name);

   double distance(Airport a1, Airport a2);
   
   public List<Airport> buyAirport(int userId, String airportName);
   
   public List<Airport> getAllAirport();

List<Airport> getMyAirport(int userId);
}
