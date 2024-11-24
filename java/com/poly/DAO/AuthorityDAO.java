package com.poly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.Repository;

import com.poly.Entity.Account;
import com.poly.Entity.Authority;
import com.poly.Entity.Room;

@EnableJpaRepositories
public interface AuthorityDAO extends JpaRepository <Authority, Integer> {
	
}
