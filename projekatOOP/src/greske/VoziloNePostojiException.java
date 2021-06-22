package greske;

public class VoziloNePostojiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8480696965769457035L;
	
	public VoziloNePostojiException(){
        System.out.println("Vozilo sa unetom registarskom oznakom ne postoji.");
    }
}
