package com.poly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.Repository;

import com.poly.Entity.Account;
import com.poly.Entity.Room;
import com.poly.Entity.Service;

@EnableJpaRepositories
public interface SerViceDAO extends JpaRepository <Service, Integer> {
	
}