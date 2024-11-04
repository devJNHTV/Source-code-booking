package com.poly.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="Rooms")
public class Room {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
		private String name;
		private Double price;
		private Boolean status;
		private String description;
		// converter
		@Convert(converter = PhotoConverter.class)
		private List<String> photo;
		@ManyToOne
	    @JoinColumn(name = "Areaid")
	    private Area area;
		@ManyToOne
	    @JoinColumn(name ="Kindid")
	    private KindRoom kindroom;
		 @JsonIgnore
		@OneToMany(mappedBy = "room")
	    private List<Review> reviews;
}
