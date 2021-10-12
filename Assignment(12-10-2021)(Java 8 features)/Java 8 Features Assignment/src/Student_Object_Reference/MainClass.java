package Student_Object_Reference;

public class MainClass 
{
	public static void main(String[] args) 
	{
		StudentFactory factory = Student::new;
		Student student = factory.getInstance();
		student.setFirstName("Kinshuk");
		student.setLastName("Jain");
		student.setSem1Marks(87);
		student.setSem2Marks(90);
		student.setSem3Marks(78);
		student.setSem4Marks(82);
		student.setSem5Marks(65);
		student.setSem6Marks(66);
		
		ComputeAverage avg = student::getAverageMarks;
		double averageScore = avg.compute();
		System.out.println("**** Student Data ****\n\n"+student);
		System.out.println("\nAverage Score : "+averageScore);
	}
}
