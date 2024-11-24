package com.poly.DAO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.poly.Entity.Room;

@EnableJpaRepositories
public interface RoomDAO extends JpaRepository <Room, Integer> {
	@Query("SELECT r FROM Room r WHERE r.status = TRUE " +
		       "OR NOT EXISTS (SELECT 1 FROM BookingDetail bd " +
		       "WHERE bd.Room.id = r.id " + // Đảm bảo rằng bạn sử dụng 'bd.room.id' chứ không phải 'bd.roomid'
		       "AND bd.booking.checkoutDate >= :checkIn " +
		       "AND bd.booking.checkinDate <= :checkOut)")
		List<Room> findAvailableRooms(@Param("checkIn") LocalDate checkIn, 
		                              @Param("checkOut") LocalDate checkOut);


}
