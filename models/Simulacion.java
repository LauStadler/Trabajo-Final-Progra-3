package models;

import java.util.ArrayList;

public class Simulacion {

	private RecursoCompartido rc;
	private ArrayList<Thread> clientes = new ArrayList<> (); //thread
	private ArrayList<Thread> choferes = new ArrayList<> (); //thread
	private SistemaThread sistemaThread;
	private Sistema sistema;
	private int cantMaxSolicitudes = 5;
	private int cantMaxViajes = 10;
	
	public Simulacion() {
		super();
		this.rc = new RecursoCompartido(sistema);
		this.sistemaThread = new SistemaThread(this.rc);
	}
	
	public void start () {
		
		for (int i = 0; i < sistema.getChoferes().size() ; i++)
			choferes.add(new Thread(new ChoferThread(rc, (int) (Math.random() * this.cantMaxViajes) + 1, sistema.getChoferes().get(i))));
		rc.setCantChoferes(choferes.size());
		
		for (int i = 0; i < sistema.getClientes().size() ; i++) 
			clientes.add(new Thread (new ClienteThread(rc, (int) (Math.random() * this.cantMaxSolicitudes) + 1, sistema.getClientes().get(i))));
		rc.setCantClientes(clientes.size());

		for (int i = 0; i < sistema.getChoferes().size() ; i++)
			choferes.get(i).start();

		for (int i = 0; i < sistema.getClientes().size() ; i++)
			clientes.get(i).start();

		this.sistemaThread.start();
		
	}

	public boolean isFinalizada() {
		return (rc.getCantChoferes() == 0 && rc.getCantClientes() == 0);
			
	}
}
