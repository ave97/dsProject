package basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends User {

	@Id
	@Column(name = "username")
	public String getUsername() {
		return super.getUsername();
	}
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "phone_number")
	private long phone_number;
	
	@Column(name = "siblings")
	private int siblings;
	
	@Column(name = "parent_working_status")
	private int parent_working_status;
	
	@Column(name = "hometown")
	private String hometown;
	
	@Column(name = "points")
	private int points;

	public Student(String username, String password, String first_name, String last_name, String email, String role,
			int age, long phone_number, int siblings, int parent_working_status, String hometown, int points) {
		super(username, password, first_name, last_name, email, role);
		this.age = age;
		this.phone_number = phone_number;
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

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public int getSiblings() {
		return siblings;
	}

	public void setSiblings(int siblings) {
		this.siblings = siblings;
	}

	public int getParent_working_status() {
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
		return "Student [age=" + age + ", phone_number=" + phone_number + ", siblings=" + siblings
				+ ", parent_working_status=" + parent_working_status + ", hometown=" + hometown + ", points=" + points
				+ "]";
	}
}
