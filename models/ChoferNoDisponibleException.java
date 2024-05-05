package models;

public class ChoferNoDisponibleException extends ViajeNoPosibleException{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3729147028954420152L;

	public ChoferNoDisponibleException(String argumento){
        super(argumento);
    }
}