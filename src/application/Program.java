package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.DistanceCalculator;
import entities.Reader;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Reader> list = new ArrayList<>();

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
                Double latitude;
                Double longitude;

                try {
                    latitude = Double.parseDouble(vect[14]);
                } catch (NumberFormatException e) {
                    latitude = 0.0;
                }

                try {
                    longitude = Double.parseDouble(vect[15]);
                } catch (NumberFormatException e) {
                    longitude = 0.0;
                }

                Reader reader = new Reader(nome, tipo, endereco, tipoCardapio, latitude, longitude);
                list.add(reader);
            }

            System.out.print("Digite sua latitude: ");
            double userLatitude = sc.nextDouble();
            System.out.print("Digite sua longitude: ");
            double userLongitude = sc.nextDouble();

            // Calcular distâncias e adicionar à lista
            for (Reader reader : list) {
            	double dist = DistanceCalculator.calculoDistancia(userLatitude, userLongitude, reader.getLatitude(), reader.getLongitude());
                reader.setDistancia(dist);
            }

            // Ordenar a lista com base na distância
            Collections.sort(list);

            System.out.println();
            
            System.out.println("Os 5 food trucks mais próximos:");
            for (int i = 0; i < Math.min(5, list.size()); i++) {
                System.out.println(list.get(i));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}




