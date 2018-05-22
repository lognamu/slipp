package net.slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.vo.User;
import net.slipp.vo.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/form")
	public String signUp() {
		return "user/signup";
	}
	
	@PostMapping("")
	public String signUp(User user) {
		System.out.println(user);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "user/list";
	}
	
	@GetMapping("/{idx}/form")
	public String update(@PathVariable Long idx, Model model) {
		User user = userRepository.getOne(idx);
		model.addAttribute("user", user);
		return "user/update";
	}
	
	@PostMapping("/{idx}")
	public String update(@PathVariable Long idx, User newUser) {
		User user = userRepository.getOne(idx);
		user.update(newUser);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/signin")
	public String signIn() {
		return "user/signin";
	}
	
	@GetMapping("/profile")
	public String profile () {
		
		return "user/profile";
	}
	
}
