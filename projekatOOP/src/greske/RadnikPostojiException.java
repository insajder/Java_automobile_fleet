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
public class RadnikPostojiException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5029003627080956165L;

	public RadnikPostojiException(){
        System.out.println("Radnik vec postoji.");
    }
}
