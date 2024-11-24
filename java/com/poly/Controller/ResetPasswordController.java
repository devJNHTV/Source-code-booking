	package com.poly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.Entity.Account;
import com.poly.Entity.Room;
import com.poly.Service.AccountService;
import com.poly.Service.RoomService;

import jakarta.validation.Valid;

@Controller
public class ResetPasswordController {
	 @Autowired 
	 AccountService  accountService;
     @Autowired
	  private PasswordEncoder passwordEncoder;
	 @GetMapping("/reset-password")
	 public String reset(Model model, @RequestParam String username)
	 {
		model.addAttribute("username",username);
		return "forgot/resetform";
		 
	 }
	 @PostMapping("/reset-password")
	 public String resetpass(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword)
	 {
		 if (!password.equals(confirmPassword)) {
		        return "redirect:/reset-password?username=" + username + "&error=mismatch"; // Mật khẩu không khớp
		    }
		    Account account = accountService.findbyID(username);
		    account.setPassword(passwordEncoder.encode(password)); // Mã hóa mật khẩu
		    accountService.save(account);
		    return "redirect:/security/login/form";
	 }
	
	
}
