package com.qa.facebook.util;

public class TimeUtil {
	
	//How to handle synechronization problem in your project/ what are the wait command you have used in your project
	//Static wait --> Thread.sleep(2000) -->2sec 
	//implicit wait --> this is applicable to wait for each and every scripts 
	// Explicit wait --> if you want to wait for some specific webelement 
	// Fluent Wait --> polling --> 1/2 sec
	
	//Static wait
	//1]sortwait
	//2]Medium wait
	//3]LongWait
	
	public static void shortWait() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void mediumWait() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void longWait() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
