package pe.edu.upc.demoauthor.servicesimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demoauthor.entities.Role;
import pe.edu.upc.demoauthor.repositories.RoleRepository;
import pe.edu.upc.demoauthor.services.IRoleService;


@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleRepository rR;

	@Override
	public void insert(Role role) {
		rR.save(role);
	}

	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}
}
