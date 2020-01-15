package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import basics.Student;

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
	
	@RequestMapping("/profile")
	public String profile(HttpServletRequest request, Model model) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Student stud = session.get(Student.class, username);
			model.addAttribute("role", stud.getRole());
			
			if (username == null || password == null) {
				return "login-form";
			} else if (username.equals(stud.getUsername()) && password.equals(stud.getPassword())) {				return stud.getRole() + "-profile";
			} else {				return "login-form";			}
			
		} finally {
			factory.close();
		}
	}

}