package pe.edu.upc.demoauthor.services;

import java.util.List;

import pe.edu.upc.demoauthor.entities.Users;


public interface IUserService {
	public Integer insert(Users user);

	List<Users> list();

}
