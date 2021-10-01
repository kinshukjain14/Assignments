import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeserializeObject {
	
	public Manager deserializeStudentObject()
	{
		File file = new File("D:\\STS\\SerializeEmployee\\src");
		try(
				InputStream is = new FileInputStream(file.getAbsoluteFile()+"\\employee.sez");
				ObjectInputStream ois = new ObjectInputStream(is);
				){
			if(file.isDirectory()) 
			{	
				Manager o = (Manager) ois.readObject();
				return o;
			}
			else 
			{
				throw new IOException("Directory does not exist");
			}
		}
		catch(IOException | ClassNotFoundException e) {
			System.err.println(e.getMessage());
			return null;
		}
	
	}
}
