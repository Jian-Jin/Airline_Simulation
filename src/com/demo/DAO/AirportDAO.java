package com.demo.DAO;

import org.apache.ibatis.annotations.Param;

import com.demo.model.Airport;

public interface AirportDAO {
	  public Airport getAirport(@Param(value = "name") String name);

}
