package pe.edu.upc.demoauthor.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoauthor.entities.User;


public interface IUserService {
	public Integer insert(User user);
	public void insertUser(String username,String password,boolean enabled,Long rol_id);

	List<User> list();

}
