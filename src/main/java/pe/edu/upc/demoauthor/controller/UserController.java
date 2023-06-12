package pe.edu.upc.demoauthor.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.demoauthor.entities.Role;
import pe.edu.upc.demoauthor.entities.User;
import pe.edu.upc.demoauthor.services.IUserService;


@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping("/users")
public class UserController {
	@Autowired
	private PasswordEncoder bcrypt;
	@Autowired
	private IUserService uService;

	@PostMapping("/save/{role_id}")
	public ResponseEntity<Integer> saveUser(@PathVariable("role_id") Long role_id, @RequestBody User user){
		    String bcryptPassword = bcrypt.encode(user.getPassword());
			user.setPassword(bcryptPassword);
			uService.insertUser(user.getUsername(),user.getPassword(),user.getEnabled(),
					role_id);
		return new ResponseEntity<Integer>(1, HttpStatus.OK );
	}

	@GetMapping("/list")
	public String listUser(Model model) {
		try {
			model.addAttribute("user", new User());
			model.addAttribute("listaUsuarios", uService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "usersecurity/listUser";
	}

}
