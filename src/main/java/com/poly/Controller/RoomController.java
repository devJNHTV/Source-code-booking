package com.poly.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
			
			LocalDate checkInd = LocalDate.now();
	        
	        // Lấy ngày tiếp theo
	        LocalDate checkOutd = checkInd.plusDays(1);
	        
	        // Chuyển đổi LocalDate thành Date nếu cần
	        Date checkIn = Date.from(checkInd.atStartOfDay(ZoneId.systemDefault()).toInstant());
	        Date checkOut = Date.from(checkOutd.atStartOfDay(ZoneId.systemDefault()).toInstant());
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedCheckIn = checkInd.format(formatter);
	        String formattedCheckOut = checkOutd.format(formatter);
	         List<Room> rooms= roomService.findAvailableRooms(checkInd, checkOutd);
			 model.addAttribute("rooms",rooms);
			 model.addAttribute("checkIn", formattedCheckIn);
			 model.addAttribute("checkOut",  formattedCheckOut);
			 

		return "room/list";
	}
	@RequestMapping("room/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id)
	{
		
		Room room = roomService.findByID(id);
		model.addAttribute("room", room);
		return "room/detail";
		
	}
	@GetMapping("room/list/available")
	public String detail(Model model,  @RequestParam LocalDate checkIn, @RequestParam LocalDate checkOut)
	{	
		List<Room> availableRooms = roomService.findAvailableRooms(checkIn, checkOut);
		    model.addAttribute("rooms",availableRooms);
		    
		    
		    Date checkInd = Date.from(checkIn.atStartOfDay(ZoneId.systemDefault()).toInstant());
	        Date checkOutd = Date.from(checkOut.atStartOfDay(ZoneId.systemDefault()).toInstant());
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedCheckIn = checkIn.format(formatter);
	        String formattedCheckOut = checkOut.format(formatter);
	        	
			 model.addAttribute("checkIn", formattedCheckIn);
			 model.addAttribute("checkOut",  formattedCheckOut);
        return "room/list";
		
	}
}
