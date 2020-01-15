package controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import basics.Student;
import basics.User;

@Controller
public class UserController {

	@RequestMapping("/")
	public String showMainMenu() {
		return "main-menu";
	}

	@RequestMapping("/about")
	public String showAbout() {
		return "about";
	}

	@RequestMapping("/login")
	public String showLoginForm() {
		return "login-form";
	}

	@RequestMapping("/register")
	public String showRegistrationForm() {
		return "registration-form";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "main-menu";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User user = session.get(User.class, username);
			model.addAttribute("role", user.getRole());
			
			if (username == null || password == null) {
				return "login-form";
			} else if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {				return user.getRole() + "-profile";
			} else {				return "login-form";			}
			
		} finally {
			factory.close();
		}
	}

}