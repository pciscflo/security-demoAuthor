package pe.edu.upc.demoauthor.servicesimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demoauthor.entities.User;
import pe.edu.upc.demoauthor.repositories.UserRepository;
import pe.edu.upc.demoauthor.services.IUserService;


@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository uR;

	@Override
	public Integer insert(User user) {
		int rpta = uR.buscarUsername(user.getUsername());
		if (rpta == 0) {
			uR.save(user);
		}
		return rpta;
	}

	@Override
	public void insertUser(String username, String password, boolean enabled, Long rol_id) {
		uR.insertUser(username, password, enabled, rol_id);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return uR.findAll();
	}
}
