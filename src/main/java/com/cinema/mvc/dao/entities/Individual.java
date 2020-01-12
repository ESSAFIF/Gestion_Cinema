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

@Entity(name="individual")
@Table(name="individual")
public class Individual implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_ind")
    private Long numInd;
	@NotEmpty(message = "Please enter your name" )
    private String name;
	@NotEmpty(message = "Please enter your surname" )
    private String surname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "individual")
    private List<Play> playList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "individual")
	 private List<Film> filmList;
	 
	 public List<Film> getFilmList() {
		return filmList;
	 }

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
	}

	public Individual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Individual(Long numInd, String name, String surname) {
		super();
		this.numInd = numInd;
		this.name = name;
		this.surname = surname;
	}

	public Long getNumInd() {
		return numInd;
	}

	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setNumInd(Long numInd) {
		this.numInd = numInd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Play> getPlayList() {
		return playList;
	}

	public void setPlayList(List<Play> playList) {
		this.playList = playList;
	}

	

}
