package com.cinema.mvc.dashboard;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

import javax.persistence.EntityManager;
@Entity(name="statcine")
@Table(name="statCine")


public class StatCine implements Serializable{
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long id;

private String cine;
private Long nb_film;

public StatCine() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCine() {
	return cine;
}

public void setCine(String cine) {
	this.cine = cine;
}

public Long getNb_film() {
	return nb_film;
}

public void setNb_film(Long nb_film) {
	this.nb_film = nb_film;
}





	
	
}