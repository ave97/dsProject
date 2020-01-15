package basics;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/profile")
	public String profile(HttpServletRequest request, Model model) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			List<Student> result;

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Student stud = session.get(Student.class, username);
			
//			result = session.createQuery("from Student s where s.username='" + username + "'").getResultList();
			
//			for(Student stud: result) {
//				System.out.println(stud.toString());
//			}
			
//			return "login-form";
//
//			boolean loggedIn = false;
//			for (int i = 0; i < result.size(); i++) {
//				if (username.equals(result.get(i).getUsername()) && password.equals(result.get(i).getPassword())) {
//					loggedIn = true;
//				}
//			}
//			System.out.println(username + " " + password);
//
//			if (loggedIn) {
//				return "profile";
//			} else {
//				return "login-form";
//			}			if (username.equals(stud.getUsername()) && password.equals(stud.getPassword())) {				return "profile";			} else {				return "login-form";			}
		} finally {
			factory.close();
		}
	}

}