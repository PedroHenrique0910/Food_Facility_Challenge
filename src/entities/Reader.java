package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	
	private String nome;
	private String tipo;
	private String endereco;
	private String tipoCardapio;
	private Double latitude;
	private Double longitude;
	
	public Reader() {
	}

	public Reader(String nome, String tipo, String endereco, String tipoCardapio, Double latitude, Double longitude) {
		this.nome = nome;
		this.tipo = tipo;
		this.endereco = endereco;
		this.tipoCardapio = tipoCardapio;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipoCardapio() {
		return tipoCardapio;
	}

	public void setTipoCardapio(String tipoCardapio) {
		this.tipoCardapio = tipoCardapio;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "[nome=" + nome + ", tipo=" + tipo + ", endereco=" + endereco + ", tipoCardapio=" + tipoCardapio
				+ ", latitude=" + String.format("%.2f", latitude) + ", longitude=" + String.format("%.3f", longitude)  + "]";
	}

	
	}
	

