/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klase;

/**
 *
 * @author WINDOWS 10
 */
public class Automobil extends Vozilo {
    private String karoserija;

    public Automobil() {
        super();
        this.karoserija = "";
    }

    public Automobil(String registracionaOznaka, String tipVozila, String naziv, double kapacitetRezervoara, double potrosnja, String karoserija) {
        super(registracionaOznaka, "Automobil", naziv, kapacitetRezervoara, potrosnja);
        this.karoserija = karoserija;
    }

    public String getKaroserija() {
        return karoserija;
    }

    public void setKaroserija(String karoserija) {
        this.karoserija = karoserija;
    }

    @Override
    public String toString() {
        return super.toString() +", " + karoserija;
    }

    public String upis(){
        return super.upis() + "~" + karoserija + "\n";
    }

}
