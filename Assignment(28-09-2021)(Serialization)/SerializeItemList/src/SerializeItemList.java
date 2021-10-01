import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

public class SerializeItemList {
	public boolean serializeItem(List<Item> itemList) {
		File file = new File("D:\\STS\\StudentDataStore\\src");

		try (OutputStream os = new FileOutputStream(file.getAbsolutePath() + "\\items.sez");
				ObjectOutputStream oos = new ObjectOutputStream(os);) {
			if (file.isDirectory()) {
				oos.writeObject(itemList);
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
