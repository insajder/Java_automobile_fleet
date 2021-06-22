/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klase;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author WINDOWS 10
 */
public class RadDatoteka {
    public ArrayList<Vozilo> izlistajVozila(){
        ArrayList<Vozilo> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("vozila.txt"));
            
            String red = "";
            while((red=br.readLine())!=null){                
                String[] podeli = red.split("~");
                if(podeli[1].equals("Autobus")){
                    lista.add(new Autobus(podeli[0], podeli[1], podeli[2], Double.parseDouble(podeli[3]), Double.parseDouble(podeli[4]), Integer.parseInt(podeli[5])));
                }
                else if(podeli[1].equals("Kamion")){
                    lista.add(new Kamion(podeli[0], podeli[1], podeli[2], Double.parseDouble(podeli[3]), Double.parseDouble(podeli[4]), Double.parseDouble(podeli[5])));
                }
                else if(podeli[1].equals("Automobil")){
                    lista.add(new Automobil(podeli[0], podeli[1], podeli[2], Double.parseDouble(podeli[3]), Double.parseDouble(podeli[4]), podeli[5]));
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Radnik> izlistajRadnike(){
        
        ArrayList<Vozilo> lst_vozila = new ArrayList<>();
        lst_vozila = izlistajVozila();
        
        ArrayList<Radnik> lista = new ArrayList<Radnik>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("radnici.txt"));
            String red = "";
            while((red=br.readLine())!=null){
            	Vozilo vozilo = null;
                String[] podeli = red.split("~");
                if(!podeli[2].equals("null")){
                    for(Vozilo v: lst_vozila){
                        if(podeli[2].equals(v.getRegistracionaOznaka())){
                            vozilo = v;
                        }
                    }
                }
                
                lista.add(new Radnik(podeli[0], podeli[1], vozilo));
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void upisiVozila(ArrayList<Vozilo> lista){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("vozila.txt"));
            for(Vozilo v: lista)
                bw.write(v.upis());
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void upisiRadnike(ArrayList<Radnik> lista){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("radnici.txt"));
            for(Radnik r: lista)
                bw.write(r.upis());
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
