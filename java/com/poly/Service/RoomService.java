package com.poly.Service;

import java.time.LocalDate;
import java.util.List;

import com.poly.Entity.Room;


public interface RoomService {
	List<Room> findAll();

	Room findByID(Integer id);


	Room updateRoomStatus(Integer roomId, boolean updatedStatus);

	List<Room> findAvailableRooms(LocalDate checkIn, LocalDate checkOut);
}
