
public class MainClass {
	public static void main(String[] args) {
		Manager manager = new Manager(101, "Kinshuk", "Jain", "14-06-1999", "Male", 11);
		new SerializeObject().serializeItem(manager);
		Manager obj = new DeserializeObject().deserializeStudentObject();
		System.out.println(obj);
		System.out.println("Emp Id : "+obj.getEmpId());
		System.out.println("Name : "+obj.getFirstName()+" "+obj.getLastName());
		System.out.println("DOB : "+obj.getEmpDOB());
		System.out.println("Gender : "+obj.getGender());
	}
}
