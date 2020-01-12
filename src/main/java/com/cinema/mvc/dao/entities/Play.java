package com.cinema.mvc.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity(name="play")
@Table(name="play")
public class Play implements Serializable {
	 
	
	private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlayPK playPK;
    
	//@NotEmpty(message = "Please enter role" )
    private String role;
 
    @JoinColumn(name = "num_film", referencedColumnName = "num_film", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Film film;
    @JoinColumn(name = "num_ind", referencedColumnName = "num_ind", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Individual individual;
    

 
    public Play() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Play(PlayPK playPK) {
        this.playPK = playPK;
    }

    public Play(long numInd, long numFilm) {
        this.playPK = new PlayPK(numInd, numFilm);
    }

    public PlayPK getPlayPK() {
        return playPK;
    }

    public void setPlayPK(PlayPK playPK) {
        this.playPK = playPK;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }




}


