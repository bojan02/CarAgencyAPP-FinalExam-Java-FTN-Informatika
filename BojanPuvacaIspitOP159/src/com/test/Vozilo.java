package com.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vozilo {
	
	private int id;
	private String nazivMarke;
	private LocalDate datumRegistracije;
	private int godinaProizvodnje;
	private String kategorija;
	private double cena;
	private int kubikaza;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	
	public Vozilo() {
		this.id = 1;
		this.nazivMarke = "";
		this.datumRegistracije = LocalDate.now();
		this.godinaProizvodnje = 1991;
		this.kategorija = "";
		this.cena = 1;
		this.kubikaza = 1;
	}

	public Vozilo(int id, String nazivMarke, LocalDate datumRegistracije, int godinaProizvodnje, String kategorija,
			double cena, int kubikaza) {
		this.id = id;
		this.nazivMarke = nazivMarke;
		this.datumRegistracije = datumRegistracije;
		this.godinaProizvodnje = godinaProizvodnje;
		this.kategorija = kategorija;
		this.cena = cena;
		this.kubikaza = kubikaza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivMarke() {
		return nazivMarke;
	}

	public void setNazivMarke(String nazivMarke) {
		this.nazivMarke = nazivMarke;
	}

	public LocalDate getDatumRegistracije() {
		return datumRegistracije;
	}

	public void setDatumRegistracije(LocalDate datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getKubikaza() {
		return kubikaza;
	}

	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}
	
	public String toString() {
		return String.format("%15d %15s %20s %20s %20s %15.2f %15d", this.id, this.nazivMarke, dtf.format(this.datumRegistracije), 
				this.godinaProizvodnje, this.kategorija, this.cena, this.kubikaza);
	}
	
	
	
}
