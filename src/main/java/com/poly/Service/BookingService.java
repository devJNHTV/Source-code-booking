package com.poly.Service;



import com.fasterxml.jackson.databind.JsonNode;
import com.poly.Entity.Account;
import com.poly.Entity.Booking;

public interface BookingService {

	Booking create(JsonNode bookingData);

	Booking findByID(Integer id);

	

	
	

}
