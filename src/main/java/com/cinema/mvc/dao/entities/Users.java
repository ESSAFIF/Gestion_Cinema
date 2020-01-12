package com.cinema.mvc.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="users")
@Table(name="users")
public class Users implements Serializable{

	@Id
	@GeneratedValue
	private Long idUser;
	
	@NotEmpty(message = "Please enter your name" )
	private String name;
	
	@NotEmpty(message = "Please enter your surname" )
	private String surname;
	
	@NotEmpty(message = "Please enter your login")
	private String login;
	
	@Email(message = "invalid mail")
	@NotEmpty(message="Please enter valid email address")
	private String mail;
	
	@Size(max = 20, min = 3, message = "Please enter your password")
	private String passW;
	
	@Type(type = "numeric_boolean")
	private boolean actived;
	
	@JoinColumn(name = "idRole")
    @ManyToOne
	private Roles roles;
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}



	public boolean isActived() {
		return actived;
	}



	public void setActived(boolean actived) {
		this.actived = actived;
	}



	public Long getIdUser() {
		return idUser;
	}



	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getPassW() {
		return passW;
	}



	public void setPassW(String passW) {
		this.passW = passW;
	}

	public Roles getRoles() {
		return roles;
	}



	public void setRoles(Roles roles) {
		this.roles = roles;
	}





}
