package com.poly.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.Entity.Room;
import com.poly.Service.RoomService;

@Controller
public class RoomController {
	@Autowired 
	RoomService roomService;
	@RequestMapping("room/list")
	public String list(Model model)
	{
			List<Room> rooms= roomService.findAll();
			model.addAttribute("rooms",rooms);
		
		return "room/list";
	}
}
