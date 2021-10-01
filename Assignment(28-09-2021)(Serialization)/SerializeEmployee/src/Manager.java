
public class Manager extends Employee
{
	public Manager(int empId, String firstName, String lastName, String empDOB, String gender, int managerId) 
	{
		super(empId, firstName, lastName, empDOB, gender);
		this.managerId=managerId;
	}

	private static final long serialVersionUID = 1L;
	
	private int managerId;

	public int getManagerId() {
		return managerId;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + "]";
	}
	
}
