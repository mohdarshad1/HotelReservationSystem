package com.HotelReservationSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
	private static Map<String, Hotel> hotelMap;

	public HotelReservation() {
		hotelMap = new HashMap<>();
	}

	public boolean addHotel(String name, int regWeekdayRate) {
		Hotel hotelObject = new Hotel(name, regWeekdayRate);
		hotelMap.put(name, hotelObject);
		return true;
	}

	public boolean addHotel(String name, int regWeekdayRate, int regWeekendRate) {
		Hotel hotelObject = new Hotel(name, regWeekdayRate, regWeekendRate);
		hotelMap.put(name, hotelObject);
		return true;
	}

	public void printHotels() {
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			System.out.println("Hotel Name : " + entry.getKey());
			System.out.println("Rate on Weekdays for Regular Customers : " + entry.getValue().getRegWeekdayRate());
			System.out.println("Rate on Weekends for Regular Customers : " + entry.getValue().getRegWeekendRate());
			System.out.println();
		}
	}
	
	public String findCheapestHotel(String fromDate, String toDate) {
		Map<Integer, ArrayList<Hotel>> rentMap = createRentMap(fromDate, toDate);
		int minimumRent = Integer.MAX_VALUE;
		for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
			if (entry.getKey() < minimumRent)
				minimumRent = entry.getKey();
		}

		System.out.println("Cheapest Hotel for you is : " + rentMap.get(minimumRent).get(0).getHotelName());
		System.out.println("Total Rent : " + minimumRent);
		return rentMap.get(minimumRent).get(0).getHotelName();
	}
	
	public static Map<Integer, ArrayList<Hotel>> createRentMap(String fromDate, String toDate) {
		HashMap<Integer, ArrayList<Hotel>> rentMap = new HashMap<>();
		int numOfDays = numberOfDays(fromDate, toDate);
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			int rent = entry.getValue().getRegWeekdayRate() * numOfDays;
			rentMap.computeIfAbsent(rent, k -> new ArrayList<>()).add(entry.getValue());
		}
		return rentMap;
	}

	public static int numberOfDays(String fromDate, String toDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
		
		LocalDate from = LocalDate.parse(fromDate, formatter);    
		LocalDate to = LocalDate.parse(toDate, formatter);		 
		int numOfDays = 0;

		for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
			numOfDays++;
		}
		return numOfDays;
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Hotel Reservation Program");
	}
}