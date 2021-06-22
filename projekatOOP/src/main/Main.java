/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import klase.PomocneMetode;

/**
 *
 * @author WINDOWS 10
 */
public class Main {
    public static void main(String[] args) {
        PomocneMetode pm = new PomocneMetode();
        Scanner unos = new Scanner(System.in);

        String opcija;
        boolean izadji=false;
        System.out.println("***VOZNI PARK***");
        while(true){
            System.out.println("________________________");
            System.out.println("1 - Izlistaj vozni park");
            System.out.println("2 - Radnici");
            System.out.println("3 - Vozila");
            System.out.println("4 - Zaduzi/Razduzi vozilo");
            System.out.println("X - Izadji iz aplikacije");
            System.out.println("________________________");
            opcija = unos.next();
            switch(opcija){
                case "1":
                    pm.izlistajSvaVozilaMeni();
                    break;
                case "2":
                    pm.radniciMeni();
                    break;
                case "3":
                    pm.vozilaMeni();
                    break;
                case "4":
                    pm.zaduziMeni();
                    break;
                case "X","x":
                    izadji=true;
                    break;
                default:
                    System.out.println("Neispravan unos, pokusajte ponovo");
            }
            if(izadji==true) {
            	unos.close();
            	break;
        	};
        }
        
    }
}
