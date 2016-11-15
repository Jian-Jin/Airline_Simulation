package com.demo.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.model.Route;

public interface RouteDAO {

	List<Route> getRoutes(@Param(value = "userId") int userId, @Param(value = "userAircraftId") int userAircraftId);
	List<Route> getUserProfitRoutes(@Param(value = "userId") int userId);
	
	void addRoute(@Param(value = "userId") int userId,@Param(value = "userAircraftId") int userAircraftId,
			@Param(value = "fromAirport") int fromAirport,@Param(value = "toAirport") int toAirport,
			@Param(value = "departureTimeLocal") String departureTimeLocal,@Param(value = "departureDayLocal") int departureDayLocal,
			@Param(value = "arrivalTimeLocal") String arrivalTimeLocal,@Param(value = "arrivalDayLocal") int arrivalDayLocal,
			@Param(value = "departureTimeZulu") String departureTimeZulu,@Param(value = "departureDayZulu") int departureDayZulu,
			@Param(value = "arrivalTimeZulu") String arrivalTimeZulu,@Param(value = "arrivalDayZulu") int arrivalDayZulu,
			@Param(value = "sequence") int sequence, @Param(value = "flightTime") String flightTime );
	List<Route> getAllRoutes();
	
	
	public void deleteUserRouteByAircraftId(@Param(value = "userId") int userId,
											@Param(value = "userAircraftId")int userAircraftId);
	
	public void deleteUserRoute(@Param(value = "userId") int userId);
	
	public void undoUserRoute(@Param(value = "userAircraftId") int userAircraftId, @Param(value = "sequence") int sequence);

	public void updateProfit(@Param(value = "userAircraftId") int userAircraftId,@Param(value = "sequence") int sequence, 
			@Param(value = "cost") double cost,@Param(value = "revenue") double revenue,
			@Param(value = "profit") double profit,@Param(value = "competitorNum") int competitorNum,@Param(value = "seatsPurchased") int seatsPurchased);
}
