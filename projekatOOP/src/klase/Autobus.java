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
public class Autobus extends Vozilo {
    private int brojSedista;

    public Autobus() {
        super();
        this.brojSedista = 0;
    }

    public Autobus(String registracionaOznaka, String tipVozila, String naziv, double kapacitetRezervoara, double potrosnja, int brojSedista) {
        super(registracionaOznaka, "Autobus", naziv, kapacitetRezervoara, potrosnja);
        this.brojSedista = brojSedista;
    }

    public int getBrojSedista() {
        return brojSedista;
    }

    public void setBrojSedista(int brojSedista) {
        this.brojSedista = brojSedista;
    }

    @Override
    public String toString() {
        return super.toString() +", Broj sedista: " + brojSedista;
    }
    
    public String upis(){
        return super.upis() + "~" + brojSedista + "\n";
    }
    
}
