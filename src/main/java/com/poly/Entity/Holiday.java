package com.poly.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="Holidays")
public class Holiday {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
		private String name;
		@Temporal(TemporalType.DATE)
		@Column(name = "HolidayDate")
		private Date holidayDate = new Date();

}
