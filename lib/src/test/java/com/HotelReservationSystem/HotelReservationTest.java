package com.HotelReservationSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

 public class HotelReservationTest {

	@Test
	public void whenNewHotelAdded_shouldReturnTrue() {

		HotelReservation hotelReservationObject = new HotelReservation();
		assertTrue(hotelReservationObject.addHotel("Lakewood", 110));
		assertTrue(hotelReservationObject.addHotel("Bridgewood", 160));
		assertTrue(hotelReservationObject.addHotel("Ridgewood", 220));

		hotelReservationObject.printHotels();
	}
	
	@Test
	public void whenFindCheapestHotelMethodCalled_shouldReturn_nameOfHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220));
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("10Sep2020", "11Sep2020"));
	}
	
	@Test
	public void whenNewHotelAddedWithWeekend_shouldReturnTrue() {

		HotelReservation hotelReservationObject = new HotelReservation();
		assertTrue(hotelReservationObject.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservationObject.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservationObject.addHotel("Ridgewood", 110, 150));

		hotelReservationObject.printHotels();
	}
}