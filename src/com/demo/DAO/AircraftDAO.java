package com.demo.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.model.Aircraft;

public interface AircraftDAO {
  public List<Aircraft> getPlane();
  public int getPlaneId(@Param(value = "name") String name);
  public void buyPlane(@Param(value = "userId") int userId, @Param(value = "aircraftId") int aircraftId);
  public List<Aircraft> getPlanes(@Param(value = "userId") int userId);
}
  