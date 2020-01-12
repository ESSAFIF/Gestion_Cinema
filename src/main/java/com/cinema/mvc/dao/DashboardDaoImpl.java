
package com.cinema.mvc.dao;

import com.cinema.mvc.dashboard.ListFilm;
import com.cinema.mvc.dashboard.StatCine;
import com.cinema.mvc.dashboard.StatFilm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;

public class DashboardDaoImpl implements DashboardDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<List<Map<Object, Object>>> getHistjsChartData() {

		
		 Map<Object,Object> map = null;
		 List<List<Map<Object,Object>>> list= new ArrayList<List<Map<Object,Object>>>();
		 List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		 
		   try
		    {
			   
			   StoredProcedureQuery storedProcedure1 = em.createStoredProcedureQuery("delete_statfilm");		 
			   storedProcedure1.execute();	
			   StoredProcedureQuery storedProcedure2 = em.createStoredProcedureQuery("stat_film");		 
				 storedProcedure2.execute();	
		    }
					  
			    catch (Exception e) {
			        e.printStackTrace();

			    }
		 
		   Query query1 = em.createQuery("select t from statfilm t");
		   List<StatFilm>stat1= query1.getResultList();
	    for(int i=0;i<stat1.size();i++ )
	    {
	    	StatFilm canvas = stat1.get(i);
	    	map = new HashMap<Object, Object>();
			
			map.put("label", canvas.getKind());
			map.put("y", canvas.getNb_film());
	    	dataPoints.add(map);	
	    	
	    }
    	list.add(dataPoints);
    	return list;
    	
			}	
	
	@Override
	public List<List<Map<Object, Object>>> getPiejsChartData(){
		
		
		 Map<Object,Object> map = null;
		 List<List<Map<Object,Object>>> list= new ArrayList<List<Map<Object,Object>>>();
		 List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		  try
		    {
			  StoredProcedureQuery storedProcedure3 = em.createStoredProcedureQuery("delete_statcine");		 
			   storedProcedure3.execute();	
			  StoredProcedureQuery storedProcedure4 = em.createStoredProcedureQuery("stat_cine");
				 storedProcedure4.execute();	
		    }
					  
			    catch (Exception e) {
			        e.printStackTrace();

			    }
		
			Query query2 = em.createQuery("select t from statcine t");
			List<StatCine>stat2= query2.getResultList();
			
			    for(int i=0;i<stat2.size();i++ )
			    {
			    	final StatCine canvas = stat2.get(i);
			    	map = new HashMap<Object, Object>();
					
					map.put("label", canvas.getCine());
					map.put("y", canvas.getNb_film());
			    	dataPoints.add(map);	
			    	
			    }
	    
		
		   list.add(dataPoints);
	    	return list;
		   
				    
	}
	
	@Override
	public List<ListFilm> findAll(){
		
		try
	    {
			 StoredProcedureQuery storedProcedure5 = em.createStoredProcedureQuery("delete_listfilm");		 
			   storedProcedure5.execute();	
		  StoredProcedureQuery storedProcedure6 = em.createStoredProcedureQuery("listFilm");
			 storedProcedure6.execute();	
	    }
				  
		    catch (Exception e) {
		        e.printStackTrace();

		    }
	 
		Query query3 = em.createQuery("select t from listfilm t");
		return query3.getResultList();
		
	  	
	}
	
	@Override
	public List<ListFilm> listCine(){
		
		try
	    {
		  StoredProcedureQuery storedProcedure7 = em.createStoredProcedureQuery("listFilm");
			 storedProcedure7.execute();	
	    }
				  
		    catch (Exception e) {
		        e.printStackTrace();

		    }
	 
		Query query4 = em.createQuery("SELECT name, num_cine from listfilm  group by name, num_cine");
		return query4.getResultList();
		
	  	
	}
	
	
} 