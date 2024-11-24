package com.poly.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.Entity.Room;
import com.poly.Service.RoomService;
@CrossOrigin("*")
@RestController
@RequestMapping("rest/rooms")
public class RoomRestController {
	@Autowired
	RoomService roomService;
	@GetMapping("{id}")
	public Room getOne(@PathVariable("id") Integer id) {
		return roomService.findByID(id);
	}
	@PutMapping("/{roomId}/status")
    public ResponseEntity<?> updateRoomStatus(@PathVariable Integer roomId, @RequestBody Map<String, Boolean> status) {
        try {
            boolean updatedStatus = status.get("status");
            Room updatedRoom = roomService.updateRoomStatus(roomId, updatedStatus);
            return ResponseEntity.ok(updatedRoom);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update room status");
        }
    }
}
