package com.test;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Agencija {
	
	private String nazivAgencije;
	private String webAdresa;
	private String telefon;
	private ArrayList<Vozilo> listaArazmana;
	
	
	public Agencija() {
		this.nazivAgencije = "";
		this.webAdresa = "";
		this.telefon = "";
		this.listaArazmana = new ArrayList<Vozilo>();
	}


	public Agencija(String nazivAgencije, String webAdresa, String telefon, ArrayList<Vozilo> listaArazmana) {
		this.nazivAgencije = nazivAgencije;
		this.webAdresa = webAdresa;
		this.telefon = telefon;
		this.listaArazmana = listaArazmana;
	}


	public String getNazivAgencije() {
		return nazivAgencije;
	}


	public void setNazivAgencije(String nazivAgencije) {
		this.nazivAgencije = nazivAgencije;
	}


	public String getWebAdresa() {
		return webAdresa;
	}


	public void setWebAdresa(String webAdresa) {
		this.webAdresa = webAdresa;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public ArrayList<Vozilo> getListaArazmana() {
		return listaArazmana;
	}


	public void setListaArazmana(ArrayList<Vozilo> listaArazmana) {
		this.listaArazmana = listaArazmana;
	}
	
	public void automobilUkupanBr() {
		for (int i = 0; i < this.listaArazmana.size(); i++) {
			if(this.listaArazmana.get(i).getKategorija() == "automobil") {
				System.out.println(this.listaArazmana.size());
			}
		}
	}
	
	public int ukupanBr(String kategorija) {
		int brojac = 0;
		for(int i = 0; i < this.listaArazmana.size(); i++) {
			if(this.listaArazmana.get(i).getKategorija().equals(kategorija)) {
				brojac++;
			}
		}
		return brojac;
	}
	
	public double prihodi(String kategorija) {
		double suma = 0.0;
		for(int i = 0; i < this.listaArazmana.size(); i++) {
			if(this.listaArazmana.get(i).getKategorija().equals(kategorija)) {
				suma += this.listaArazmana.get(i).getCena();
			}
		}
		return suma;
	}
	
	
	public String toString() {

		String temp = "";
		temp += "Naziv agencije: " + this.nazivAgencije + "\n";
		temp += "Web adresa agencije: " + this.webAdresa + "\n";
		temp += "Telefon agencije: " + this.telefon + "\n";
		temp += "Ukupan broj registrovanih vozila po kategoriji: \n";
		temp += "Automobil: "+ ukupanBr("automobil") +"\n";
		temp += "Kombi: "+ ukupanBr("kombi") +"\n";
		temp += "Minibus: "+ ukupanBr("minibus") +"\n";
		temp += "Bus: "+ ukupanBr("bus") +"\n";
		temp += "Kamion: "+ ukupanBr("kamion") +"\n";
		temp += "Ukupan broj prihoda po kategoriji: \n";
		temp += "Automobil: "+ prihodi("automobil") +"\n";
		temp += "Kombi: "+ prihodi("kombi") +"\n";
		temp += "Minibus: "+ prihodi("minibus") +"\n";
		temp += "Bus: "+ prihodi("bus") +"\n";
		temp += "Kamion: "+ prihodi("kamion") +"\n";
	
		return temp;
	}
	
	public void ispisNepokretnosti() {

		System.out.printf("%15s %15s %20s %20s %20s %15s %15s\n", "Id", "Naziv marke", "Datum registracije", "God. proizvodnje", "Kategorija", "Cena", "Kubikaza");

		for(int i = 0; i < this.listaArazmana.size(); i++) {
			System.out.println(this.listaArazmana.get(i));
			
		}
	}
	
	public boolean dodavanjeNovogVozilaKojeRegistrujemo(Vozilo vozilo) {

		for (int i = 0; i < this.listaArazmana.size(); i++) {
			if(vozilo.getId() == this.listaArazmana.get(i).getId()) {
				return false;
			}
		}
		this.listaArazmana.add(vozilo);
		return true;
	}
	
	public boolean izmenaVozilaKojeRegistrujemo(Vozilo vozilo) {

		for (int i = 0; i < this.listaArazmana.size(); i++) {
			if(vozilo.getId() == this.listaArazmana.get(i).getId()) {
				this.listaArazmana.set(i, vozilo);
				return true;
			}
		}
		return false;
	}
	
	
	public Vozilo brisanjeNepokretnosti(int id) {

		for (int i = 0; i < this.listaArazmana.size(); i++) {
			if(this.listaArazmana.get(i).getId() == id) {
				return this.listaArazmana.remove(i);
			}
		}
		return null;
	}
	
	public ArrayList<Vozilo> ispisPoMarki(String marka) {

		System.out.printf("%15s %15s %20s %20s %20s %15s %15s\n", "Id", "Naziv marke", "Datum registracije", "God. proizvodnje", "Kategorija", "Cena", "Kubikaza");
		
		ArrayList<Vozilo> listaRezultata = new ArrayList<>();
		for (int i = 0; i < this.listaArazmana.size(); i++) {
			if(this.listaArazmana.get(i).getNazivMarke().equalsIgnoreCase(marka)) {
				listaRezultata.add(this.listaArazmana.get(i));
				System.out.println(this.listaArazmana.get(i));
			}
		}
		return listaRezultata;

	}
	
	public ArrayList<Vozilo> ispis2PeriodaDatumaGodProizvodnjeMinMax(LocalDate datumMinP1, LocalDate datumMaxP1, LocalDate datumMinP2, LocalDate datumMaxP2, int godProizvodnjeMin, int godProizvodnjeMax) {

		System.out.printf("%15s %15s %20s %20s %20s %15s %15s\n", "Id", "Naziv marke", "Datum registracije", "God. proizvodnje", "Kategorija", "Cena", "Kubikaza");
		ArrayList<Vozilo> listaRezultata = new ArrayList<>();
		for (int i = 0; i < this.listaArazmana.size(); i++) {
			if((this.listaArazmana.get(i).getDatumRegistracije().compareTo(datumMinP1) >= 0 && 
					this.listaArazmana.get(i).getDatumRegistracije().compareTo(datumMaxP1) <= 0) || 
					(this.listaArazmana.get(i).getDatumRegistracije().compareTo(datumMinP2) >= 0 &&
					this.listaArazmana.get(i).getDatumRegistracije().compareTo(datumMaxP2) <= 0) &&
					this.listaArazmana.get(i).getGodinaProizvodnje() >= godProizvodnjeMin &&
					this.listaArazmana.get(i).getGodinaProizvodnje() <= godProizvodnjeMax) {

				listaRezultata.add(this.listaArazmana.get(i));
				System.out.println(this.listaArazmana.get(i));
			}
		}
		return listaRezultata;

	}
	
	public double izracunajProsecnuCenuRegistracije(String kategorija, int godProizvodnje) {

		int brojac = 0;
		double suma = 0.0;
		double prosek = 0.0;
		for(int i = 0; i < this.listaArazmana.size(); i++) {
			if(this.listaArazmana.get(i).getKategorija().equalsIgnoreCase(kategorija) && this.listaArazmana.get(i).getGodinaProizvodnje() == godProizvodnje) {
				suma += this.listaArazmana.get(i).getCena();
				brojac++;
			}
		}
		if(brojac > 0) {
			prosek = suma / brojac;
			System.out.println("Prosecna cena registracije vozila kategorije " + kategorija + " godine proizvodnje " + godProizvodnje + " je: " + prosek);
			return prosek;
		}
		System.out.println("Zadati kriterijum nije dao rezultat.");
		return prosek;
	}
	
	public ArrayList<Vozilo> pretragaNajskupljeRegistracije(String kategorija, LocalDate min, LocalDate max) {

		ArrayList<Vozilo> listaRezultata = new ArrayList<>();
		for(int i = 0; i < this.listaArazmana.size(); i++) {
			if(this.listaArazmana.get(i).getKategorija().equalsIgnoreCase(kategorija)
					&& this.listaArazmana.get(i).getDatumRegistracije().compareTo(min) >= 0
					&& this.listaArazmana.get(i).getDatumRegistracije().compareTo(max) <= 0) {
				listaRezultata.add(this.listaArazmana.get(i));
			}
		}
	
		Vozilo najveca = pronadjiNajvecuCenuRegistracije(listaRezultata);

		if(najveca == null) {
			System.out.println("Ne postoji informacija za zadate uslove.");
			return null;
		} else {
			ArrayList<Vozilo> sveNajveceTransakcije = pronadjiSveNajveceUplate(listaRezultata, najveca);
			for(int i = 0; i < sveNajveceTransakcije.size(); i++) {
				System.out.println("Najvece cene registracije (" + i + ") je: " + sveNajveceTransakcije.get(i));
			}
			return sveNajveceTransakcije;
		}
	}
	
	public Vozilo pronadjiNajvecuCenuRegistracije(ArrayList<Vozilo> listaArazmana) {

		Vozilo najveca = null;
		if(listaArazmana.size() > 0) {
			najveca = listaArazmana.get(0);
			for(int i = 1; i < listaArazmana.size(); i++) {
				if(najveca.getCena() < listaArazmana.get(i).getCena()) {
					najveca = listaArazmana.get(i);
				}
			}
		}
		return najveca;
	}
	
	public ArrayList<Vozilo> pronadjiSveNajveceUplate(ArrayList<Vozilo> listaFilterTransakcija, Vozilo najveca) {

		ArrayList<Vozilo> listaRezultata = new ArrayList<>();
		for(int i = 0; i < listaFilterTransakcija.size(); i++) {
			if(listaFilterTransakcija.get(i).getCena() == najveca.getCena()) {
				listaRezultata.add(listaFilterTransakcija.get(i));
			}
		}
		return listaRezultata;
	}

	
	
	public void sacuvaj(String putanja) {

		ArrayList<String> linije = new ArrayList<String>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		linije.add(this.nazivAgencije);
		linije.add(this.webAdresa);
		linije.add(this.telefon);
		for (int i = 0; i < this.listaArazmana.size(); i++) {
			Vozilo vozilo = this.listaArazmana.get(i);
			int id = vozilo.getId();
			String nazivMarke = vozilo.getNazivMarke();
			String datumRegistracije = dtf.format(vozilo.getDatumRegistracije()); 
			int godProizvodnje = vozilo.getGodinaProizvodnje();
			String kategorija = vozilo.getKategorija();
			double cena = vozilo.getCena();
			int kubikaza = vozilo.getKubikaza();
	
			String linija = id  + ";" + nazivMarke + ";" + datumRegistracije + ";" + godProizvodnje + ";" + kategorija + ";" + cena + ";" + kubikaza;
			linije.add(linija);
		}

		try {
			Files.write(Paths.get(putanja), linije, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		} catch (java.io.IOException e) {
			System.out.println("Desila se greska prilikom cuvanja podataka.");
		}
	}

	public void ucitaj(String putanja) {

		this.listaArazmana = new ArrayList<>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		List<String> linije;
		try {
			linije = Files.readAllLines(Paths.get(putanja), Charset.defaultCharset());
			this.nazivAgencije = linije.get(0);
			this.webAdresa = linije.get(1);
			this.telefon = linije.get(2);
			for (int i = 3; i < linije.size(); i++) {
				String[] attributes = linije.get(i).split(";");
				int id = Integer.parseInt(attributes[0]); 
				String nazivMarke = attributes[1];
				LocalDate datumRegistracije = LocalDate.parse(attributes[2], dtf);
				int godProzivodnje = Integer.parseInt(attributes[3]);
				String kategorija = attributes[4];
				double cena = Double.parseDouble(attributes[5]);  
				int kubikaza = Integer.parseInt(attributes[6]);
		
				Vozilo vozilo = new Vozilo(id, nazivMarke, datumRegistracije, godProzivodnje, kategorija, cena, kubikaza);
				this.listaArazmana.add(vozilo);

			}
		} catch (java.io.IOException e) {
			System.out.println("Desila se greska prilikom citanja fajla.");
		} catch (NumberFormatException e) {
			System.out.println("Desila se greska prilikom konverzije brojeva.");
		} catch (DateTimeParseException e) {
			System.out.println("Desila se greska prilikom konverzije datuma.");
		} catch (Exception e) {
			System.out.println("Desila se nepredvidjena greska.");
		}

	}

}
