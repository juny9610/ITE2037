import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Countries {
	
	private String country;
	private String lat;
	private String lng;
	
	public Countries(String country) {
		BufferedReader file = null;
		String[] input;
		
		try {
			file = new BufferedReader(new FileReader("Countries.csv"));
			
			do {
				input = file.readLine().split(",");
			}
			
			while(!input[0].equals(country));
			
			this.country = country;
			lat = input[1];
			lng = input[2];
			file.close();
		}
		
		catch(FileNotFoundException e) {
			e.getStackTrace();
			System.out.println("File Not Found");
			System.exit(0);
		}
		
		catch(IOException e) {
			e.getStackTrace();
			System.out.println("Input/Output File Not Opened");
			System.exit(0);
		}
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getLat() {
		return lat;
	}
	
	public String getLon() {
		return lng;
	}

}
