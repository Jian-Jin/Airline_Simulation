package com.demo.model;

import com.demo.service.Utils;

// to match with db table route
public class Route {
	private int userId;
	private int userAircraftId;
	private int fromAirport;
	private int toAirport;
	private String departureTimeZulu;
	private String arrivalTimeZulu;
	private int sequence;
	private int departureDayZulu;
	private int arrivalDayZulu;
	
	private String departureAirportIdentifier;
	private String arrivalAirportIdentifier;
	// for simulation
	private int peopleOnboard;
	private Aircraft aircraft;
	
	private String departureTimeLocal;
	private int departureDayLocal;
	private String arrivalTimeLocal;
	private int arrivalDayLocal;
	// *hours*mins
	private String flightTime;
	
	private double cost;
	private double revenue;
	private double profit;
	
	private int seatsPurchased;
	private int competitorNum;
	// user and airplaneName only populated for profit page
	private User user;
	private String airplaneName;
	
	public Route getCopy(){
		Route r = new Route();
		r.setUserId(this.getUserId());
		r.setUserAircraftId(this.getUserAircraftId());
		r.setFromAirport(fromAirport);
		r.setToAirport(toAirport);
		r.setDepartureTimeZulu(departureTimeZulu);
		r.setArrivalTimeZulu(arrivalTimeZulu);
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

	public String getDepartureTimeZulu() {
		return departureTimeZulu;
	}
	public void setDepartureTimeZulu(String departureTimeZulu) {
		this.departureTimeZulu = departureTimeZulu;
	}
	public String getArrivalTimeZulu() {
		return arrivalTimeZulu;
	}
	public void setArrivalTimeZulu(String arrivalTimeZulu) {
		this.arrivalTimeZulu = arrivalTimeZulu;
	}
	public int getDepartureDayZulu() {
		return departureDayZulu;
	}
	public void setDepartureDayZulu(int departureDayZulu) {
		this.departureDayZulu = departureDayZulu;
	}
	public int getArrivalDayZulu() {
		return arrivalDayZulu;
	}
	public void setArrivalDayZulu(int arrivalDayZulu) {
		this.arrivalDayZulu = arrivalDayZulu;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	

	public String getDepartureAirportIdentifier() {
		return departureAirportIdentifier;
	}
	public void setDepartureAirportIdentifier(String departureAirportIdentifier) {
		this.departureAirportIdentifier = departureAirportIdentifier;
	}
	public String getArrivalAirportIdentifier() {
		return arrivalAirportIdentifier;
	}
	public void setArrivalAirportIdentifier(String arrivalAirportIdentifier) {
		this.arrivalAirportIdentifier = arrivalAirportIdentifier;
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
	
	
	
	public String getDepartureTimeLocal() {
		return departureTimeLocal;
	}
	public void setDepartureTimeLocal(String departureTimeLocal) {
		this.departureTimeLocal = departureTimeLocal;
	}
	public int getDepartureDayLocal() {
		return departureDayLocal;
	}
	public void setDepartureDayLocal(int departureDayLocal) {
		this.departureDayLocal = departureDayLocal;
	}
	public String getArrivalTimeLocal() {
		return arrivalTimeLocal;
	}
	public void setArrivalTimeLocal(String arrivalTimeLocal) {
		this.arrivalTimeLocal = arrivalTimeLocal;
	}
	public int getArrivalDayLocal() {
		return arrivalDayLocal;
	}
	public void setArrivalDayLocal(int arrivalDayLocal) {
		this.arrivalDayLocal = arrivalDayLocal;
	}
	
	
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	
	
	public int getSeatsPurchased() {
		return seatsPurchased;
	}
	public void setSeatsPurchased(int seatsPurchased) {
		this.seatsPurchased = seatsPurchased;
	}
	public int getCompetitorNum() {
		return competitorNum;
	}
	public void setCompetitorNum(int competitorNum) {
		this.competitorNum = competitorNum;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("userId:").append(userId);
		sb.append(",userAircraftId:").append(userAircraftId);
		sb.append(",fromAirport:").append(fromAirport);
		sb.append(",toAirport:").append(toAirport);
		sb.append(",departureTime:").append(departureTimeZulu);
		sb.append(",arrivalTime:").append(arrivalTimeZulu);
		sb.append(",sequence:").append(sequence);
		sb.append(",departureDay:").append(departureDayZulu);
		sb.append(",arrivalDay:").append(arrivalDayZulu);
		sb.append(",departureAirportName:").append(departureAirportIdentifier);
		sb.append(",arrivalAirportName:").append(arrivalAirportIdentifier);
		sb.append(",peopleOnboard:").append(peopleOnboard);
		sb.append(",aricraft:").append(aircraft==null?"":aircraft.getName());
		sb.append(",airplaneName:").append(airplaneName);

		sb.append(",cost:").append(cost);
		sb.append(",revenue:").append(revenue);
		sb.append(",profit:").append(profit);

		return sb.toString();
	}
	

}
