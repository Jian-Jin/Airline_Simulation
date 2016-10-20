package com.demo.service;

import java.text.DecimalFormat;

public class Utils {
	public static int SUCCESS = 0;
	public static int TIMEERROR = 1;
	public static int AIRPORTERROR = 2;
	
	// convert money method
	public static String convertToComma(double money){
		int n = (int)money;
		String s = String.valueOf(n);
		char[] cc = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count=0;
		for(int i=cc.length-1;i>=0;i--){
			sb.append(cc[i]);
			count++;
			if(count%3==0){
				sb.append(",");
			}
		}
		return "$"+sb.reverse().toString();
		
	}
	// return "$3.34 Million" for example
	public static String convertToMillion(double money){
		if(money<=0)return "$0";
		double million = money / 1000000;
		DecimalFormat df = new DecimalFormat("#.00");
		return "$"+df.format(million)+" Million";
	}
	
	public static boolean isBefore(String t1, String t2){
		String[] time1 = t1.split(":");
		String[] time2 = t2.split(":");
		int hour1 = Integer.valueOf(time1[0]);
		int hour2 = Integer.valueOf(time2[0]);
		int min1 = Integer.valueOf(time1[1]);
		int min2 = Integer.valueOf(time2[1]);
		return hour1<hour2 || (hour1==hour2 && min1<min2);
		
	}
	// return how many minutes t2 is later than t1
	public static int minuteDiff(String t1, String t2, boolean dayPlus){
		String[] time1 = t1.split(":");
		String[] time2 = t2.split(":");
		int hour1 = Integer.valueOf(time1[0]);
		int hour2 = Integer.valueOf(time2[0]);
		int min1 = Integer.valueOf(time1[1]);
		int min2 = Integer.valueOf(time2[1]);
		if(hour2<hour1&&dayPlus) hour2+= 24;
		int minsDelta = (hour2-hour1)*60+min2-min1;
		return minsDelta;
		
	}
	
	public static double getFlyTime(String departTime, String arrivalTime){
		String[] time1 = departTime.split(":");
		String[] time2 = arrivalTime.split(":");
		int hour1 = Integer.valueOf(time1[0]);
		int hour2 = Integer.valueOf(time2[0]);
		int min1 = Integer.valueOf(time1[1]);
		int min2 = Integer.valueOf(time2[1]);
		if(hour2<hour1) hour2+= 24;
		int minsDelta = (hour2-hour1)*60+min2-min1;
		double result = (double)minsDelta/60d;
		return result;
	}

}
