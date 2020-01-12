package com.cinema.mvc.dao.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlayPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)

    @Column(name = "num_ind")
    private long numInd;
    @Basic(optional = false)
    @Column(name = "num_film")
    private long numFilm;

    public PlayPK() {
    }

    public PlayPK(long numInd, long numFilm) {
        this.numInd = numInd;
        this.numFilm = numFilm;
    }

    public long getNumInd() {
        return numInd;
    }

    public void setNumInd(long numInd) {
        this.numInd = numInd;
    }

    public long getNumFilm() {
        return numFilm;
    }

    public void setNumFilm(long numFilm) {
        this.numFilm = numFilm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numInd;
        hash += (int) numFilm;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayPK)) {
            return false;
        }
        PlayPK other = (PlayPK) object;
        if (this.numInd != other.numInd) {
            return false;
        }
        if (this.numFilm != other.numFilm) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PlayPK[ numInd=" + numInd + ", numFilm=" + numFilm + " ]";
    }
}
