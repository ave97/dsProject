package basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student extends Users {
	
	@Id
	@Column(name="username")
	public String getUsername() {
		return super.getUsername();
	}
	
	@Column(name="first_name")
	public String getFirstName() {
		return super.getFirstName();
	}
	
	@Column(name="last_name")
	public String getLastName() {
		return super.getLastName();
	}
	
	@Column(name="password")
	public String getPassword() {
		return super.getPassword();
	}
	
	@Column(name = "age")
	private int age;
	
	@Column(name ="phone_number")
	private long phone_number;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="family_income")
	private int family_income;
	
	@Column(name = "siblings")
	private int siblings;
	
	@Column(name = "parent_working_status")
	private int parent_working_status;
	
	@Column(name = "hometown")
	private String hometown;
	
	@Column(name = "points")
	private int points;
	
	public Student() {
		super(null, null, null, null);
		// TODO Auto-generated constructor stub
	}

	public Student(String username, String password, String firstName, String lastName, int age, String email,
			long phone_number, int family_income, int siblings, int parent_working_status, String hometown, int points) {
		super(username, password, firstName, lastName);
		this.age = age;
		this.email = email;
		this.phone_number = phone_number;
		this.family_income = family_income;
		this.siblings = siblings;
		this.parent_working_status = parent_working_status;
		this.hometown = hometown;
		this.points = points;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	
	public int getFamily_income() {
		return family_income;
	}
	
	public void setFamily_income(int family_income) {
		this.family_income = family_income;
	}
	
	public int getSiblings() {
		return siblings;
	}
	
	public void setSiblings(int siblings) {
		this.siblings = siblings;
	}
	
	public int isParent_working_status() {
		return parent_working_status;
	}
	
	public void setParent_working_status(int parent_working_status) {
		this.parent_working_status = parent_working_status;
	}
	
	public String getHometown() {
		return hometown;
	}
	
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Student [age=" + age + ", email=" + email + ", phoneNumber=" + phone_number  + ", siblings=" + siblings + ", parentWorkingStatus=" + parent_working_status
				+ ", hometown=" + hometown + ", points=" + points + "]";
	}
	
}