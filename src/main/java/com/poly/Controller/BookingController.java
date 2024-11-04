package com.poly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.Entity.Account;
import com.poly.Service.AccountService;
import com.poly.Service.AuthService;

@Controller
public class BookingController {
	@Autowired
	AuthService auth;
	@Autowired
	AccountService accountService;
		@RequestMapping("booking/checkout")
		public String checkout(Model model)
		{
			Account account = accountService.findbyID(auth.getUsername());
			model.addAttribute("account",account);
			return "/booking/checkout";
		}
}
