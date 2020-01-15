package basics;

public class AdminEmployee extends Users {

	private int empId;
	private int email;
	private int stoudentCount;

	public AdminEmployee(String username, String password, String firstName, String lastName, int empId, int email,
			int stoudentCount) {
		super(username, password, firstName, lastName);
		this.empId = empId;
		this.email = email;
		this.stoudentCount = stoudentCount;
	}

	public void approveRequest() {

	}
}