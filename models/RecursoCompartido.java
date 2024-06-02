package models;

import java.util.ArrayList;

public class RecursoCompartido {

	private boolean simulacionActiva;
	private boolean available;
	private Sistema empresa;
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();//add y remove
	private ArrayList<Vehiculo> vehiculosDisp = new ArrayList<Vehiculo>();//add y remove
	private ArrayList<IViaje> viajes = new ArrayList<IViaje>();	//add 
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public boolean isSimulacionActiva() {
		return simulacionActiva;
	}

	public void setSimulacionActiva(boolean simulacionActiva) {
		this.simulacionActiva = simulacionActiva;
	}
	
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public IViaje buscaViajeSolicitado() {
		
		int  i = 0;
		
		while (viajes.get(i).getEstado().equals("Solicitado")) {
			i++;
		}
		
		return viajes.get(i);
	}

	public synchronized void asignaVehiculo() {
		
		IViaje viaje;
		//busca un viaje en estadosolicitado;
		while(!available && simulacionActiva) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		if (simulacionActiva) {
			setAvailable(false);
			viaje = buscaViajeSolicitado();
			Vehiculo vehiculo = empresa.buscaVehiculoDisp();
			viaje.setVehiculo(vehiculo);
			setAvailable(true);
			notifyAll();
		}
		
		
		
	}
	
}
