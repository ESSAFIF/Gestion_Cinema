

import java.util.List;

import com.cinema.mvc.dao.CinemaDAO;
import com.cinema.mvc.dao.CinemaDAOImpl;
import com.cinema.mvc.dao.entities.Cinema;

public class Test  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CinemaDAO cineService=new CinemaDAOImpl();
		
		List<Cinema> c=cineService.findAll();
		System.out.println("result: " + c);

	}

}
