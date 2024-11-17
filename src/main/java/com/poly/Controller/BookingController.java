package com.poly.Controller;

import java.net.http.HttpRequest;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import com.poly.Entity.Account;
import com.poly.Entity.Booking;
import com.poly.Service.AccountService;
import com.poly.Service.AuthService;
import com.poly.Service.BookingService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookingController {
	@Autowired
	AuthService auth;
	@Autowired
	BookingService bookingService;
	@Autowired
	AccountService accountService;
		@RequestMapping("booking/checkout")
		public String checkout(Model model)
		{
			Account account = accountService.findbyID(auth.getUsername());
			model.addAttribute("account",account);
			return "/booking/checkout";
		}
		@RequestMapping("booking/detail/{id}")
		public String detailBooking(Model model, @PathVariable("id") Integer id)
		{
			Booking booking = bookingService.findByID(id);
			model.addAttribute("booking",booking);
			Account account = accountService.findbyID(auth.getUsername());
			model.addAttribute("account",account);
			return "booking/detail";
		}
		@RequestMapping("booking/list")
		public String listBooking(Model model, HttpServletRequest request)
		{
			String username= request.getRemoteUser();
			System.out.println(username);
			List<Booking> list = bookingService.findBookingByUserName(username);
			
			model.addAttribute("list",list);
			return "booking/list";
 		}
}
