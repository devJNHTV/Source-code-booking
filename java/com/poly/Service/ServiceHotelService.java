package com.poly.Service;

import java.util.List;

import com.poly.Entity.Room;
import com.poly.Entity.Service;

public interface ServiceHotelService {

	List<Service> findAll();

	Service findByID(Integer id);

<<<<<<< HEAD
=======
	void delete(Integer id);

	Service save(Service service);

	Service update(Service service, Integer id);
>>>>>>> 8bb0b7e (update code giao dien admin)
}
