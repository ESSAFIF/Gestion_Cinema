package com.cinema.mvc.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="roles")
@Table(name="roles")
public class Roles implements Serializable{

	@Id
	@GeneratedValue
	private Long idRole;
	private String roleName;

	
	public Roles() {
	}



	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getIdRole() {
		return idRole;
	}



	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	
}
