package com.demo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.model.Aircraft;
import com.demo.service.AircraftService;
import com.demo.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AircraftAction extends ActionSupport {
	private AircraftService aircraftService;
	private UserService userService;
	private List<Aircraft> planes;
	private List<String> names;
	private List<Aircraft> userPlanes;
	private String aircraftToBuy;
	private String errorMsg;
	private String planeCustomizeName;
	private String firstClassRatio;
	private String businessClassRatio;
	private String aircraftsToDown;
	private String[] downAircrafts;

	private String captainSalary;
	private String firstOfficerSalary;
	private String attendantSalary;
	private String supportSalary;

	private String aircraftToSetSalary;
	private Aircraft aircraftToSet;
	
	public String getPlane() {
		if (planes == null) {
			planes = aircraftService.getPlane();
			names = new ArrayList<String>();
			for (Aircraft p : planes) {
				names.add(p.getName());
			}
		}
		return SUCCESS;
	}

	public String customizePlane() {
		Map session = ActionContext.getContext().getSession();
		String aircraftToBuy = (String) session.get("aircraftToBuy");
		double[] salary = (double[]) session.get("salary");
		Aircraft plane = aircraftService.getPlaneByName(aircraftToBuy).get(0);

		int userId = (Integer) session.get("userId");
		// TODO hard code below
		if (planeCustomizeName.isEmpty()
				|| (planeCustomizeName.contains("customized") && planeCustomizeName.contains("input"))) {
			setErrorMsg("invalid customized name,pls try again");
			return ERROR;
		}
		List<Aircraft> ownedAircrafts = aircraftService.getUserPlanes(userId);
		for (Aircraft a : ownedAircrafts) {
			if (a.getCustomizedName().equals(planeCustomizeName)) {
				setErrorMsg("this plane name already exists,pls try again");
				return ERROR;
			}
		}
		if (firstClassRatio == null || firstClassRatio.isEmpty() || businessClassRatio == null
				|| businessClassRatio.isEmpty()) {
			setErrorMsg("Please input a valid value of firstClassRatio and businessClassRatio ");
			return ERROR;
		}
		try {
			double d1 = Double.valueOf(firstClassRatio);
			double d2 = Double.valueOf(businessClassRatio);

			if (d1 >= 0 && d2 >= 0 && d1 + d2 <= 100) {
				List<Aircraft> list = aircraftService.buyPlane(userId, plane.getId(), planeCustomizeName, d1, d2,
						salary[0], salary[1], salary[2], salary[3]);
				setUserPlanes(list);
				double money = userService.getUserMoney(userId);
				// cost
				money -= plane.getCost() * 1000000;
				double sum = salary[0] * 3 + salary[1] * 3 + salary[2] * 7 + salary[3] * 10;
				money -= sum;
				userService.updateUserMoney(userId, money);
				session.put("money", money);
				return SUCCESS;
			} else {
				setErrorMsg("Please input a valid value of firstClassRatio and businessClassRatio ");
				return ERROR;
			}
		} catch (Exception e) {
			setErrorMsg("Please input a valid value of firstClassRatio and businessClassRatio ");
			return ERROR;
		}

	}

	public String setStaffSalary() {
		Map session = ActionContext.getContext().getSession();
		int userId = (Integer) session.get("userId");
		String aircraftToBuy = (String) session.get("aircraftToBuy");
		Aircraft plane = aircraftService.getPlaneByName(aircraftToBuy).get(0);
		double[] salary = new double[4];
		salary[0] = Double.valueOf(captainSalary);
		salary[1] = Double.valueOf(firstOfficerSalary);
		salary[2] = Double.valueOf(attendantSalary);
		salary[3] = Double.valueOf(supportSalary);
		double money = userService.getUserMoney(userId);
		double sum = salary[0] * 3 + salary[1] * 3 + salary[2] * 7 + salary[3] * 10;
		if (sum > money - plane.getCost() * 1000000) {
			setErrorMsg("Not enough money to pay all the salary.");
			return ERROR;
		}
		session.put("salary", salary);
		return SUCCESS;
	}
	
	public String updateStaffSalary() {
		Map session = ActionContext.getContext().getSession();
		int userId = (Integer) session.get("userId");
		String aircraftToSetSalary = (String) session.get("aircraftToSetSalary");
		
		Aircraft userAircraft = aircraftService.getUserPlaneByCumstomeizeName(userId, aircraftToSetSalary);
		double cs = Double.valueOf(captainSalary);
		double fs = Double.valueOf(firstOfficerSalary);
		double as = Double.valueOf(attendantSalary);
		double ss = Double.valueOf(supportSalary);
		double money = userService.getUserMoney(userId);
		//calculate the difference
		double difference = cs + fs + as + ss - (userAircraft.getCaptainSalary()+userAircraft.getFirstOfficerSalary() + userAircraft.getAttendantSalary() +userAircraft.getSupportSalary());
		if (difference > money) {
			setErrorMsg("Not enough money to pay all the salary.");
			return ERROR;
		}
		aircraftService.updateSalary(userId, aircraftToSetSalary, cs, fs, as, ss);
		money -= difference;
		userService.updateUserMoney(userId, money);
		List<Aircraft> aircrafts = aircraftService.getUserPlanes(userId);
		setUserPlanes(aircrafts);
		return SUCCESS;
	}
	
	public String gotoUpdateSalaryPage(){
		Map session = ActionContext.getContext().getSession();
		if (aircraftToSetSalary == null || aircraftToSetSalary.isEmpty()) {
			setErrorMsg("Please select an aircraft to set staff salary");
			int userId = (Integer) session.get("userId");
			List<Aircraft> aircrafts = aircraftService.getUserPlanes(userId);
			setUserPlanes(aircrafts);
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		Aircraft userAircraft = aircraftService.getUserPlaneByCumstomeizeName(userId, aircraftToSetSalary);
		setAircraftToSet(userAircraft);
		session.put("aircraftToSetSalary", aircraftToSetSalary);
		return SUCCESS;
	}
	
	public String aircraftStaff() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		int userId = (Integer) session.get("userId");
		List<Aircraft> aircrafts = aircraftService.getUserPlanes(userId);
		setUserPlanes(aircrafts);
		return SUCCESS;
	}

	public String buyPlane() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		if (aircraftToBuy == null || aircraftToBuy.isEmpty()) {
			setErrorMsg("Please choose an aircraft first");
			return ERROR;
		}
		Aircraft plane = aircraftService.getPlaneByName(aircraftToBuy).get(0);
		int userId = (Integer) session.get("userId");
		double money = userService.getUserMoney(userId);
		if (money < plane.getCost() * 1000000) {
			setErrorMsg("Not enough money to buy this aircraft.");
			return ERROR;
		}
		session.put("aircraftToBuy", aircraftToBuy);
		return SUCCESS;
	}

	// admin operations
	public String downAircraftHome() {
		Map session = ActionContext.getContext().getSession();

		if (session.get("logined") == null) {
			setErrorMsg("Please sign in first");
			return ERROR;
		}
		if (session.get("superuser") == null) {
			setErrorMsg("Please sign in as admin");
			return ERROR;
		}
		getPlane();
		List<String> downPlaneNames = aircraftService.getDownPlanes();
		downAircrafts = new String[downPlaneNames.size()];
		int i = 0;
		for (String s : downPlaneNames) {
			downAircrafts[i++] = s.trim();
		}

		return SUCCESS;
	}

	public String downAircraft() {
		List<String> planesToDown = new ArrayList<String>();
		if (aircraftsToDown != null && !aircraftsToDown.isEmpty()) {
			for (String s : aircraftsToDown.split(",")) {
				planesToDown.add(s);
			}
		}
		aircraftService.downPlanes(planesToDown);

		// refresh data
		getPlane();
		List<String> downPlaneNames = aircraftService.getDownPlanes();
		downAircrafts = new String[downPlaneNames.size()];
		int i = 0;
		for (String s : downPlaneNames) {
			downAircrafts[i++] = s.trim();
		}
		return SUCCESS;
	}

	public AircraftService getAircraftService() {
		return aircraftService;
	}

	public void setAircraftService(AircraftService aircraftService) {
		this.aircraftService = aircraftService;
	}

	public List<Aircraft> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Aircraft> planes) {
		this.planes = planes;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public String getAircraftToBuy() {
		return aircraftToBuy;
	}

	public void setAircraftToBuy(String aircraftToBuy) {
		this.aircraftToBuy = aircraftToBuy;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<Aircraft> getUserPlanes() {
		return userPlanes;
	}

	public void setUserPlanes(List<Aircraft> userPlanes) {
		this.userPlanes = userPlanes;
	}

	public String getPlaneCustomizeName() {
		return planeCustomizeName;
	}

	public void setPlaneCustomizeName(String planeCustomizeName) {
		this.planeCustomizeName = planeCustomizeName;
	}

	public String getFirstClassRatio() {
		return firstClassRatio;
	}

	public void setFirstClassRatio(String firstClassRatio) {
		this.firstClassRatio = firstClassRatio;
	}

	public String getBusinessClassRatio() {
		return businessClassRatio;
	}

	public void setBusinessClassRatio(String businessClassRatio) {
		this.businessClassRatio = businessClassRatio;
	}

	public String getAircraftsToDown() {
		return aircraftsToDown;
	}

	public void setAircraftsToDown(String aircraftsToDown) {
		this.aircraftsToDown = aircraftsToDown;
	}

	public String[] getDownAircrafts() {
		// return new String[]{"Airbus A318","Airbus A319"};
		return downAircrafts;
	}

	public void setDownAircrafts(String[] downAircrafts) {
		this.downAircrafts = downAircrafts;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getCaptainSalary() {
		return captainSalary;
	}

	public void setCaptainSalary(String captainSalary) {
		this.captainSalary = captainSalary;
	}

	public String getFirstOfficerSalary() {
		return firstOfficerSalary;
	}

	public void setFirstOfficerSalary(String firstOfficerSalary) {
		this.firstOfficerSalary = firstOfficerSalary;
	}

	public String getAttendantSalary() {
		return attendantSalary;
	}

	public void setAttendantSalary(String attendantSalary) {
		this.attendantSalary = attendantSalary;
	}

	public String getSupportSalary() {
		return supportSalary;
	}

	public void setSupportSalary(String supportSalary) {
		this.supportSalary = supportSalary;
	}

	public String getAircraftToSetSalary() {
		return aircraftToSetSalary;
	}

	public void setAircraftToSetSalary(String aircraftToSetSalary) {
		this.aircraftToSetSalary = aircraftToSetSalary;
	}

	public Aircraft getAircraftToSet() {
		return aircraftToSet;
	}

	public void setAircraftToSet(Aircraft aircraftToSet) {
		this.aircraftToSet = aircraftToSet;
	}
	
}
