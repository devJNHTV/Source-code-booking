package com.poly.Service.Implement;

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

}
