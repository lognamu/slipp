package net.slipp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.slipp.vo.User;

@Controller
public class UserController {
	private List<User> users = new ArrayList<User>();
	@GetMapping("/signup")
	public String create() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String create(User user) {
		System.out.println(user);
		users.add(user);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("users", users);
		return "list";
	}
	
}
