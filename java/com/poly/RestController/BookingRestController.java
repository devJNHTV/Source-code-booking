package com.poly.RestController;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.Entity.Booking;

import com.poly.Entity.Room;
import com.poly.Entity.Service;
import com.poly.Service.BookingService;
import com.poly.Service.RoomService;
import com.poly.Service.ServiceHotelService;
@CrossOrigin("*")
@RestController
@RequestMapping("rest/bookings")
public class BookingRestController {
	@Autowired
	BookingService bookingService;
	@GetMapping("{id}")
	public Booking getOne(@PathVariable("id") Integer id)
	{
		return bookingService.findByID(id);
		
	}
	@PostMapping()
	public Booking create(@RequestBody JsonNode order) {
		
		
		return bookingService.create(order);
		
	}
}
