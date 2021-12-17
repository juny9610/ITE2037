import java.io.FileInputStream;
import java.io.IOException;

public class SystemInDemo {
	public static void main(String[] args) throws IOException {
		
		
		try {
			FileInputStream fis = new FileInputStream("/Users/limsungjun/Desktop/eclipse-workspace/Lab11_1/File.txt");
			int data = 0;
			//char c = 0;
			
			while((data = fis.read()) != -1) {
                char c = (char)data;
				System.out.print(c);
			}
		} catch (IOException e) {
		}	
	}
}
