package com.fuad.fleetMgt.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Country {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String capital;
	private String description;
	private String nationality;
	private String continent;
	
	@OneToMany(mappedBy="country")
	private List<State> states;

	
	public Integer getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getCapital() {
		return capital;
	}

	public String getDescription() {
		return description;
	}

	public String getNationality() {
		return nationality;
	}

	public String getContinent() {
		return continent;
	}
	
	
	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public List<State> getStates() {
		return states;
	}
	
	
	
}