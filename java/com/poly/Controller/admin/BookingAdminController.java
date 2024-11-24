package com.poly.Controller.admin;

import com.poly.DTO.response.Message;
import com.poly.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/booking")
@RequiredArgsConstructor
public class BookingAdminController {

    private  final BookingService bookingService;
    @GetMapping("")
    public ResponseEntity<Message> getBooking() {
        return new ResponseEntity<>(Message.builder()
                .status(true)
                .message("Danh sách booking")
                .code(200)
                .data(bookingService.findAll()).build(), HttpStatus.OK);
    }
}
