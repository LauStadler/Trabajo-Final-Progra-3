package models;

import java.util.Observable;
import java.util.Observer;

import vista.VentanaSimulacion;

public class OjoCliente implements Observer {
    
	private Observable rc;
	private ClienteThread cliente;
	private VentanaSimulacion ventana;
	
	public OjoCliente(RecursoCompartido rc, ClienteThread cliente, VentanaSimulacion ventana) {
		this.setObservable(rc);
		rc.addObserver(this);
		this.setClienteThread(cliente);
		this.setVentana(ventana);
	}
	
	@Override
	public void update(Observable o, Object arg) {


		if (this.rc != o ) {
			throw new IllegalArgumentException();
		}
		else
		{
            if (this.rc == o) { //estado del viaje
	    		IViaje viaje= (IViaje) arg;
			 	if (viaje.getCliente() == this.cliente.getCliente()){
	   				if(viaje.getEstado().equals("Solicitado")){
		   				this.ventana.appendTextCliente("Viaje Solicitado");
		   			}
		   			else if(viaje.getEstado().equals("Con Vehiculo")){
		   				this.ventana.appendTextCliente("Al viaje se le asigno el vehiculo "+viaje.getVehiculo().getPatente());
					}
	   				else if(viaje.getEstado().equals("Iniciado")){
	   					this.ventana.appendTextCliente("Al viaje lo tomo el chofer "+viaje.getChofer().getNombre());
						this.ventana.appendTextCliente("Viaje iniciado");		
		   			}
		   			else if(viaje.getEstado().equals("Pagado")){
		   				this.ventana.appendTextCliente("El viaje fue pagado");
		   			}
					else if(viaje.getEstado().equals("Finalizado")){
	   					this.ventana.appendTextCliente("Finalizo el viaje de " + viaje.getCliente().getUsuario());
					}
	   				else if (viaje.getEstado().equals("Rechazado")) {
	   					this.ventana.appendTextCliente("Se rechazo el viaje de " + viaje.getCliente().getUsuario());
	   					}
	   				}
	   			}
			 }
 	}

	
	public void setClienteThread(ClienteThread cliente){
       this.cliente = cliente;
	}

	public ClienteThread getClienteThread(){
		return this.cliente;
	}
	
	public Observable getObservable() {
		return this.rc;
	}

	private void setObservable(Observable rc) {
		this.rc=rc;
	}

	public void setVentana(VentanaSimulacion ventana){
		this.ventana=ventana;
	}

	public VentanaSimulacion getVentana(){
		return this.ventana;
	}
}
