package models;

public class ClienteThread extends Thread {
	
	private RecursoCompartido rc;
	private int cantSolicitudes;
	private Cliente cliente;
	
	public ClienteThread(RecursoCompartido rc, int cantSolicitudes, Cliente cliente) {
		super();
		this.rc = rc;
		this.cantSolicitudes = cantSolicitudes;
		this.cliente = cliente;
	}
	
	public void run () {
		
		
	}
	
}
