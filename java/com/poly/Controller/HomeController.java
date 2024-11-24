package com.poly.Controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.Entity.Room;
import com.poly.Service.RoomService;

=======
import com.poly.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

>>>>>>> 8bb0b7e (update code giao dien admin)
@Controller
public class HomeController {
	@Autowired 
	RoomService roomService;
<<<<<<< HEAD
	@RequestMapping({"/home","/home/index"})
=======
	@RequestMapping({"/home","/home/index","/"})
>>>>>>> 8bb0b7e (update code giao dien admin)
	public String home()
	{
		return "/home/content";
	}
}
