package models;

public class SistemaThread extends Thread{

	private RecursoCompartido rc;
	
	public SistemaThread(RecursoCompartido rc) {
		super();
		this.rc = rc;
	}

	@Override
	public void run () {
		
		while (rc.getCantChoferes() > 0 && rc.getCantClientes() > 0) {
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rc.asignaVehiculo();
		}
		rc.finalizar();
	}
	
	
}