package com.poly.Entity;

import java.util.List;

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
@Table (name="BookingDetails")
public class BookingDetail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double price;
	private Integer quantity;
	private Integer serviceDays;
	@ManyToOne
    @JoinColumn(name = "ServiceID")
	private Service service;
	@ManyToOne
    @JoinColumn(name = "BookingID")
	private Booking booking;
	@ManyToOne
    @JoinColumn(name = "RoomID")
	private Room Room;

}
