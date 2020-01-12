package com.cinema.mvc.dao.entities;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class ProjectionPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)

    @Column(name = "num_cine")
    private long numCine;
    @Basic(optional = false)

    @Column(name = "num_film")
    private long numFilm;
    @Basic(optional = false)
   
    @Column(name = "pdate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")  
    private Date pdate;
    

    @Transient
    private String DateStringOut;
    

    @Transient
    @NotNull
    private String DateStringIn;
    
    public ProjectionPK() {
    }

    public ProjectionPK(long numCine, long numFilm, Date pdate) {
        this.numCine = numCine;
        this.numFilm = numFilm;
        this.pdate = pdate;
    }

    public long getNumCine() {
        return numCine;
    }

    public void setNumCine(long numCine) {
        this.numCine = numCine;
    }

    public long getNumFilm() {
        return numFilm;
    }

    public void setNumFilm(long numFilm) {
        this.numFilm = numFilm;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numCine;
        hash += (int) numFilm;
        hash += (pdate != null ? pdate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectionPK)) {
            return false;
        }
        ProjectionPK other = (ProjectionPK) object;
        if (this.numCine != other.numCine) {
            return false;
        }
        if (this.numFilm != other.numFilm) {
            return false;
        }
        if ((this.pdate == null && other.pdate != null) || (this.pdate != null && !this.pdate.equals(other.pdate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ProjectionPK[ numCine=" + numCine + ", numFilm=" + numFilm + ", pdate=" + pdate + " ]";
    }

	public String getDateStringOut() {
					  SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					    String DateStringOut= format.format(pdate);
		return DateStringOut;
	}

	public void setDateStringOut(String DateStringOut) {
		
		this.DateStringOut = DateStringOut;
	}

	public String getDateStringIn() {
		return DateStringIn;
	}

	public void setDateStringIn(String dateStringIn) {
		DateStringIn = dateStringIn;
	}
    
    

}
