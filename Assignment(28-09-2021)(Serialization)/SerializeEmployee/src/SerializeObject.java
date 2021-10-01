import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializeObject {
	public boolean serializeItem(Manager manager) {
		File file = new File("D:\\STS\\SerializeEmployee\\src");

		try (OutputStream os = new FileOutputStream(file.getAbsolutePath() + "\\employee.sez");
				ObjectOutputStream oos = new ObjectOutputStream(os);) {
			if (file.isDirectory()) {
				oos.writeObject(manager);
				return true;
			} else {
				throw new IOException("Directory does not exist");
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}

	}
}
