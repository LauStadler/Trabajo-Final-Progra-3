package models;

import java.util.Observable;
import java.util.Observer;

import vista.VentanaSimulacion;

public class OjoChofer implements Observer{
	
	private Observable rc;
	private ChoferThread chofer;
	private VentanaSimulacion ventana;
	
	public OjoChofer(RecursoCompartido rc, ChoferThread chofer, VentanaSimulacion ventana) {
       this.setObservable(rc);
       this.rc.addObserver((Observer) this);
       this.setChoferThread(chofer);
	   this.ventana=ventana;
	}
	
	private void setObservable(RecursoCompartido rc) {
		this.rc=rc;
	}
	
	private Observable getObservable() {
		return this.rc;
	}
	
	private void setChoferThread(ChoferThread chofer) {
		this.chofer  = chofer;
	}

	private ChoferThread getChoferThread() {
		return this.chofer;
	}
	
	@Override
	public void update(Observable o, Object arg) {
	  
		
	  if (this.rc!= o ) {//o chofer nose
		  throw new IllegalArgumentException();
	  }
	  else
	  {
		 if(this.rc == o) {
				 IViaje viaje = (IViaje) arg;
		         if(viaje.getChofer() == this.chofer.getChofer()){
					if(viaje.getEstado().equals("Iniciado")){
						this.ventana.appendTextChofer("El chofer "+viaje.getChofer().getNombre()+" agarro un viaje");
					}
					else if(viaje.getEstado().equals("Pagado")){
						this.ventana.appendTextChofer("El cliente "+viaje.getCliente().getUsuario()+" pago el viaje");
					}
					else if(viaje.getEstado().equals("Finalizado")){
						this.ventana.appendTextChofer("El chofer "+ viaje.getChofer().getNombre()+ " finalizo el viaje");
					}
					else if (viaje.getEstado().equals("Rechazado")) {
	   					this.ventana.appendTextChofer("Se rechazo el viaje de " + viaje.getCliente().getUsuario());
	   					}
		         }
			 }
		 }
	  }
}
	


