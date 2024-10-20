package com.poly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.Entity.Room;
import com.poly.Service.RoomService;

@Controller
public class HomeController {
	@Autowired 
	RoomService roomService;
	@RequestMapping({"/home","/home/index"})
	public String home()
	{
		return "/home/content";
	}
}
