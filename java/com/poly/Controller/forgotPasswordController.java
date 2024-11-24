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
public class forgotPasswordController {
	 @Autowired 
	 AccountService  accountService;
	 @Autowired
	 OTPService otpService;
	 @Autowired
	 MailService emailService;
	 @RequestMapping("/forgot/form")
	public String home(Model model)
	{
		
		return "forgot/form";
	}
	 @PostMapping("/forgotpassword")
	 public String forgot(@RequestParam String username, @RequestParam String email, Model model) {
	     // Kiểm tra username và email có tồn tại
	     Account account = accountService.findByUsernameAndEmail(username, email);
	     if (account == null) {
	         model.addAttribute("error", "Username hoặc email không tồn tại.");
	         return "forgot/form";
	     }

	     // Tạo OTP (sẽ triển khai chi tiết ở bước sau)
	     String otp = String.valueOf(new Random().nextInt(999999));
//
	     // Lưu OTP tạm thời (sẽ thực hiện ở bước tiếp theo)
	     otpService.saveOTP(username, otp);
//
	     // Gửi OTP qua email (thực hiện sau)
	     emailService.sendEmail(email, "OTP Reset Password", "Mã OTP của bạn là: " + otp);

	     // Điều hướng đến trang nhập OTP
	     return "redirect:/verify-otp?username=" + username;
	 }

	
}
