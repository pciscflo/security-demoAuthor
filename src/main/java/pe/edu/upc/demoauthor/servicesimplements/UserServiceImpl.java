package pe.edu.upc.demoauthor.servicesimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demoauthor.entities.Book;
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

	@Override
	public Integer insertUserRol(Long user_id, Long rol_id) {
		Integer result = 0;
		uR.insertUserRol(user_id, rol_id);
		return 1;
	}
}
