	package com.poly.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.poly.Service.MailService;
import com.poly.Service.OTPService;
import com.poly.Service.RoomService;

import jakarta.validation.Valid;

@Controller
public class OTPController {
	 @Autowired 
	 AccountService  accountService;
	 @Autowired
	 OTPService otpService;
	 @Autowired
	 MailService emailService;
	 @GetMapping("/verify-otp")
	 public String showOTPForm(@RequestParam String username, Model model) {
	     model.addAttribute("username", username);
	     return "forgot/otpform";
	 }
	 @PostMapping("/verify-otp")
	 public String verifyOtp(@RequestParam String username, @RequestParam String otp) {
	     if (otpService.verifyOtp(username, otp)) {
	    	 
	         return "redirect:/reset-password?username=" + username; // Chuyển đến form reset mật khẩu
	     } else {
	         return "redirect:/verify-otp?username=" + username + "&error=invalid"; // OTP không hợp lệ
	     }
	 }

	
}
