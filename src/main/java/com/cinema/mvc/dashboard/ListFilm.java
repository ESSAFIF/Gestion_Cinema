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
@Entity(name="listfilm")
@Table(name="listFilm")


public class ListFilm implements Serializable{
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long id;
@Column(name = "title")
private String title;
@Column(name = "name")
private String name;
@Column(name = "photo")
private String photo;
private Long num_cine;

public ListFilm() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Long getNum_cine() {
	return num_cine;
}

public void setNum_cine(Long num_cine) {
	this.num_cine = num_cine;
}

public String getPhoto() {
	return photo;
}

public void setPhoto(String photo) {
	this.photo = photo;
}



	
	
}