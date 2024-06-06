package models;

public class ChoferThread extends  Thread{

	private RecursoCompartido rc;
	private int cantMaxViajes;
	private Chofer chofer;
	
	
	
	public ChoferThread(RecursoCompartido rc, int cantMaxViajes, Chofer chofer) {
		super();
		this.rc = rc;
		this.cantMaxViajes = cantMaxViajes;
		this.chofer = chofer;
	}

	public void run () {
		
		
	}
	
}
