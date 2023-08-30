package com.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
	
	public static Scanner scanner = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	
	public static boolean proveraZaId(String id) {

		try {
			int broj = Integer.parseInt(id);
			if(broj < 1) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean proveraKubikaze(String kubikazaS) {

		try {
			int kubikaza = Integer.parseInt(kubikazaS);
			if(kubikaza < 10000 && kubikaza > 800) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean proveraGodProizvodnje(String godProizvodnjeS) {

		try {
			int godProizvodnje = Integer.parseInt(godProizvodnjeS);
			if(godProizvodnje > 1990) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean proveriDatum(String datum) {

		try {
			LocalDate.parse(datum, dtf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean proveraCene(String cenaS) {

		try {
			double cena = Double.parseDouble(cenaS);
			if(cena > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean daLiJeVeciDatum(LocalDate datumPocetni, String datum) {

		LocalDate datumKrajnji = null;
		try {
			datumKrajnji = LocalDate.parse(datum, dtf);
			if(datumKrajnji.compareTo(datumPocetni) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean proveraGodProizvodnjeMax(String godinaS, int min) {
		try {
			double godina = Integer.parseInt(godinaS);
			if(godina > min) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}
	
	private static void unesiAgenciju(Agencija agencija) {

		System.out.println("Unesite naziv agencije:");
		String naziv = scanner.nextLine();
		agencija.setNazivAgencije(naziv);
		System.out.println("Unesite web adresu agencije:");
		String webAdresa = scanner.nextLine();
		agencija.setWebAdresa(webAdresa);
		System.out.println("Unesite telefon agencije:");
		String telefon = scanner.nextLine();
		agencija.setTelefon(telefon);
		System.out.println("Podaci o agenciji su uspesno dodati.");

	}
	
	public static void unosNovogVozilaKojeRegistrujemo(Agencija agencija) {

		String idS = null;
		do {
			System.out.print("Unesite identifikacioni broj: ");
			idS = scanner.nextLine();
		} while(!proveraZaId(idS));
		int id = Integer.parseInt(idS);
		
		int kubikaza = 0;
		String kubikazaS = null;
		do {
			System.out.print("Unesite kubikazu vozila: ");
			kubikazaS = scanner.nextLine();
		} while(!proveraKubikaze(kubikazaS));
		kubikaza = Integer.parseInt(kubikazaS);
	
		System.out.print("Unesite naziv marke vozila: ");
		String nazivMarke = scanner.nextLine();
		
		String datumRegistracijeS;
		do {
			System.out.print("Unesite datum registracije vozila: ");
			datumRegistracijeS = scanner.nextLine();
		} while(!proveriDatum(datumRegistracijeS));
		LocalDate datumRegistracije = LocalDate.parse(datumRegistracijeS, dtf);
		
		String godProizvodnjeS;
		do {
			System.out.print("Unesite godinu proizvodnje vozila: ");
			godProizvodnjeS = scanner.nextLine();
		} while(!proveraGodProizvodnje(godProizvodnjeS));
		int godProizvodnje = Integer.parseInt(godProizvodnjeS);
		
		String kategorija;
		do {
			System.out.print("Unesite kategoriju vozila (automobil/kombi/minibus/bus/kamion): ");
			kategorija = scanner.nextLine();
		} while(!(kategorija.equals("automobil") || kategorija.equals("kombi") || kategorija.equals("minibus") || kategorija.equals("bus") || kategorija.equals("kamion")));
		
		String cenaS;
		do {
			System.out.print("Unesite cenu vozila: ");
			cenaS = scanner.nextLine();
		} while(!proveraCene(cenaS));
		double cena = Double.parseDouble(cenaS);
		
		Vozilo vozilo = new Vozilo(id, nazivMarke, datumRegistracije, godProizvodnje, kategorija, cena, kubikaza);
		
		boolean provera = agencija.dodavanjeNovogVozilaKojeRegistrujemo(vozilo);
		
		if(provera) {
			System.out.println("Vozilo je uspesno registrovano.");
		} else {
			System.out.println("Vozilo nije uspesno registrovano.");
		}
	}
	
	public static void izmenaVozilaKojeRegistrujemo(Agencija agencija) {

		String idS = null;
		do {
			System.out.print("Unesite identifikacioni broj: ");
			idS = scanner.nextLine();
		} while(!proveraZaId(idS));
		int id = Integer.parseInt(idS);
		
		int kubikaza = 0;
		String kubikazaS = null;
		do {
			System.out.print("Unesite kubikazu vozila: ");
			kubikazaS = scanner.nextLine();
		} while(!proveraKubikaze(kubikazaS));
		kubikaza = Integer.parseInt(kubikazaS);
	
		System.out.print("Unesite naziv marke vozila: ");
		String nazivMarke = scanner.nextLine();
		
		String datumRegistracijeS;
		do {
			System.out.print("Unesite datum registracije vozila: ");
			datumRegistracijeS = scanner.nextLine();
		} while(!proveriDatum(datumRegistracijeS));
		LocalDate datumRegistracije = LocalDate.parse(datumRegistracijeS, dtf);
		
		String godProizvodnjeS;
		do {
			System.out.print("Unesite godinu proizvodnje vozila: ");
			godProizvodnjeS = scanner.nextLine();
		} while(!proveraGodProizvodnje(godProizvodnjeS));
		int godProizvodnje = Integer.parseInt(godProizvodnjeS);
		
		String kategorija;
		do {
			System.out.print("Unesite kategoriju vozila (automobil/kombi/minibus/bus/kamion): ");
			kategorija = scanner.nextLine();
		} while(!(kategorija.equals("automobil") || kategorija.equals("kombi") || kategorija.equals("minibus") || kategorija.equals("bus") || kategorija.equals("kamion")));
		
		String cenaS;
		do {
			System.out.print("Unesite cenu vozila: ");
			cenaS = scanner.nextLine();
		} while(!proveraCene(cenaS));
		double cena = Double.parseDouble(cenaS);
		
		Vozilo vozilo = new Vozilo(id, nazivMarke, datumRegistracije, godProizvodnje, kategorija, cena, kubikaza);
		
		boolean provera = agencija.izmenaVozilaKojeRegistrujemo(vozilo);
		
		if(provera) {
			System.out.println("Podaci vozila je uspesno izmenjeni.");
		} else {
			System.out.println("Podaci vozila nisu uspesno izmenjeni.");
		}
	}
	
	public static void izbrisiVozilo(Agencija agencija) {

		int id = 0;
		String idS = null;
		do {
			System.out.println("Unesite Identifikacioni broj vozila za brisanje: ");
			idS = scanner.nextLine();
		} while(!proveraZaId(idS));
		id = Integer.valueOf(idS);
		Vozilo provera = agencija.brisanjeNepokretnosti(id);
		if(provera != null) {
			System.out.println("Podaci vozila su uspesno izbrisani.");
		} else {
			System.out.println("Brisanje podataka o vozilu nije uspelo.");
		}
	}
	
	public static void pretragapoMarkiVozila(Agencija agencija) {

		System.out.println("Unesite naziv marke vozila: ");
		String marka = scanner.nextLine();
		agencija.ispisPoMarki(marka);
	}
	
	public static void pretraga2PeriodaDatumaGodProizvodnjeMinMax(Agencija agencija) {

		LocalDate datumMinP1 = null;
		String datumMinSP1 = null;
		LocalDate datumMaxP1 = null;
		String datumMaxSP1 = null;
		
		LocalDate datumMinP2 = null;
		String datumMinSP2 = null;
		LocalDate datumMaxP2 = null;
		String datumMaxSP2 = null;
		
		
		do {
			System.out.print("Unesite minimalni datum za pretragu perioda 1: ");
			datumMinSP1 = scanner.nextLine();
		} while(!proveriDatum(datumMinSP1));
		datumMinP1 = LocalDate.parse(datumMinSP1, dtf);
	
		do {
			System.out.print("Unesite maksimalni datum za pretragu perioda 1: ");
			datumMaxSP1 = scanner.nextLine();
		} while(!daLiJeVeciDatum(datumMinP1, datumMaxSP1));
		datumMaxP1 = LocalDate.parse(datumMaxSP1, dtf);
		
		do {
			System.out.print("Unesite minimalni datum za pretragu perioda 2: ");
			datumMinSP2 = scanner.nextLine();
		} while(!proveriDatum(datumMinSP2));
		datumMinP2 = LocalDate.parse(datumMinSP2, dtf);
	
		do {
			System.out.print("Unesite maksimalni datum za pretragu perioda 2: ");
			datumMaxSP2 = scanner.nextLine();
		} while(!daLiJeVeciDatum(datumMinP2, datumMaxSP2));
		datumMaxP2 = LocalDate.parse(datumMaxSP2, dtf);
		
		int godProizvodnjeMin = 0;
		String godProizvodnjeMinS = null;
		int godProizvodnjeMax = 0;
		String godProizvodnjeMaxS = null;
		
		do {
			System.out.print("Unesite minimalnu godinu proizvodnje: ");
			godProizvodnjeMinS = scanner.nextLine();
		} while(!proveraGodProizvodnje(godProizvodnjeMinS));
		godProizvodnjeMin = Integer.parseInt(godProizvodnjeMinS);
		do {
			System.out.print("Unesite maskimsalnu godinu proizvodnje: ");
			godProizvodnjeMaxS = scanner.nextLine();
		} while(!proveraGodProizvodnjeMax(godProizvodnjeMaxS, godProizvodnjeMin));
		godProizvodnjeMax = Integer.parseInt(godProizvodnjeMaxS);
		
		
		agencija.ispis2PeriodaDatumaGodProizvodnjeMinMax(datumMinP1, datumMaxP1, datumMinP2, datumMaxP2, godProizvodnjeMin, godProizvodnjeMax);

	}
	
	public static void prikazProsecneCeneRegistracije(Agencija agencija) {

		String kategorija;
		do {
			System.out.print("Unesite kategoriju vozila (automobil/kombi/minibus/bus/kamion): ");
			kategorija = scanner.nextLine();
		} while(!(kategorija.equals("automobil") || kategorija.equals("kombi") || kategorija.equals("minibus") || kategorija.equals("bus") || kategorija.equals("kamion")));
		
		String godProizvodnjeS;
		do {
			System.out.print("Unesite godinu proizvodnje vozila: ");
			godProizvodnjeS = scanner.nextLine();
		} while(!proveraGodProizvodnje(godProizvodnjeS));
		int godProizvodnje = Integer.parseInt(godProizvodnjeS);
		
		agencija.izracunajProsecnuCenuRegistracije(kategorija, godProizvodnje);
	}
	
	public static void prikazNajskupljeRegistracije(Agencija agencija) {

		String kategorija;
		do {
			System.out.print("Unesite kategoriju vozila (automobil/kombi/minibus/bus/kamion): ");
			kategorija = scanner.nextLine();
		} while(!(kategorija.equals("automobil") || kategorija.equals("kombi") || kategorija.equals("minibus") || kategorija.equals("bus") || kategorija.equals("kamion")));
		
		String datumMinString = null;
		LocalDate datumMin = null;
		do {
			System.out.print("Datum minimalni: ");
			datumMinString = scanner.nextLine();
		} while(!proveriDatum(datumMinString));
		datumMin = LocalDate.parse(datumMinString, dtf);
		
		LocalDate datumMax = null;
		String datumMaxString;
		do {
			System.out.print("Datum maksimalni: ");
			datumMaxString = scanner.nextLine();
		} while(!daLiJeVeciDatum(datumMin, datumMaxString));
		datumMax = LocalDate.parse(datumMaxString, dtf);

		agencija.pretragaNajskupljeRegistracije(kategorija, datumMin, datumMax);
	}

	public static void main(String[] args) {
		
		Agencija agencija = new Agencija(); 
	
		agencija.ucitaj("agencija.txt");
		String odgovor = null;

		do {

			System.out.println("Meni:");
			System.out.println("1. Unos podataka o agenciji");
			System.out.println("2. Unos novog vozila koje se registruje");
			System.out.println("3. Ispis podataka o svim registrovanim vozilima");
			System.out.println("4. Izmena podataka o vozilu");
			System.out.println("5. Brisanje podataka o vozilu");
			System.out.println("6. Pretraga vozila po marki");
			System.out.println("7. Pretraga registrovanih vozila u 2 perioda i opsegom godine proizvodnje ");
			System.out.println("8. Prikaz prosecne cene registracije vozila zadate kategorije i godine proizvodnje ");
			System.out.println("9. Prikaz najskuplje registracije za odredjenu kateogoriju u zadatom periodu ");
			System.out.println("10. Ispis podataka o agenciji, ukupan br. reg. vozila i ukupne cene prihoda po kategoriji ");
			System.out.println("x. Izlaz");


			odgovor = scanner.nextLine();

			switch (odgovor) {
			case "1":
				unesiAgenciju(agencija);
				agencija.sacuvaj("agencija.txt");
				break;
			case "2":
				unosNovogVozilaKojeRegistrujemo(agencija);
				agencija.sacuvaj("agencija.txt");
				break;
			case "3":
				agencija.ispisNepokretnosti();
				break;
			case "4":
				izmenaVozilaKojeRegistrujemo(agencija);
				agencija.sacuvaj("agencija.txt");
				break;
			case "5":
				izbrisiVozilo(agencija);
				agencija.sacuvaj("agencija.txt");
				break;
			case "6":
				pretragapoMarkiVozila(agencija);
				break;
			case "7":
				pretraga2PeriodaDatumaGodProizvodnjeMinMax(agencija);
				break;
			case "8":
				prikazProsecneCeneRegistracije(agencija);
				break;
			case "9":
				prikazNajskupljeRegistracije(agencija);
				break;
			case "10":
				System.out.println(agencija);
				break;
			case "x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
			}

		} while (!odgovor.equals("x"));
	

		scanner.close();

	}

}
