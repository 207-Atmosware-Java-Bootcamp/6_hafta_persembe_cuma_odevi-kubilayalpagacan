import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Log {
	private static String PATH = "C:\\Users\\username\\Desktop\\log.txt";
	private static File file = new File(PATH);
	
	public static void messageWrite(String message) throws IOException {
		String date = createdDate();
		if (!file.exists()) {
			file.createNewFile();
		}
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH, true))) {
			bufferedWriter.write(date + " " + message);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static String createdDate() {
		Locale locale = new Locale("tr", "TR");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss", locale);
		return dateFormat.format(new Date());
	}
	
}