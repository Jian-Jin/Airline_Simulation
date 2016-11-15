package com.demo.model;

public class UserProfit {
	private int userId;
	private double profit;
	private String userName;
	private int rank;
	private double balance;
	
	private String profitString;
	private String balanceString;

	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getProfitString() {
		return profitString;
	}
	public void setProfitString(String profitString) {
		this.profitString = profitString;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBalanceString() {
		return balanceString;
	}
	public void setBalanceString(String balanceString) {
		this.balanceString = balanceString;
	}
	
	

}
