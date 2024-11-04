package com.poly.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.RoomDAO;
import com.poly.DAO.SerViceDAO;
import com.poly.Entity.Room;
import com.poly.Service.RoomService;
import com.poly.Service.ServiceHotelService;

@Service
public class ServiceHotelServiceIML  implements ServiceHotelService{
	@Autowired
	SerViceDAO sDAO;

	@Override
	public List<com.poly.Entity.Service> findAll() {
		// TODO Auto-generated method stub
		return sDAO.findAll();
	}

	@Override
	public com.poly.Entity.Service findByID(Integer id) {
		// TODO Auto-generated method stub
		return sDAO.findById(id).get();
	}

	


}
