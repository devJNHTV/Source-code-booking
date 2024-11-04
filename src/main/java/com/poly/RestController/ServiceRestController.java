package com.poly.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.Entity.Room;
import com.poly.Entity.Service;
import com.poly.Service.RoomService;
import com.poly.Service.ServiceHotelService;
@CrossOrigin("*")
@RestController
@RequestMapping("rest/services")
public class ServiceRestController {
	@Autowired
	ServiceHotelService serviceHotelService;
	@GetMapping("{id}")
	public Service getOne(@PathVariable("id") Integer id) {
		return  serviceHotelService.findByID(id);
	}
}
