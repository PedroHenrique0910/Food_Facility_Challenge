package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Reader;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		List<Reader> list = new ArrayList<Reader>();
		
		String path = "C:\\temp\\Mobile_Food_Facility_Permit.csv";
		String linha = "";
		String divisor = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			
			linha = br.readLine();
			while ((linha = br.readLine()) != null) {
				
				String[] vect = linha.split(divisor);
				String nome = vect[1];
				String tipo = vect[2];
				String endereco = vect[5];
				String tipoCardapio = vect[11];
				Double latitude = null;
				Double longitude = null;
 
				Reader reader = new Reader(nome, tipo, endereco, tipoCardapio, latitude, longitude);
				list.add(reader);
				
			}
			
			System.out.println("Food Trucks: ");
			
			for(Reader reader : list) {
				
				System.out.println(reader);
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}


