package com.demo.service;

import java.text.DecimalFormat;

public class Utils {
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
		return sb.reverse().toString();
		
	}
	// return "3.34" Million for example
	public static String convertToMillion(double money){
		double million = money / 1000000;
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(million)+" Million";
	}

}
