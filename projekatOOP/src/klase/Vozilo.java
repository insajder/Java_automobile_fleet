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
public abstract class Vozilo {
    protected String registracionaOznaka;
    protected String tipVozila;
    protected String naziv;
    protected double kapacitetRezervoara;
    protected double potrosnja;

    public Vozilo() {
        this.registracionaOznaka = "";
        this.tipVozila = "";
        this.naziv = "";
        this.kapacitetRezervoara = 0;
        this.potrosnja = 0;
    }

    public Vozilo(String registracionaOznaka, String tipVozila, String naziv, double kapacitetRezervoara, double potrosnja) {
        this.registracionaOznaka = registracionaOznaka;
        this.tipVozila = tipVozila;
        this.naziv = naziv;
        this.kapacitetRezervoara = kapacitetRezervoara;
        this.potrosnja = potrosnja;
    }

    public String getTipVozila() {
        return tipVozila;
    }

    public void setTipVozila(String tipVozila) {
        this.tipVozila = tipVozila;
    }

    public String getRegistracionaOznaka() {
        return registracionaOznaka;
    }

    public void setRegistracionaOznaka(String registracionaOznaka) {
        this.registracionaOznaka = registracionaOznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getKapacitetRezervoara() {
        return kapacitetRezervoara;
    }

    public void setKapacitetRezervoara(double kapacitetRezervoara) {
        this.kapacitetRezervoara = kapacitetRezervoara;
    }

    public double getPotrosnja() {
        return potrosnja;
    }

    public void setPotrosnja(double potrosnja) {
        this.potrosnja = potrosnja;
    }

    @Override
    public String toString() {
        return registracionaOznaka + ", " + tipVozila + ": " + naziv + ", Kapacitet: " + kapacitetRezervoara + "l, Potrosnja: " + potrosnja + "l/100km ";
    }

    public String upis(){
        return registracionaOznaka + "~" + tipVozila + "~" + naziv + "~" + kapacitetRezervoara + "~" + potrosnja;
    }

}
