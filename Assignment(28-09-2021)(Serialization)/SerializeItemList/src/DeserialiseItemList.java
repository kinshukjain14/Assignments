import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class DeserialiseItemList {
	@SuppressWarnings("unchecked")
	public List<Item> deserializeStudentObject()
	{
		File file = new File("D:\\STS\\StudentDataStore\\src");
		try(
				InputStream is = new FileInputStream(file.getAbsoluteFile()+"\\items.sez");
				ObjectInputStream ois = new ObjectInputStream(is);
				){
			if(file.isDirectory()) 
			{	
				List<Item> list = (List<Item>) ois.readObject();
				return list;
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
