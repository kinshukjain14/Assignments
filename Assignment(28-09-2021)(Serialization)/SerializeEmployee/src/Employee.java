import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int empId;
	private String firstName;
	private String lastName;
	transient private String empDOB;
	private String gender;
	
//	public Employee() {
//		super();
//	}

	

	public Employee(int empId, String firstName, String lastName, String empDOB, String gender) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empDOB = empDOB;
		this.gender = gender;
	}


	public int getEmpId() {
		return empId;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getEmpDOB() {
		return empDOB;
	}



	public String getGender() {
		return gender;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ "]";
	}

}
