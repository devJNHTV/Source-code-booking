package com.poly.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="Bookingdetails")
public class BookingDetail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double price;
	private Integer quantity;
	private Integer servicedays;
	
	@ManyToOne
    @JoinColumn(name = "Serviceid")
	private Service service;
	
	@ManyToOne
    @JoinColumn(name = "Bookingid")
	private Booking booking;
	
	@ManyToOne
    @JoinColumn(name = "Roomid")
	private Room Room;

}
