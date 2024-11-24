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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.Entity.Account;
import com.poly.Entity.Room;
import com.poly.Service.AccountService;
import com.poly.Service.RoomService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
	 @Autowired 
	 AccountService  accountService;
	 @RequestMapping("/register/form")
	public String home(Model model)
	{
		 model.addAttribute("account",new Account());
		return "/register/register";
	}
	 @PostMapping("/register/save")
	 public String save(@ModelAttribute("account") Account  account,RedirectAttributes redirectAttributes)
	 {
		 accountService.save(account);
		 redirectAttributes.addFlashAttribute("successmsg", "Đăng ký thành công! Bạn có thể đăng nhập ngay bây giờ.");
		 return "redirect:/security/login/form";
		 
	 }
	
}
