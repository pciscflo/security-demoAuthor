package pe.edu.upc.demoauthor.services;

import pe.edu.upc.demoauthor.entities.Role;

import java.util.List;



public interface IRoleService {
	public void insert(Role role);

	List<Role> list();

}
