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
	 private Boolean typediscount;
	 private Integer valuediscount;
	 @Temporal(TemporalType.DATE)
	 @Column(name = "Startdate")
	 private Date startdate = new Date();
	 @Temporal(TemporalType.DATE)
	 @Column(name = "Enddate")
	 private Date enddate = new Date();
	 private Double minvalue;
	 private Double maxdiscount;
	 private Integer usagelimit;
	 private String description;
	
}
