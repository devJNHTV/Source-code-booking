package com.poly.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class OTPService {
    private final Map<String, String> otpStorage = new HashMap<>();

    public void saveOTP(String username, String otp) {
        otpStorage.put(username, otp);
    }

    public boolean validateOTP(String username, String otp) {
        return otp.equals(otpStorage.get(username));
    }

    public void clearOTP(String username) {
        otpStorage.remove(username);
    }
    public boolean verifyOtp(String username, String otp) {
        return otp.equals(otpStorage.get(username));
    }
}