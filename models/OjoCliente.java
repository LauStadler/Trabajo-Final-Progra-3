package models;

import java.util.Observable;
import java.util.Observer;

public class OjoCliente implements Observer {
    
	private RecursoCompartido rc;
	
	public OjoCliente(RecursoCompartido rc) {
		rc.addObserver(this);
	
	}
	
	@Override
	public void update(Observable o, Object arg) {
	   
		if (this.rc!=o) {
			throw new InterruptedException();
		}
		else
		{}
	}
	
	
	private RecursoCompartido getObservable() {
		return this.rc;
	}

	private void setObservable(RecursoCompartido rc) {
		this.rc=rc;
	}
}
