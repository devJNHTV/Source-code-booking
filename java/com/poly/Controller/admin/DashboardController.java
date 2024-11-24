package com.poly.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    @GetMapping("/home")
    public String home() {
        return "admin/main";
    }

    @GetMapping("/booking")
    public String booking() {
        return "admin/BookingManager";
    }

    @GetMapping("/service")
    public String service() {
        return "admin/ServiceManager";
    }

    @GetMapping("/save-service")
    public String saveService() {
        return "admin/SaveService";
    }

    @GetMapping("/save-service/{id}")
    public String saveServiceWithId(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        return "admin/SaveService";
    }
}
