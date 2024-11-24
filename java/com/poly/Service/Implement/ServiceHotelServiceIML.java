package com.poly.Service.Implement;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 8bb0b7e (update code giao dien admin)

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
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
>>>>>>> 8bb0b7e (update code giao dien admin)
		return sDAO.findAll();
	}

	@Override
	public com.poly.Entity.Service findByID(Integer id) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return sDAO.findById(id).get();
	}

	

=======
		return sDAO.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		sDAO.deleteById(id);
	}

	@Override
	public com.poly.Entity.Service save(com.poly.Entity.Service service) {
		return sDAO.save(service);
	}

	@Override
	public com.poly.Entity.Service update(com.poly.Entity.Service service, Integer id) {
		return sDAO.findById(id).map(existingService -> {
			existingService.setName(service.getName());
			existingService.setDescription(service.getDescription());
			existingService.setPrice(service.getPrice());
			existingService.setPhoto(service.getPhoto());
			return sDAO.save(existingService);
		}).orElse(null);
	}
>>>>>>> 8bb0b7e (update code giao dien admin)

}
