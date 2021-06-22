package greske;

public class RadnikZaduzenjeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -925151618424933535L;

	public RadnikZaduzenjeException(boolean zaduzen){
		if (zaduzen) System.out.println("Radnik vec ima zaduzenje.");
		else System.out.println("Radnik nema zaduzenje.");
    }
}
