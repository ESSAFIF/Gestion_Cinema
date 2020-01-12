package com.cinema.mvc.unitaire;

import com.cinema.mvc.dao.FilmDAO;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.service.FilmService;
import com.cinema.mvc.service.FilmServiceImpl;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;


@RunWith(MockitoJUnitRunner.class)
public class FilmServiceImplTest1 {
	@InjectMocks
	private FilmServiceImpl classUnderTest;
	
	@Mock
	private FilmDAO filmDao;
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void shouldFindAllReturnEmptyList() {

		// Given
		when(filmDao.findAll()).thenReturn(new ArrayList<Film>());
		// When
		List<Film> result = classUnderTest.findAll();

		// Then
		assertThat(result).isEmpty();
		
	}
	@Test
	public void shouldFindAllReturnNotEmptyList() {

		// Given
		Individual ind =new Individual(1L,"GG","G");
		
		//Film film = new Film( 1L, "F1", "D1",2008L,"",ind);
		
		List<Film> films = new ArrayList<Film>();
		//films.add(film);
		when(filmDao.findAll()).thenReturn(films);

		// When
		List<Film> result = classUnderTest.findAll();

		// Then
		assertThat(result).isEqualTo(films);
	}
	
	@Test
	public void main() {
		
		//StoredProcedureQuery query = em.createStoredProcedureQuery("stat_film");
		//query.execute();
		//List result = query.getResultList();
	
		Query query = em.createNamedQuery("call_stat_film");
		List result = query.getResultList();   
			//List results = query.getResultList();
		
		System.out.println("Now the output is redirected!" + result);
	
	}

}
