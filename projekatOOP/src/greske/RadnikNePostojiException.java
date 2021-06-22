package greske;

public class RadnikNePostojiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293601134892941387L;
	
	public RadnikNePostojiException(){
        System.out.println("Radnik sa unetim parametrom ne postoji.");
    }
}
