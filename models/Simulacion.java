package models;

import java.util.ArrayList;

public class Simulacion {

	private RecursoCompartido rc;
	private ArrayList<ClienteThread> clientes = new ArrayList<> ();
	private ArrayList<ChoferThread> choferes = new ArrayList<> ();
	private SistemaThread sistemaThread;
	private Sistema sistema = Sistema.getInstancia();
	private int cantMaxSolicitudes = 5;
	private int cantMaxViajes = 10;
	
	public Simulacion() {
		super();
		this.rc = new RecursoCompartido(sistema);
		this.sistemaThread = new SistemaThread(this.rc);
	}
	
	public void start () {
		
		
		for (int i = 0; i < sistema.getChoferes().size() ; i++) {
			choferes.add(new ChoferThread(rc, (int) (Math.random() * this.cantMaxViajes) + 1, sistema.getChoferes().get(i)));
			choferes.get(i).start();
		}
		rc.setCantChoferes(choferes.size());
		
		for (int i = 0; i < sistema.getClientes().size() ; i++) {
			clientes.add(new ClienteThread(rc, (int) (Math.random() * this.cantMaxSolicitudes) + 1, sistema.getClientes().get(i)));
			clientes.get(i).start();
		}
		rc.setCantClientes(clientes.size());
		
		this.sistemaThread.start();
		
	}
	
}
