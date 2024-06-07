package models;

import java.util.Observable;
import java.util.Observer;

public class OjoChofer implements Observer{
	
	private RecursoCompartido rc;
	private ChoferThread chofer;
	
	private OjoChofer(RecursoCompartido rc,ChoferThread chofer) {
       this.setObservable(rc);
       this.rc.addObserver((Observer) this);
       this.setChoferThread(chofer);
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
	  {}
	}
	
	

}
