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
public class Kamion extends Vozilo {
    private double nosivost;

    public Kamion() {
        super();
        this.nosivost = 0;
    }

    public Kamion(String registracionaOznaka, String tipVozila, String naziv, double kapacitetRezervoara, double potrosnja, double nosivost) {
        super(registracionaOznaka, "Kamion", naziv, kapacitetRezervoara, potrosnja);
        this.nosivost = nosivost;
    }

    public double getNosivost() {
        return nosivost;
    }

    public void setNosivost(double nosivost) {
        this.nosivost = nosivost;
    }

    @Override
    public String toString() {
        return super.toString() +", Nosivost: " + nosivost + "t ";
    }

    public String upis(){
        return super.upis() + "~" + nosivost + "\n";
    }
    
}
