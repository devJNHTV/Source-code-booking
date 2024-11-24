package com.poly.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Kindrooms")
public class KindRoom {
	@Id
	private String id;
	private String name;
    @JsonIgnore
	@OneToMany(mappedBy = "kindroom")
    private List<Room> rooms;
			
}
