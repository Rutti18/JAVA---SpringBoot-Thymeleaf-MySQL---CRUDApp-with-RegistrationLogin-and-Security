package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;

	}
	
	@ModelAttribute("user")
	public UserRegistrationDto 	userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		String s = "";
		
		return "registration";
	}
	
	@PostMapping
	public String registorUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto ) {
		userService.saveUser(userRegistrationDto);
		return "redirect:/registration?success";
	}

}
