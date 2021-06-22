/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klase;

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
public class PomocneMetode {
	static VozniPark vozniPark = new VozniPark();
	static Scanner unos = new Scanner(System.in);
	
    public static void izlistajSvaVozilaMeni(){        
        boolean izadji=false;
        while(true){
            System.out.println("________________________");
            System.out.println("1 - Sva vozila");
            System.out.println("2 - Autobusi");
            System.out.println("3 - Kamioni");
            System.out.println("4 - Automobili");
            System.out.println("X - Nazad");
            System.out.println("________________________");
            String opcija = unos.next();

            switch(opcija){
                case "1":
                    vozniPark.izlistajSvaVozila();
                    break;
                case "2":
                	vozniPark.izlistajAutobuse();
                    break;
                case "3":
                	vozniPark.izlistajKamione();
                    break;
                case "4":
                	vozniPark.izlistajAutomobile();
                    break;
                case "X", "x":
                    izadji=true;
                    break;
                default:
                    System.out.println("Nepravilna opcija");
                    break;
            }
            if(izadji==true) break;
        }
    }
    
    public static void radniciMeni(){                
        boolean izadji=false;
        while(true){
            System.out.println("________________________");
            System.out.println("1 - Svi radnici");
            System.out.println("2 - Dodaj radnika");
            System.out.println("3 - Obrisi radnika");
            System.out.println("X - Nazad");
            System.out.println("________________________");
            String opcija = unos.next();

            switch(opcija){
                case "1":
                    vozniPark.izlistajSveRadnike();
                    break;
                case "2":
                    try{
                    	vozniPark.dodajRadnika();
                        System.out.println("Uspesno ste dodali radnika.");
                    }catch(RadnikPostojiException ex){
                        ex.getMessage();
                    }
                    break;
                case "3":
                	try {
                		vozniPark.obrisiRadnika();
                	} catch(RadnikNePostojiException ex) {
                		ex.getMessage();
                	}
                    break;
                case "X", "x":
                    izadji=true;
                    break;
                default:
                    System.out.println("Nepravilna opcija");
                    break;
            }
            if(izadji==true) break;
        }
    }
    
    public static void vozilaMeni(){                
        boolean izadji=false;
        while(true){
            System.out.println("________________________");
            System.out.println("1 - Sva vozila");
            System.out.println("2 - Dodaj vozilo");
            System.out.println("3 - Obrisi vozilo");
            System.out.println("X - Nazad");
            System.out.println("________________________");
            String opcija = unos.next();
            

            switch(opcija){
                case "1":
                	vozniPark.izlistajSvaVozila();
                    break;
                case "2":
					try {
						vozniPark.kreirajVozilo();
					} catch (VoziloPostojiException e) {
						e.getMessage();
					}
                    break;
                case "3":
                    try {
                    	vozniPark.obrisiVozilo();
                    } catch(VoziloNePostojiException ex) {
                    	ex.getMessage();
                    }
                    break;
                case "X", "x":
                    izadji=true;
                    break;
                default:
                    System.out.println("Nepravilna opcija");
                    break;
            }
            if(izadji==true) break;
        }
    }
    
    public static void zaduziMeni(){                
        boolean izadji=false;
        
        while(true){
            System.out.println("________________________");
            System.out.println("1 - Izlistaj slobodna vozila");
            System.out.println("2 - Izlistaj zaduzena vozila");
            System.out.println("3 - Izlistaj slobodne radnike");
            System.out.println("4 - Izlistaj zaduzene radnike");
            System.out.println("5 - Zaduzi");
            System.out.println("6 - Razduzi");
            System.out.println("X - Nazad");
            System.out.println("________________________");
            String opcija = unos.next();

            switch(opcija){
                case "1":
                	vozniPark.izlistajSlobodnaVozila();
                    break;
                case "2":
                	vozniPark.izlistajZaduzenaVozila();
                    break;
                case "3":
                	vozniPark.izlistajSlobodneRadnike();
                    break;
                case "4":
                	vozniPark.izlistajZaduzeneRadnike();
                    break;
                case "5":
					try {
						vozniPark.zaduziVozilo();
					} catch (VoziloNePostojiException | RadnikNePostojiException | RadnikZaduzenjeException e1) {
						e1.getMessage();
					}
                    break;
                case "6":
					try {
						vozniPark.razduziVozilo();
					} catch (RadnikNePostojiException | RadnikZaduzenjeException e) {
						e.getMessage();
					}
                    break;
                case "X", "x":
                    izadji=true;
                    break;
                default:
                    System.out.println("Nepravilna opcija");
                    break;
            }
            if(izadji==true) break;
        }
    }
}
