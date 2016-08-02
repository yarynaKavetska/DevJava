package ua;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4656205184818860704L;

	private final List<Person> persons = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int age = Integer.valueOf(req.getParameter("age"));
		boolean isMan = "on".equals(req.getParameter("sex"));
		String name = req.getParameter("name");
		Person person = new Person(age, isMan, name);
		persons.add(person);
		int numberOfPerson = persons.size()-1;
		resp.sendRedirect("/allPersons?person="+numberOfPerson);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int index = Integer.valueOf(req.getParameter("person"));
		req.setAttribute("person", persons.get(index));
		req.getRequestDispatcher("/allPersons.jsp").forward(req, resp);
	}

	public static class Person{
		int age;
		boolean isMan;
		String name;
		public Person(int age, boolean isMan, String name) {
			this.age = age;
			this.isMan = isMan;
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public boolean getIsMan() {
			return isMan;
		}
		public void setMan(boolean isMan) {
			this.isMan = isMan;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
