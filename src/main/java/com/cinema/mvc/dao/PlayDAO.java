package  com.cinema.mvc.dao;
import java.util.List;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;

public interface PlayDAO {
	public void add(Play e);
	public Play edite(Play e);
	public void delete(PlayPK playpk);

	public List<Play> findAll();
	public Play findById(PlayPK playpk);
	public List<Play> findlist(PlayPK playpk);
}
