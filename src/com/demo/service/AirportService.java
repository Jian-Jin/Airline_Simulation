package com.demo.service;

import com.demo.model.Airport;

public interface AirportService {
   public Airport getAirport(String name);

   double distance(Airport a1, Airport a2);
}
