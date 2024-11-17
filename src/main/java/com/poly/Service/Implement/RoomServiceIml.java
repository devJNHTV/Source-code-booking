package com.poly.Service.Implement;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.RoomDAO;
import com.poly.Entity.Room;
import com.poly.Service.RoomService;

@Service
public class RoomServiceIml  implements RoomService{
	@Autowired
	RoomDAO rDAO;
	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return rDAO.findAll();
	}
	@Override
	public Room findByID(Integer id) {
		// TODO Auto-generated method stub
		return rDAO.findById(id).get();
	}
	@Override
	public Room updateRoomStatus(Integer roomId, boolean updatedStatus) {
		 Room roomUpdated= rDAO.findById(roomId).get();
		 roomUpdated.setStatus(updatedStatus);
		 
		return rDAO.save(roomUpdated);
	}
	@Override
	public List<Room> findAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
		
		return rDAO.findAvailableRooms(checkIn, checkOut);
	}

}
