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
public class Radnik implements Revers {
    private String jmbg;
    private String imePrezime;
    private Vozilo vozilo;

    public Radnik() {
        this.jmbg = "";
        this.imePrezime = "";
        this.vozilo = null;
    }

    public Radnik(String jmbg, String imePrezime, Vozilo vozilo) {
        this.jmbg = jmbg;
        this.imePrezime = imePrezime;
        this.vozilo = vozilo;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    @Override
    public void zaduzi(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    @Override
    public void razduzi() {
        this.vozilo = null;
    }

    @Override
    public String toString() {
        String ispis = "JMBG: " + jmbg + ", " + imePrezime + ",";
        if(vozilo != null) ispis += " zaduzen";
        else ispis += " nije zaduzen";
        return ispis;
    }

    public String upis(){
        if(vozilo == null) {
            return jmbg + "~" + imePrezime + "~" + "null" + "\n";
        }
        return jmbg + "~" + imePrezime + "~" + vozilo.getRegistracionaOznaka() + "\n";
    }
}
