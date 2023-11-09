package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Bem-vindo ao FoodFacility! Vamos apresentar os Food Trucks disponíveis com base na sua latitude e longitude.\nPressione enter para continuar...");
		sc.nextLine();
		
		System.out.print("Digite a latitude: ");
		Double latitude = sc.nextDouble();
		
		System.out.print("Digite a longitude: ");
		Double longitude = sc.nextDouble();
		
		
		String path = "C:\\temp\\Mobile_Food_Facility_Permit.csv";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		sc.close();
	}

}
