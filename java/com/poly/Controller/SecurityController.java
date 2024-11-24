package com.poly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poly.Entity.Account;
import com.poly.Entity.Room;
import com.poly.Service.RoomService;

import jakarta.validation.Valid;

@Controller
public class SecurityController {
	
	 @RequestMapping("/security/login/form")
	public String home(Model model)
	{
		 model.addAttribute("account",new Account());
		return "/security/login";
	}
	@RequestMapping("/security/login/success")
	public  String loginSuccess(Model model)
	{
		model.addAttribute("msg","Login Successfully ");
		return "security/login";
	}
	@RequestMapping("/security/login/error")
	public  String failLogin(Model model, @ModelAttribute("account") @Valid Account account, BindingResult result)
	{
		
		model.addAttribute("msg","Invalid User or Password !!!");
		return "/security/login";
	}
	@RequestMapping("/security/unauthoried")
	public  String unthoried(Model model)
	{
		model.addAttribute("msg","Don't allow to access");
		return "/security/login";
	}
	@RequestMapping("/security/logoff/success")
	public  String Logoff(Model model)
	{
		model.addAttribute("msg","Sign out successfully");
		return "/security/login";
	}
}
