package pe.edu.upc.demoauthor.servicesimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.demoauthor.entities.Book;
import pe.edu.upc.demoauthor.entities.Role;
import pe.edu.upc.demoauthor.entities.User;
import pe.edu.upc.demoauthor.repositories.RoleRepository;
import pe.edu.upc.demoauthor.repositories.UserRepository;
import pe.edu.upc.demoauthor.services.IUserService;


@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository uR;
	@Autowired
	private RoleRepository rR;

	@Override
	public Integer insert(User user) {
		int rpta = uR.buscarUsername(user.getUsername());
		if (rpta == 0) {
			uR.save(user);
		}
		return rpta;
	}
	public Integer buscarUser(String username){
		int rpta = uR.buscarUsername(username);
		return rpta;
	}

	@Override
	public void insertUser(User user) {
		uR.save(user);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return uR.findAll();
	}

	/**
	 * @param user_id De un usuario existente
	 * @param rol_id  De un usuario existente
	 * @return 1 exito
	 */
	@Override
	public Integer insertUserRol(Long user_id, Long rol_id) {
		Integer result = 0;
		uR.insertUserRol(user_id, rol_id);
		return 1;
	}

	@Transactional
	public Integer insertUserRol2(Long user_id, Long rol_id) {
		Integer result = 0;
		User user = uR.findById(user_id).get();
		Role role = rR.findById(rol_id).get();
		user.getRoles().add(role);
		uR.save(user);
		rR.save(role);
		return 1;
	}
}
