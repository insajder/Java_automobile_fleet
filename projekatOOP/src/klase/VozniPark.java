/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klase;

import java.util.ArrayList;
import java.util.Scanner;

import greske.RadnikNePostojiException;
import greske.RadnikPostojiException;
import greske.RadnikZaduzenjeException;
import greske.VoziloNePostojiException;
import greske.VoziloPostojiException;

/**
 *
 * @author WINDOWS 10
 */
public class VozniPark {
	static RadDatoteka rd = new RadDatoteka();
	static Scanner unos = new Scanner(System.in);
	
	
    private ArrayList<Vozilo> vozila;
    private ArrayList<Radnik> radnici;

    public VozniPark() {
        this.vozila = rd.izlistajVozila();
        this.radnici = rd.izlistajRadnike();
    }


    public ArrayList<Vozilo> getVozila() {
        return vozila;
    }

    public void setVozila(ArrayList<Vozilo> vozila) {
        this.vozila = vozila;
    }

    public ArrayList<Radnik> getRadnici() {
        return radnici;
    }

    public void setRadnici(ArrayList<Radnik> radnici) throws VoziloPostojiException {
        this.radnici = radnici;
    }
    
    public void kreirajVozilo() throws VoziloPostojiException {  
        String regOznaka;
        String tip;
        String naziv;
        double kapacitet;
        double potrosnja;
        int brojSedista;
        String karoserija;
        double nosivost;
        System.out.println("Uneti registracionu oznaku (BG1111AA): ");
        while(true){
            regOznaka = unos.nextLine();
            
            if(regOznaka.length() < 6 || regOznaka.length() > 8){
                System.out.println("Nepravilan format registarske oznake.");
            }else{
                if(!Character.isAlphabetic(regOznaka.charAt(0)) || !Character.isAlphabetic(regOznaka.charAt(1))){
                    System.out.println("Nepravilan format registarske oznake.");
                }
                if(regOznaka.length() == 6){
                    if(!Character.isDigit(regOznaka.charAt(2)) || !Character.isDigit(regOznaka.charAt(3))){
                        System.out.println("Nepravilan format registarske oznake.");
                    }else{
                        if(!Character.isAlphabetic(regOznaka.charAt(4)) || !Character.isAlphabetic(regOznaka.charAt(5))){
                            System.out.println("Nepravilan format registarske oznake.");
                        }else{
                            break;
                        }
                    }
                }
                if(regOznaka.length() == 7){
                    if(!Character.isDigit(regOznaka.charAt(2)) || !Character.isDigit(regOznaka.charAt(3)) || !Character.isDigit(regOznaka.charAt(4))){
                        System.out.println("Nepravilan format registarske oznake.");
                    }else{
                        if(!Character.isAlphabetic(regOznaka.charAt(5)) || !Character.isAlphabetic(regOznaka.charAt(6))){
                            System.out.println("Nepravilan format registarske oznake.");
                        }else{
                            break;
                        }
                    }
                }
                if(regOznaka.length() == 8){
                    if(!Character.isDigit(regOznaka.charAt(2)) || !Character.isDigit(regOznaka.charAt(3)) || !Character.isDigit(regOznaka.charAt(4)) || !Character.isDigit(regOznaka.charAt(5))){
                        System.out.println("Nepravilan format registarske oznake.");
                    }else{
                        if(!Character.isAlphabetic(regOznaka.charAt(6)) || !Character.isAlphabetic(regOznaka.charAt(7))){
                            System.out.println("Nepravilan format registarske oznake.");
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        String reg = regOznaka.substring(0,2).toUpperCase()+regOznaka.substring(2,regOznaka.length()-2)+regOznaka.substring(regOznaka.length()-2).toUpperCase();
        
        Character.toUpperCase(regOznaka.charAt(1));
        Character.toUpperCase(regOznaka.charAt(regOznaka.length()-1));
        Character.toUpperCase(regOznaka.charAt(regOznaka.length()-2));
        
        System.out.println("Uneti naziv modela: ");
        naziv = unos.nextLine();
        System.out.println("Uneti kapacitet rezervoara: ");
        while(true){
            if(unos.hasNextDouble()){
                kapacitet = unos.nextDouble();
                break;
            }else{
                System.out.println("Nepravilan unos.");
            }
            unos.nextLine();
        }
        System.out.println("Uneti potrosnju: ");
        while(true){
            if(unos.hasNextDouble()){
                potrosnja = unos.nextDouble();
                break;
            }else{
                System.out.println("Nepravilan unos.");
            }
            unos.nextLine();
        }
        unos.nextLine();
        while(true){
            System.out.println("Izaberite tip:");
            System.out.println("a - autobus");
            System.out.println("b - kamion");
            System.out.println("c - automobil");
            tip = unos.nextLine();

            if(tip.equals("a")){
                tip = "Autobus";
                System.out.println("Uneti broj sedista: ");
                while(true){
                    if(unos.hasNextInt()){
                        brojSedista = unos.nextInt();
                        break;
                    }else{
                        System.out.println("Nepravilan unos.");
                    }
                    unos.nextLine();
                }

                Autobus vozilo = new Autobus(reg, tip, naziv, kapacitet, potrosnja, brojSedista);	
                this.dodajVozilo(vozilo);
                rd.upisiVozila(vozila);
                System.out.println("Uspesno ste dodali vozilo.");

                break;
            }else if(tip.equals("b")){
                tip = "Kamion";
                System.out.println("Uneti nosivost: ");
                while(true){
                    if(unos.hasNextDouble()){
                        nosivost = unos.nextDouble();
                        break;
                    }else{
                        System.out.println("Nepravilan unos.");
                    }
                    unos.nextLine();
                }

                Kamion vozilo = new Kamion(reg, tip, naziv, kapacitet, potrosnja, nosivost);
                this.dodajVozilo(vozilo);
                System.out.println("Uspesno ste dodali vozilo.");
                
                break;
            }else if(tip.equals("c")){
                tip = "Automobil";
                System.out.println("Uneti karoseriju: ");
                karoserija = unos.nextLine();

                Automobil vozilo = new Automobil(reg, tip, naziv, kapacitet, potrosnja, karoserija);
                this.dodajVozilo(vozilo);
                System.out.println("Uspesno ste dodali vozilo.");

                break;
            }else{
                System.out.println("Nepravilan unos.");
            }
        }
    }
    
    public void izlistajSvaVozila(){
        for(Vozilo v: vozila){
            System.out.println(v.toString());
        }
    }

    public void izlistajAutobuse(){
        for(Vozilo v: vozila){
            if (v instanceof Autobus) System.out.println(v.toString());
        }
    }
    
    public void izlistajSlobodneAutobuse(){
        for(Vozilo v: vozila){
            if (v instanceof Autobus && this.voziloSlobodno(v)) System.out.println(v.toString());
        }
    }
    
    public void izlistajSlobodneAutobuseZaBrojPutnika(int brojPutnika){
    	boolean postoji = false;
        for(Vozilo v: vozila){
            if (v instanceof Autobus && this.voziloSlobodno(v) && ((Autobus) v).getBrojSedista() >= brojPutnika) { 
            	System.out.println(v.toString());
            	postoji = true;
            }
        }
        if (postoji == false) System.out.println("Ne postoji slobodan autobus sa brojem sedista:  " + brojPutnika);
    }

    public void izlistajKamione(){
        for(Vozilo v: vozila){
            if (v instanceof Kamion) System.out.println(v.toString());
        }
    }
    
    public void izlistajSlobodneKamione(){
        for(Vozilo v: vozila){
            if (v instanceof Kamion && this.voziloSlobodno(v)) System.out.println(v.toString());
        }
    }
    
    public void izlistajSlobodneKamioneZaTeret(double teret){
    	boolean postoji = false;
        for(Vozilo v: vozila){
            if (v instanceof Kamion && this.voziloSlobodno(v) && ((Kamion) v).getNosivost() >= teret) {
            	System.out.println(v.toString());
            	postoji = true;
            }
        }
        if (postoji == false) {
            System.out.println("Ne postoji slobodan kamion za nosivost: " + teret + " t");
            return;
        }
    }

    public void izlistajAutomobile(){
        for(Vozilo v: vozila){
            if (v instanceof Automobil) System.out.println(v.toString());
        }
    }
    
    public void izlistajSlobodneAutomobile(){
        for(Vozilo v: vozila){
            if (v instanceof Automobil && this.voziloSlobodno(v)) System.out.println(v.toString());
        }
    }
    
    public void dodajVozilo(Vozilo v) throws VoziloPostojiException{
        for(int i = 0; i < vozila.size(); i++){
            if(v.registracionaOznaka.equals(vozila.get(i).registracionaOznaka)){
                throw new VoziloPostojiException();
            }
        }
        vozila.add(v);
        rd.upisiVozila(vozila);
        vozila = rd.izlistajVozila();
    }

    public void obrisiVozilo() throws VoziloNePostojiException{
    	unos.nextLine();
        System.out.println("Uneti registracionu oznaku: ");
        String regOznaka = unos.nextLine();
        
        boolean obrisan = false;
        for(int i = 0; i < vozila.size(); i++){
            if(regOznaka.equals(vozila.get(i).registracionaOznaka)){
                vozila.remove(vozila.get(i));
                obrisan = true;
                break;
            }
        }
        if(obrisan == true){
            System.out.println("Uspesno brisanje.");
            rd.upisiVozila(vozila);
            vozila = rd.izlistajVozila();
        }else{
        	throw new VoziloNePostojiException();
        }
    }
    
    public boolean voziloSlobodno(Vozilo vozilo) {
    	boolean slobodno = true;
    	for(Radnik r : radnici) {
    		if (r.getVozilo() != null && r.getVozilo().getRegistracionaOznaka().equals(vozilo.getRegistracionaOznaka())) {
    			slobodno = false;
    		}
    	}
    	return slobodno;
    }
    
    public void izlistajSlobodnaVozila () {
    	radnici = rd.izlistajRadnike();
    	boolean slobodno;
    	for(Vozilo v : vozila){
            slobodno = true;
            for(Radnik r : radnici){
                if(r.getVozilo() != null && v.getRegistracionaOznaka().equals(r.getVozilo().getRegistracionaOznaka())){
                    slobodno = false;
                }
            }
            if(slobodno == true) System.out.println(v.toString());
        }
    }
    
    public void izlistajZaduzenaVozila () {
    	radnici = rd.izlistajRadnike();
    	boolean slobodno;
    	for(Vozilo v : vozila){
            slobodno = true;
            for(Radnik r : radnici){
                if(r.getVozilo() != null && v.getRegistracionaOznaka().equals(r.getVozilo().getRegistracionaOznaka())){
                    slobodno = false;
                }
            }
            if(slobodno == false) System.out.println(v.toString());
        }
    }
    
    public void zaduziVozilo() throws VoziloNePostojiException, RadnikNePostojiException, RadnikZaduzenjeException {
    	radnici = rd.izlistajRadnike();
    	
    	System.out.println("Unesite JMBG radnika koji zaduzuje vozilo: ");
    	this.izlistajSlobodneRadnike();
    	String jmbg = unos.nextLine();
    	Radnik radnik = null;
    	for (Radnik r : radnici) {
    		if (r.getJmbg().equals(jmbg)) radnik = r;
    	}
    	
    	if (radnik == null) {
    		throw new RadnikNePostojiException();
    	}
    	
    	if (radnik.getVozilo() != null) {
    		throw new RadnikZaduzenjeException(true);
    	}
    	
        
    	String tip = "";
        int brojPutnika = 0;
        double teret = 0;
        
        
        boolean izadji = false;
        while(true) {

            System.out.println("Izaberite tip:");
            System.out.println("a - autobus");
            System.out.println("b - kamion");
            System.out.println("c - automobil");
            tip = unos.nextLine();
            
	        switch(tip) {
	        	case "a":
	        		System.out.println("Unesite broj putnika:");
	        		while(true) {
	        			if(unos.hasNextInt()) {
	    	        		brojPutnika = unos.nextInt();
	    	        		break;
	        			}
	        			System.out.println("Nepravilan unos");
	        			unos.next();
	        		}
	        		//this.izlistajSlobodneAutobuseZaBrojPutnika(brojPutnika);
                                boolean postoji = false;
                                for(Vozilo v: vozila){
                                    if (v instanceof Autobus && this.voziloSlobodno(v) && ((Autobus) v).getBrojSedista() >= brojPutnika) { 
                                        System.out.println(v.toString());
                                        postoji = true;
                                    }
                                }
                                if (postoji == false) {
                                    System.out.println("Ne postoji slobodan autobus sa brojem sedista:  " + brojPutnika);
                                    return;
                                }
	        		izadji = true;
	        		break;
	        	case "b":
	        		System.out.println("Unesite kolicinu tereta:");
	        		while(true) {
	        			if(unos.hasNextDouble()) {
	    	        		teret = unos.nextDouble();
	    	        		break;
	        			}
	        			System.out.println("Nepravilan unos");
	        			unos.next();
	        		}
	        		//this.izlistajSlobodneKamioneZaTeret(teret);
                                boolean postoji2 = false;
                                for(Vozilo v: vozila){
                                    if (v instanceof Kamion && this.voziloSlobodno(v) && ((Kamion) v).getNosivost() >= teret) {
                                        System.out.println(v.toString());
                                        postoji2 = true;
                                    }
                                }
                                if (postoji2 == false) {
                                    System.out.println("Ne postoji slobodan kamion za nosivost: " + teret + " t");
                                    return;
                                }
	        		izadji = true;
	        		break;
	        	case "c":
	        		this.izlistajSlobodneAutomobile();
	        		izadji = true;
	        		break;
	        	default:
	        		System.out.println("Nepravilan unos.");
	        		break;
	    	}
	        if (izadji) break;
        }
        unos.nextLine();
    	System.out.println("Unesite registarsku oznaku vozila koje zelite da zaduzite: ");
    	String regOznaka = unos.nextLine();
    	Vozilo vozilo = null;
    	for (Vozilo v : vozila) {
    		if (v.getRegistracionaOznaka().equals(regOznaka)) vozilo = v;
    	}
    	
    	if (vozilo == null) {
    		throw new VoziloNePostojiException();
    	}
    	
    	if (!this.voziloSlobodno(vozilo)) {
    		System.out.println("Vozilo nije slobodno!");
    		return;
    	}
    	
    	if ((tip.equals("a") && !vozilo.getTipVozila().equals("Autobus")) || 
    			(tip.equals("b") && !vozilo.getTipVozila().equals("Kamion")) || 
    			(tip.equals("c") && !vozilo.getTipVozila().equals("Automobil"))) {
    		System.out.println("Pogresan tip vozila");
    		return;
    	}
    	
    	if (tip.equals("a") && ((Autobus) vozilo).getBrojSedista() < brojPutnika) {
    		System.out.println("Nedovoljan broj sedista");
    		return;
    	}
    	
    	if (tip.equals("b") && ((Kamion) vozilo).getNosivost() < teret) {
    		System.out.println("Nedovoljna nosivost");
    		return;
    	}
    	
    	radnik.zaduzi(vozilo);
    	for (int i = 0; i < radnici.size(); i ++) {
    		if (radnici.get(i).getJmbg().equals(radnik.getJmbg())) {
    			radnici.set(i, radnik);
    		}
    	}
    	rd.upisiRadnike(radnici);
    	radnici = rd.izlistajRadnike();
    	System.out.println("Vozilo usepesno zaduzeno.");
    }
    
    public void razduziVozilo() throws RadnikNePostojiException, RadnikZaduzenjeException {    	
    	radnici = rd.izlistajRadnike();
    	System.out.println("Unesite JMBG radnika koji razduzuje vozilo: ");
    	this.izlistajZaduzeneRadnike();
    	String jmbg = unos.nextLine();
    	Radnik radnik = null;
    	for (Radnik r : radnici) {
    		if (r.getJmbg().equals(jmbg)) radnik = r;
    	}
    	
    	if (radnik == null) {
    		throw new RadnikNePostojiException();
    	}
    	
    	if (radnik.getVozilo() == null) {
    		throw new RadnikZaduzenjeException(false);
    	}
    	
    	radnik.razduzi(); 
    	for (int i = 0; i < radnici.size(); i ++) {
    		if (radnici.get(i).getJmbg().equals(radnik.getJmbg())) {
    			radnici.set(i, radnik);
    		}
    	}
    	rd.upisiRadnike(radnici);
    	radnici = rd.izlistajRadnike();
    	System.out.println("Vozilo usepesno razduzeno.");
    }
    
    public void dodajRadnika() throws RadnikPostojiException{
        System.out.println("Uneti JMBG (13 cifara): ");
        String jmbg;
        while(true){
            jmbg = unos.nextLine();
            if(jmbg.trim().length() != 13){
                System.out.println("Nepravilan format JMBG-a.");
            }else{
                boolean provera = true;
                for(int i=0; i<jmbg.length(); i++){
                    if(!Character.isDigit(jmbg.charAt(i))){
                        System.out.println("Nepravilan format JMBG-a.");
                        provera = false;
                    }
                }
                if(provera == true) break;
            }
        }
        System.out.println("Uneti ime i prezime: ");
        String ime = unos.nextLine();
        Radnik radnik = new Radnik(jmbg, ime, null);
        
    	for(int i = 0; i < radnici.size(); i++){
            if(radnik.getJmbg().equals(radnici.get(i).getJmbg())){
                throw new RadnikPostojiException();
            }
        }
        radnici.add(radnik);
        rd.upisiRadnike(radnici);
        radnici = rd.izlistajRadnike();
    }

    public void obrisiRadnika() throws RadnikNePostojiException{
        System.out.println("Uneti jmbg radnika za brisanje:");
        String jmbg = unos.nextLine();
        
        boolean obrisan = false;
        for(int i = 0; i < radnici.size(); i++){
            if(jmbg.equals(radnici.get(i).getJmbg())){
                radnici.remove(radnici.get(i));
                obrisan = true;
                break;
            }
        }
        if(obrisan == true){
            System.out.println("Uspesno brisanje radnika.");
            rd.upisiRadnike(radnici);
            radnici = rd.izlistajRadnike();
        }else{
            throw new RadnikNePostojiException();
        }
    }
    
    public void izlistajSveRadnike () {
    	for(Radnik r : radnici)
            System.out.println(r.toString());
    }
    
    public void izlistajSlobodneRadnike() {
    	radnici = rd.izlistajRadnike();
    	for(Radnik r : radnici){
            if(r.getVozilo() == null){
                System.out.println(r.toString());
            }
        }
    }
    
    public void izlistajZaduzeneRadnike() {
    	radnici = rd.izlistajRadnike();
    	for(Radnik r : radnici){
            if(r.getVozilo() != null){
                System.out.println(r.toString());
            }
        }
    }
}
