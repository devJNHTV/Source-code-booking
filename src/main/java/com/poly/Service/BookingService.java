package com.poly.Service;



import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.Entity.Account;
import com.poly.Entity.Booking;

public interface BookingService {

	Booking create(JsonNode bookingData);

	Booking findByID(Integer id);

	List<Booking> findBookingByUserName(String username);

	

	
	

}
