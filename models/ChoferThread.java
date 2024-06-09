package models;

import util.Util;

public class ChoferThread extends Chofer implements Runnable{

	private RecursoCompartido rc;
	private int cantMaxViajes;
	
	
	
	public ChoferThread(RecursoCompartido rc, int cantMaxViajes) {
		super();
		this.rc = rc;
		this.cantMaxViajes = cantMaxViajes;
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

	@Override
	public double getSueldo() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
