package com.demo.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.model.Aircraft;

public interface AircraftDAO {
  public List<Aircraft> getPlane();
  public List<Aircraft> getPlaneByUserPlaneId(@Param(value = "userPlaneId") int userPlaneId);
  public int getPlaneUniqueId(@Param(value = "userId") int userId, @Param(value = "name") String name);
  public List<Aircraft> getUserPlanes(@Param(value = "userId") int userId);
  public List<Aircraft> getPlaneByName(@Param(value = "name") String name);
public void buyPlane(@Param(value = "userId") int userId, @Param(value = "aircraftId") int aircraftId,
		@Param(value = "customizedName") String customizedName, @Param(value = "firstClassRatio") double firstClassRatio,
		@Param(value = "businessClassRatio") double businessClassRatio);
public List<String> getDownPlanes();
public void cleanDownPlanes();
public void downPlane(String name);
public List<Aircraft> getPlaneByUserAircraftId(@Param(value = "userAircraftId") int userAircraftId);


public void deleteUserAircraft(@Param(value = "userId") int userId, 
								@Param(value = "customizedName") String customizedName);

}
  