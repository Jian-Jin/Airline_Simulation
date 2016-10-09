package com.demo.model;
// to match with db table route
public class Route {
	private int userId;
	private int aircraftId;
	private int fromAirport;
	private int toAirport;
	private String departureTime;
	private String arrivalTime;
	private int sequence;
	
	private String departureAirportName;
	private String arrivalAirportName;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAircraftId() {
		return aircraftId;
	}
	public void setAircraftId(int aircraftId) {
		this.aircraftId = aircraftId;
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
	

}
