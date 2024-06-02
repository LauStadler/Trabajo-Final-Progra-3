package models;

public class SistemaThread extends Thread{

	private RecursoCompartido rc;
	
	@Override
	public void run () {
		
		while (rc.isSimulacionActiva()) {
			rc.asignaVehiculo();
		}
	}
	
}
