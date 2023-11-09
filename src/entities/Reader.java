package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	
	private Double latitude;
	private Double longitude;
	
	public Reader() {
	}

	public Reader(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}


	public Double getLongitude() {
		return longitude;
	}

	public void reader() {
		
		String path = "C:\\temp\\Mobile_Food_Facility_Permit.csv";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			while (line != null  ) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
				try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
 		}
		
	}
	
}
