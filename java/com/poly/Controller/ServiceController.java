package com.poly.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.Entity.Room;
import com.poly.Service.RoomService;
import com.poly.Service.ServiceHotelService;

@Controller
public class ServiceController {
	@Autowired 
	ServiceHotelService serviceHotelService;
	@RequestMapping("service/list")
	public String list(Model model)
	{
			List<com.poly.Entity.Service> services= serviceHotelService.findAll();
			model.addAttribute("services",services);
		
		return "service/list";
	}
	
}
