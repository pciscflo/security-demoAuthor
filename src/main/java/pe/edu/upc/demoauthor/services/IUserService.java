package pe.edu.upc.demoauthor.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoauthor.entities.Book;
import pe.edu.upc.demoauthor.entities.User;


public interface IUserService {
	public Integer insert(User user);
	public void insertUser(User user);
	public Integer buscarUser(String username);
	List<User> list();
	public Integer insertUserRol(Long user_id, Long rol_id);
	public Integer insertUserRol2(Long user_id, Long rol_id);

}
