package com.poly.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="Vouchers")
public class Voucher {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 private String code;
	 private Boolean typeDiscount;
	 private Integer valueDiscount;
	 @Temporal(TemporalType.DATE)
	 @Column(name = "StartDate")
	 private Date startDate = new Date();
	 @Temporal(TemporalType.DATE)
	 @Column(name = "EndDate")
	 private Date endDate = new Date();
	 private Double minValue;
	 private Double maxDiscount;
	 private Integer usageLimit;
	 private String description;
	
}
