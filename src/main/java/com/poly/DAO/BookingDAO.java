package com.poly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.Repository;

import com.poly.Entity.Account;
import com.poly.Entity.Booking;
import com.poly.Entity.BookingDetail;
import com.poly.Entity.Room;

@EnableJpaRepositories
public interface BookingDAO extends JpaRepository <Booking, Integer> {
	
}
