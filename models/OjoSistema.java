package models;

import java.util.Observable;
import java.util.Observer;

import vista.VentanaSimulacion;

public class OjoSistema implements Observer {
	
	private Observable rc;
	private VentanaSimulacion ventana;
	
	public OjoSistema(Observable rc, VentanaSimulacion ventana) {
		this.setRecursoCompartido(rc);
		this.rc.addObserver(this);
		this.ventana=ventana;
	}
	
	public void setRecursoCompartido(Observable rc) {
		this.rc=rc;
	}
	
	public Observable getRecursoCompartido() {
		return this.rc;
	}

	@Override
	public void update(Observable o, Object arg){

		if(this.rc!= o) {
			throw new IllegalArgumentException();
		}
		else
		{	IViaje viaje= (IViaje) arg;
			if(viaje.getEstado().equals("Solicitado")){
				this.ventana.appendTextGeneral("Viaje solicitado por el cliente "+viaje.getCliente().getUsuario());
			}
			else if(viaje.getEstado().equals("Con Vehiculo")){
				this.ventana.appendTextGeneral("Al viaje del cliente "+viaje.getCliente().getUsuario()+" se le asigno el vehiculo"+viaje.getVehiculo().getPatente());
			}
			else if(viaje.getEstado().equals("Iniciado")){
				this.ventana.appendTextGeneral("Al viaje del cliente"+viaje.getCliente().getUsuario()+" lo tomo el chofer"+viaje.getChofer().getNombre());					
				this.ventana.appendTextGeneral("Viaje del cliente "+viaje.getCliente().getUsuario()+" iniciado");
			}
			else if(viaje.getEstado().equals("Pagado")){
				this.ventana.appendTextGeneral("El viaje fue pagado por el cliente "+viaje.getCliente().getUsuario());
			}
			else if(viaje.getEstado().equals("Finalizado")){
				this.ventana.appendTextGeneral(" finalizo el viaje del cliente "+viaje.getCliente().getUsuario());
		    }
			else if (viaje.getEstado().equals("Rechazado")) {
					this.ventana.appendTextCliente("Se rechazo el viaje de " + viaje.getCliente().getUsuario());
			}
		}
		
	}
}
