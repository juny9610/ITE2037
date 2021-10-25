import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TravelInfoRequest {	
	public static void main(String[] args) {
		
		// Initialize variables
		KeyValue[] property = new KeyValue[10];
		int cnt = 0;
		
		Countries start_country = null;
		Countries depart_country = null;
		
		Distance distance_s = null;
		Distance distance_d = null;
		
		String template;
		String tmp;
		
		// Get today's date
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(Calendar.getInstance().getTime());
		

		try {
			// Open input/output files
			BufferedReader f_property = new BufferedReader(new FileReader("properties.txt"));
			BufferedReader f_template = new BufferedReader(new FileReader("template_file.txt"));
			BufferedWriter output_file = new BufferedWriter(new FileWriter("output_file.txt"));
		
			// Read properties.txt and set property
			while((tmp=f_property.readLine()) != null)
				property[cnt++] = new KeyValue(tmp);
			
			property[cnt] = new KeyValue("date", date);

			for(int i = 0; i <= cnt; i++) {
				// Initialize Country class
				if(property[i].getKey().equals("startcountry")) 
					start_country = new Countries(property[i].getValue());
				
				else if(property[i].getKey().equals("departcountry"))
					depart_country = new Countries(property[i].getValue()); 
			}
			
			// Initialize Distance class
			distance_s = new Distance(start_country.getCountry(),
									  Double.parseDouble(start_country.getLat()),
									  Double.parseDouble(start_country.getLon()));
			distance_d = new Distance(depart_country.getCountry(),
									  Double.parseDouble(depart_country.getLat()),
									  Double.parseDouble(depart_country.getLon()));
			
			// Read template_file.txt and Write output_file.txt
			while((template=f_template.readLine()) != null) {
				if(template.indexOf("{") != -1) {	
					for(int i = 0; i <= cnt; i++) {
						if(template.indexOf(property[i].getKey()) != -1)
							template = template.replace("{" + property[i].getKey() + "}",
														property[i].getValue());
					}	
				}
				
 				else if(template.indexOf("<add info>") != -1) {
					template = template.replace("<add info>", "Distance of");
					output_file.write(template);
					output_file.newLine();
					output_file.write(distance_s.writeDistance()); 
					output_file.newLine();
					output_file.write(distance_d.writeDistance());
					output_file.newLine();
					template= "is\r\n" + Distance.getDistance(distance_s, distance_d);
				}
				output_file.write(template); 
				output_file.newLine(); 
			}
			f_template.close();
			f_property.close();
			output_file.close();
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
}