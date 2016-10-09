package com.demo.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.model.Airport;

public interface AirportDAO {
	  public Airport getAirportByName(@Param(value = "name") String name);
	  
	  public void buyAirport(@Param(value = "userId") int userId, @Param(value = "airportId") int airportId);
	  
	  public List<Airport> getAirportsByUserId(@Param(value = "userId") int userId);
	  
	  public List<Airport> getAllAitport();
	  
}
