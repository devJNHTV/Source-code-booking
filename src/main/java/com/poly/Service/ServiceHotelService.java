package com.poly.Service;

import java.util.List;

import com.poly.Entity.Room;
import com.poly.Entity.Service;

public interface ServiceHotelService {

	List<Service> findAll();

	Service findByID(Integer id);

}
