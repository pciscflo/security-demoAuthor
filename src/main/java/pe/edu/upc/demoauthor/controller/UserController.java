package pe.edu.upc.demoauthor.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.demoauthor.entities.Users;
import pe.edu.upc.demoauthor.services.IUserService;

import javax.validation.Valid;


@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping("/users")
public class UserController {
	@Autowired
	private PasswordEncoder bcrypt;
	@Autowired
	private IUserService uService;

	@PostMapping("/save")
	public int saveUser(@RequestBody Users user){
			int rpta = 0;
		    String bcryptPassword = bcrypt.encode(user.getPassword());
			user.setPassword(bcryptPassword);
			rpta = uService.insert(user);
		return rpta;
	}

	@GetMapping("/list")
	public String listUser(Model model) {
		try {
			model.addAttribute("user", new Users());
			model.addAttribute("listaUsuarios", uService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "usersecurity/listUser";
	}

}
