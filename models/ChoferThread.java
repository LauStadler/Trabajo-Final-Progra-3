package models;

import java.util.Observable;

import util.Util;

public class ChoferThread extends Thread {

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
		
		int cantViajes = 0; //La cantidad de viajes que va a realizar en el dia el chofer
		IViaje viaje;
		while (cantViajes < this.cantMaxViajes  && rc.getCantClientes() > 0) {
			viaje = rc.tomaViaje(this.chofer); 
			//try {
			//	sleep(1000);
			//} catch (InterruptedException e) {
			//	e.printStackTrace();
			//}
			rc.finalizaViaje(viaje);
			cantViajes++;
		}
		rc.setCantChoferes(rc.getCantChoferes()-1);
	}


	public RecursoCompartido getRc() {
		return rc;
	}


	public int getCantMaxViajes() {
		return cantMaxViajes;
	}


	public Chofer getChofer() {
		return chofer;
	}
	
	
}
