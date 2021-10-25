import java.io.File;

public class DirectoryList {
	public static void main(String[] args) {
		
		File file = new File("/Users/limsungjun/Desktop/SelfTest");
		File[] fileList = file.listFiles();
		String[] fileName = file.list();
		
		if(fileList.length > 0) {
			for(int i = 0; i < fileList.length; i++) {
				if(fileList[i].isFile())
					System.out.println(fileName[i] + "\t" + fileName[i].length() + " bytes");
				else if(fileList[i].isDirectory())
					System.out.println(fileName[i] + "\t" + "<DIR>");
			
			}
		}
		
	}
}
