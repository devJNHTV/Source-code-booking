package com.poly.Service;

import java.util.List;

import com.poly.Entity.Room;


public interface RoomService {
	List<Room> findAll();

	Room findByID(Integer id);


	Room updateRoomStatus(Integer roomId, boolean updatedStatus);
}
