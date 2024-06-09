package models;

import java.util.Observable;

import util.Util;

public class ChoferThread extends Observable implements Runnable{

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
			viaje = rc.tomaViaje();
			//se supone que el hilo se duerme por 30 segs, para simular un viaje
			Util.espera(30000); 
			rc.finalizaViaje(viaje);
		}
	
		rc.setCantChoferes(rc.getCantChoferes()-1);
	}
	
}
