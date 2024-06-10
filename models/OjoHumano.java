package models;

import java.util.Observable;
import java.util.Observer;

import vista.VistaCliente;

public class OjoHumano implements Observer{

	private Observable rc;
	private Cliente cliente;
	private VistaCliente ventana;
	
	public OjoHumano(Observable rc, Cliente cliente, VistaCliente ventana) {
		super();
		this.rc = rc;
		this.cliente = cliente;
		this.ventana = ventana;
		this.rc.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (this.cliente != o && this.rc != o ) {
			throw new IllegalArgumentException();
		}
		else
		{
            if (this.rc == o) {
	        	IViaje viaje= (IViaje) arg;
	   		 	if (viaje.getCliente() == this.cliente){
		   			if(viaje.getEstado().equals("Solicitado")){
						this.ventana.appendText("Viaje Solicitado");
		   			}
		   			else if(viaje.getEstado().equals("Con Vehiculo")){
		  				this.ventana.appendText("Al viaje se le asigno el vehiculo"+viaje.getVehiculo().getPatente());
		  			}
		   			else if(viaje.getEstado().equals("Iniciado")){
		   				this.ventana.appendText("Al viaje lo tomo el chofer"+viaje.getChofer().getNombre());
		   				this.ventana.appendText("Viaje iniciado");
		   				this.ventana.habilitaPago();
		   			}
		   			else if(viaje.getEstado().equals("Pagado")){
		   				this.ventana.appendText("El viaje fue pagado");
		   			}
		  			else if(viaje.getEstado().equals("Finalizado")){
		   				this.ventana.appendText("El chofer "+ viaje.getChofer().getNombre()+" finalizo el viaje");
		   			}
		  			else if (viaje.getEstado().equals("Rechazado")) {
	   					this.ventana.appendText("Se rechazo el viaje de " + viaje.getCliente().getUsuario());
	   					}
	   		 	}
			}
 		}
		
	}
}
