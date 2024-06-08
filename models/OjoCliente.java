package models;

import java.util.Observable;
import java.util.Observer;

public class OjoCliente implements Observer {
    
	private RecursoCompartido rc;
	private ClienteThread cliente;
	private VentanaClienteT ventana;
	
	public OjoCliente(RecursoCompartido rc,ClienteThread cliente, VentanaClienteT ventana) {
		this.setObservable(rc);
		rc.addObserver(this);
		this.setClienteThread(cliente);
		this.setVentanaC(ventana)
	}
	
	@Override
	public void update(Observable o, Object arg) {
	   
		if (this.rc!=o ) {
			throw new InterruptedException();
		}
		else
		{
             IViaje viaje= (IViaje) arg;
			 if (viaje.getCliente==this.cliente){
				if(viaje.getEstado.equals("Solicitado")){
					this.ventana.appendText("Viaje Solicitado");
				}
				else if(viaje.getEstado.equals("Con vehiuculo"){
					this.ventana.appendText("Al viaje se le asigno el vehiculo"+viaje.getVehiculo().getPatente());
				}
				else if(viaje.getEstado.equals("Iniciado")){
					this.ventana.appendText("Al viaje lo tomo el chofer"+viaje.getChofer().getNombre());
					this.ventana.appendText("Viaje iniciado");
				}
				else if(viaje.getEstado().equals("Pagado")){
					this.ventana.appendText("El viaje fue pagado");
				}
				else if(viaje.getEstado().equals("Finalizado")){
					this.ventana.appendText("El chofer "+viajes.getChofer().getNombre()+" finalizo el viaje");
				}
			 }
 		}
	}
	
	public void setClienteThread(ClienteThread cliente){
       this.cliente=cliente;
	}

	public ClienteThread getClienteThread(){
		return this.cliente;
	}
	
	public RecursoCompartido getObservable() {
		return this.rc;
	}

	private void setObservable(RecursoCompartido rc) {
		this.rc=rc;
	}

	public void setVentanaC(VentanaClienteT ventana){
		this.ventana=vetana;
	}

	public VentanaClienteT getVentana(){
		return this.ventana;
	}
}
