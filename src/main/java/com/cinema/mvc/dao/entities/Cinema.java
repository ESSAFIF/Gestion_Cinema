package com.cinema.mvc.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity(name="cinema")
@Table(name="cinema")
public class Cinema implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_cine")
    private Long numCine;
	@NotEmpty(message = "Please enter name" )
	private String name;
	@NotEmpty(message = "Please enter address" )
    private String address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cinema")
	private List<Projection> projectionList;
	

	public Cinema() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNumCine() {
		return numCine;
	}
	public void setNumCine(Long numCine) {
		this.numCine = numCine;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Projection> getProjectionList() {
		return projectionList;
	}
	public void setProjectionList(List<Projection> projectionList) {
		this.projectionList = projectionList;
	}
    
    

}
