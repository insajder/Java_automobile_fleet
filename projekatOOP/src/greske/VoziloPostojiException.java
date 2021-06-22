/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greske;

/**
 *
 * @author WINDOWS 10
 */
public class VoziloPostojiException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8269109426544708899L;

	public VoziloPostojiException(){
        System.out.println("Vec postoji vozilo sa ovom registarskom oznakom.");
    }
}
