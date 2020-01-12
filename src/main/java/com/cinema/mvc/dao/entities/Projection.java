package com.cinema.mvc.dao.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
@Table(name="projection")
@Entity(name="projection")
public class Projection implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @EmbeddedId
	    protected ProjectionPK projectionPK;
	    @JoinColumn(name = "num_cine", referencedColumnName = "num_cine", insertable = false, updatable = false)
	    @ManyToOne(optional = false)
	    private Cinema cinema;
	    @JoinColumn(name = "num_film", referencedColumnName = "num_film", insertable = false, updatable = false)
	    @ManyToOne(optional = false)
	    private Film film;

	    public Projection() {
	    }

	    public Projection(ProjectionPK projectionPK) {
	        this.projectionPK = projectionPK;
	    }

	    public Projection(Long numCine, Long numFilm, Date pdate) {
	        this.projectionPK = new ProjectionPK(numCine, numFilm, pdate);
	    }

	    public ProjectionPK getProjectionPK() {
	        return projectionPK;
	    }

	    public void setProjectionPK(ProjectionPK projectionPK) {
	        this.projectionPK = projectionPK;
	    }

	    public Cinema getCinema() {
	        return cinema;
	    }

	    public void setCinema(Cinema cinema) {
	        this.cinema = cinema;
	    }

	    public Film getFilm() {
	        return film;
	    }

	    public void setFilm(Film film) {
	        this.film = film;
	    }

	
	    

}

