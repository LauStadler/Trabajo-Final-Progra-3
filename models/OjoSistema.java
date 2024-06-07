package models;

import java.util.Observable;
import java.util.Observer;

public class OjoSistema implements Observer {
	private RecursoCompartido rc;
	
	public OjoSistema(RecursoCompartido rc) {
		this.setRecursoCompartido(rc);
		this.rc.addObserver(this);
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
		{		}
		
	}
}
