package com.cinema.mvc.dao.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Entity(name="film")
@Table(name="film")

public class Film implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_film")
    private Long numFilm;
	
	@NotEmpty(message = "Please enter title" )
    private String title;
	@NotNull
	@Min(1900)
    private Long fyear;
	
    private String photo;
	@NotEmpty(message = "Please enter link" )
    private String video;
	
    private Long note_imdb;
  
	private Long note_allocine;
	@NotEmpty(message = "Please enter synopsis")
    private String synopsis;
	@NotEmpty(message = "Please enter duration")
    private String duration;
    private String country;
    @Transient
    private String YString;
    @Transient
    private String IdString;
  
	@JoinColumn(name = "num_ind")
    @ManyToOne
    private Individual individual;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
	private List<Play> playList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
	private List<Projection> projectionList;
	   
	@NotEmpty(message = "Please choise kind")
	private String  kind;
	

    @Column(name = "dateRelease")
    private Date dateRelease;

    @Transient
    private String DateStringOut;
	
    @Transient
    private String DateStringIn;
    
    
	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Individual getIndividual() {
		return individual;
	}
	public void setIndividual(Individual individual) {
		this.individual = individual;
	}
	public Long getNumFilm() {
		return numFilm;
	}
	public void setNumFilm(Long numFilm) {
		this.numFilm = numFilm;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getFyear() {
		return fyear;
	}
	public void setFyear(Long fyear) {
		this.fyear = fyear;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

	public String getYString() {
		return String.valueOf(fyear);
	
	}

	public String getIdString() {
		return String.valueOf(numFilm);
	}


	  public String getVideo() {
			return video;
		}


		public void setVideo(String video) {
			this.video = video;
		}


		public Long getNote_imdb() {
			return note_imdb;
		}


		public void setNote_imdb(Long note_imdb) {
			this.note_imdb = note_imdb;
		}


		public Long getNote_allocine() {
			return note_allocine;
		}


		public void setNote_allocine(Long note_allocine) {
			this.note_allocine = note_allocine;
		}


		public String getSynopsis() {
			return synopsis;
		}


		public void setSynopsis(String synopsis) {
			this.synopsis = synopsis;
		}


		public String getDuration() {
			return duration;
		}


		public void setDuration(String duration) {
			this.duration = duration;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public String getKind() {
			return kind;
		}


		public void setKind(String kind) {
			this.kind = kind;
		}


	

		public Date getDateRelease() {
			return dateRelease;
		}


		public void setDateRelease(Date dateRelease) {
			this.dateRelease = dateRelease;
		}


		public String getDateStringOut() {
						  SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						    String DateStringOut= format.format(dateRelease);
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
	    
	    public List<Play> getPlayList() {
			return playList;
		}


		public void setPlayList(List<Play> playList) {
			this.playList = playList;
		}


		public List<Projection> getProjectionList() {
			return projectionList;
		}


		public void setProjectionList(List<Projection> projectionList) {
			this.projectionList = projectionList;
		}



	
}
