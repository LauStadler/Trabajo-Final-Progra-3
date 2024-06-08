package models;

import java.util.Observable;
import java.util.Observer;

public class OjoSistema implements Observer {
	private RecursoCompartido rc;
	private VentanaSistema ventana;
	
	public OjoSistema(RecursoCompartido rc,VentanaSistema ventana) {
		this.setRecursoCompartido(rc);
		this.rc.addObserver(this);
		this.ventana=ventana;
	}
	
	public void setRecursoCompartido(RecursoCompartido rc) {
		this.rc=rc;
	}
	
	public RecursoCompartido getRecursoCompartido() {
		return this.rc;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(this.rc!=o) {
			throw new InterruptedException();
		}
		else
		{	IViaje viaje= (IViaje) arg;
			 if (viaje.getCliente==this.cliente){
				if(viaje.getEstado.equals("Solicitado")){
					this.ventana.appendText("Viaje solicitado por el cliente "+viaje.getCliente().getUsuario());
				}
				else if(viaje.getEstado.equals("Con vehiuculo"){
					this.ventana.appendText("Al viaje del cliente "+viaje.getCliente().getUsuario()+" se le asigno el vehiculo"+viaje.getVehiculo().getPatente());
				}
				else if(viaje.getEstado.equals("Iniciado")){
					this.ventana.appendText("Al viaje del cliente"+viaje.getCliente().getUsuario()+" lo tomo el chofer"+viaje.getChofer().getNombre());
					this.ventana.appendText("Viaje del cliente "+viaje.getCliente().getUsuario()+" iniciado");
				}
				else if(viaje.getEstado().equals("Pagado")){
					this.ventana.appendText("El viaje fue pagado por el cliente "+viaje.getCliente().getUsuario());
				}
				else if(viaje.getEstado().equals("Finalizado")){
					this.ventana.appendText("El chofer "+viajes.getChofer().getNombre()+" finalizo el viaje del cliente "+viaje.getCliente().getUsuario());
				}
			 }	
		}
		
	}
}
