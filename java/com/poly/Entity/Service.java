package com.poly.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
<<<<<<< HEAD
=======
import lombok.Builder;
>>>>>>> 8bb0b7e (update code giao dien admin)
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Services")
<<<<<<< HEAD
=======
@Builder
>>>>>>> 8bb0b7e (update code giao dien admin)
public class Service {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private Double price;
	private String photo;
	 @JsonIgnore
	@OneToMany(mappedBy = "service")
    private List<BookingDetail> bookingDetails;
}
