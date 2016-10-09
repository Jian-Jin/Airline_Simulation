package com.demo.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.model.Route;

public interface RouteDAO {

	List<Route> getRoutes(@Param(value = "userId") int userId, @Param(value = "aircraftId") int aircraftId);
	void addRoute(@Param(value = "userId") int userId,@Param(value = "aircraftId") int aircraftId,@Param(value = "fromAirport") int fromAirport,  @Param(value = "departureTime") String departureTime,
					@Param(value = "toAirport") int toAirport, @Param(value = "arrivalTime") String arrivalTime,
					@Param(value = "sequence") int sequence);

}
