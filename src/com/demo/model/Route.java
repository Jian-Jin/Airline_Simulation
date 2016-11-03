package com.demo.model;

import com.demo.service.Utils;

// to match with db table route
public class Route {
	private int userId;
	private int userAircraftId;
	private int fromAirport;
	private int toAirport;
	private String departureTime;
	private String arrivalTime;
	private int sequence;
	private int departureDay;
	private int arrivalDay;
	
	private String departureAirportName;
	private String arrivalAirportName;
	// for simulation
	private int peopleOnboard;
	private Aircraft aircraft;
	
	private double cost;
	private double revenue;
	private double profit;
	
	
	// user and airplaneName only populated for profit page
	private User user;
	private String airplaneName;
	
	public Route getCopy(){
		Route r = new Route();
		r.setUserId(this.getUserId());
		r.setUserAircraftId(this.getUserAircraftId());
		r.setFromAirport(fromAirport);
		r.setToAirport(toAirport);
		r.setDepartureTime(departureTime);
		r.setArrivalTime(arrivalTime);
		r.setSequence(sequence);
		r.setAircraft(aircraft);
		return r;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserAircraftId() {
		return userAircraftId;
	}
	public void setUserAircraftId(int userAircraftId) {
		this.userAircraftId = userAircraftId;
	}
	public int getFromAirport() {
		return fromAirport;
	}
	public void setFromAirport(int fromAirport) {
		this.fromAirport = fromAirport;
	}
	public int getToAirport() {
		return toAirport;
	}
	public void setToAirport(int toAirport) {
		this.toAirport = toAirport;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getDepartureAirportName() {
		return departureAirportName;
	}
	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}
	public String getArrivalAirportName() {
		return arrivalAirportName;
	}
	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}
	public int getDepartureDay() {
		return departureDay;
	}
	public void setDepartureDay(int departureDay) {
		this.departureDay = departureDay;
	}
	public int getArrivalDay() {
		return arrivalDay;
	}
	public void setArrivalDay(int arrivalDay) {
		this.arrivalDay = arrivalDay;
	}
	public int getPeopleOnboard() {
		return peopleOnboard;
	}
	public void setPeopleOnboard(int peopleOnboard) {
		this.peopleOnboard = peopleOnboard;
	}
	public Aircraft getAircraft() {
		return aircraft;
	}
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAirplaneName() {
		return airplaneName;
	}
	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}
	public String getCostString(){
		return Utils.convertToComma(getCost());
	}
	public String getProfitString(){
		return Utils.convertToComma(getProfit());
	}
	public String getRevenueString(){
		return Utils.convertToComma(getRevenue());
	}
	

}
