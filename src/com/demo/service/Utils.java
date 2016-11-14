package com.demo.service;

import java.text.DecimalFormat;

public class Utils {
	public static int SUCCESS = 0;
	public static int TIMEERROR = 1;
	public static int AIRPORTERROR = 2;
	
	// convert money method
	public static String convertToComma(double money){
		int n = (int)money;
		boolean negative = n<0;
		n = Math.abs(n);
		String s = String.valueOf(n);
		char[] cc = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count=0;
		for(int i=cc.length-1;i>=0;i--){
			sb.append(cc[i]);
			count++;
			if(count%3==0&&i!=0){
				sb.append(",");
			}
		}
		return "$"+(negative?"-":"")+sb.reverse().toString();
		
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
	// input array --0:hour 1:timezone 2:day
	public static void convertFromLocalToZulu(int[] time){
		int hourLocal = time[0];
		int timeZone = time[1];
		int dayLocal = time[2];
		int hourZulu = hourLocal-timeZone;
		int dayZulu = dayLocal;
	
		if(hourZulu>24){
			hourZulu %= 24;
			dayZulu++;
		}
		time[0]=hourZulu;
		
		time[2]=dayZulu;
	}
	
	public static void convertFromZuluToLocal(int[] time){
		int hourZulu = time[0];
		int timeZone = time[1];
		int dayZulu = time[2];
		int dayLocal = dayZulu;
		int hourLocal = hourZulu+timeZone;
		if(hourLocal<0){
			hourLocal+= 24;
			dayLocal-- ;
		}
		
		
		time[0]=hourLocal;
		time[2]=dayLocal;
	
	}
	
	public static String getTimeString(int hour,int minute){
		String result = hour<10? "0"+hour :String.valueOf(hour) ;
		result += ":";
		result += minute<10?"0"+minute : String.valueOf(minute);
		return result;
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
	// return "**hours **mins"
	public static String getFlyTimeString(String departTime, String arrivalTime){
		String[] time1 = departTime.split(":");
		String[] time2 = arrivalTime.split(":");
		int hour1 = Integer.valueOf(time1[0]);
		int hour2 = Integer.valueOf(time2[0]);
		int min1 = Integer.valueOf(time1[1]);
		int min2 = Integer.valueOf(time2[1]);
		if(hour2<hour1) hour2+= 24;
		int minsDelta = (hour2-hour1)*60+min2-min1;
		int hours = minsDelta/60;
		int mins = minsDelta%60;
		StringBuilder sb = new StringBuilder();
		if(hours!=0){
			sb.append(hours);
			sb.append(hours==1?"hour ":"hours ");
		}
		if(mins!=0){
			sb.append(mins);
			sb.append(mins==1?"min ":"mins ");
		}
		return sb.toString();
	}

}
