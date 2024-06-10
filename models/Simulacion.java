package models;

import java.util.ArrayList;

import vista.VentanaSimulacion;

public class Simulacion {

	private RecursoCompartido rc;
	private ArrayList<ClienteThread> clientes = new ArrayList<> (); //thread
	private ArrayList<ChoferThread> choferes = new ArrayList<> (); //thread
	private SistemaThread sistemaThread;
	private Sistema sistema = Sistema.getInstancia();
	private int cantMaxSolicitudes = 5;
	private int cantMaxViajes = 10;
	
	public Simulacion(RecursoCompartido rc) {
		super();
		this.rc = rc;
		this.sistemaThread = new SistemaThread(this.rc);
	}
	
	public void start (VentanaSimulacion ventana) {
		
		for (int i = 0; i < sistema.getChoferes().size() ; i++)
			choferes.add(new ChoferThread(rc, (int) (Math.random() * this.cantMaxViajes) + 1, sistema.getChoferes().get(i)));
		rc.setCantChoferes(choferes.size());
		

		for (int i = 0; i < sistema.getClientes().size() ; i++) 
			clientes.add(new ClienteThread(rc, (int) (Math.random() * this.cantMaxSolicitudes) + 1, sistema.getClientes().get(i)));
		rc.setCantClientes(clientes.size());

		OjoChofer ojochofer = new OjoChofer(rc, choferes.get(0), ventana);
		OjoSistema ojosistema = new OjoSistema(rc, ventana);
		OjoCliente ojocliente = new OjoCliente(rc, clientes.get(0), ventana);
		
		
		for (int i = 0; i < this.choferes.size() ; i++) {
			choferes.get(i).start();
		}
			

		for (int i = 0; i < this.clientes.size() ; i++)
			clientes.get(i).start();

		this.sistemaThread.start();
		
	}

	public boolean isFinalizada() {
		
		return (rc.getCantChoferes() == 0 || rc.getCantClientes() == 0);
			
	}
}
