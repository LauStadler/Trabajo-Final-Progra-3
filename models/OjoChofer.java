package models;

import java.util.Observable;
import java.util.Observer;

public class OjoChofer implements Observer{
	
	private RecursoCompartido rc;
	private ChoferThread chofer;
	private VentanaChofer ventana;
	
	private OjoChofer(RecursoCompartido rc,ChoferThread chofer,VentanaChofer ventana) {
       this.setObservable(rc);
       this.rc.addObserver((Observer) this);
       this.setChoferThread(chofer);
	   this.ventana=ventana;
	}
	
	private void setObservable(RecursoCompartido rc) {
		this.rc=rc;
	}
	
	private RecursoCompartido getObservable() {
		return this.rc;
	}
	
	private ChoferThread setChoferThread(ChoferThread chofer) {
		this.chofer=chofer;
	}

	private ChoferThread getChoferThread() {
		return this.chofer;
	}
	
	@Override
	public void update(Observable o, Object arg) {
	  if (this.rc!=o) {//o chofer nose
		  throw new InterruptedException();
	  }
	  else
	  {
		 IViaje viaje = (IViaje) arg;
         if(viaje.getChofer()==this.chofer){
			if(viaje.getEstado().equals("Iniaciado")){
				this.ventana.appendText("El chofer "+viaje.getChofer().getNombre()+" agarro un viaje ");
			}
			else if(viaje.getEstado().equals("Iniciado"){
				this.ventana.appendText("El cliente "+viaje.getCliente().getUsuario()+" pago el viaje");
			}
			else if(viaje.getEstado().equals("Finalizado")){
				this.ventana.appendText("El chofer "+ viaje.getChofer().getNombre()+ " finalizo el viaje ");
			}

		 }
	  }
	}
	
	

}
