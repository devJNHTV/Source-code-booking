package com.poly.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Orders")
public class Booking {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 @Temporal(TemporalType.DATE)
	 @Column(name = "CreateDate")
	 private Date createDate = new Date();
	 @Temporal(TemporalType.DATE)
	 @Column(name = "CheckinDate")
	 private Date checkinDate = new Date();
	 @Temporal(TemporalType.DATE)
	 @Column(name = "CheckoutDate")
	 private Date checkoutDate = new Date();
	 private Double price;
	 @ManyToOne
	 @JoinColumn(name = "username")
	 private Account account;
	 @ManyToOne
	 @JoinColumn(name = "RoomId")
	 private Room room;
	 @ManyToOne
	 @JoinColumn(name = "VoucherId")
	 private Voucher voucher;
	 @JsonIgnore
	 @OneToMany(mappedBy = "booking")
	 private List<BookingDetail> bookingDetails;
	 
	 
	 
}
