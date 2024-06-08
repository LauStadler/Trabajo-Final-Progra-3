package models;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class RecursoCompartido extends Observable{

	private boolean available;
	private Sistema empresa;
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	private ArrayList<Vehiculo> vehiculosNoDisp = new ArrayList<Vehiculo>(); //vehiculos que estan siendo utilizados
	private ArrayList<Vehiculo> vehiculosDisp = new ArrayList<Vehiculo>(); //vehiculos disponibles para realizar un viaje en este momento
	private ArrayList<IViaje> viajesSolicitados = new ArrayList<IViaje>();	//viajes en estado solicitado
	private ArrayList<IViaje> viajesConVehiculo = new ArrayList<IViaje>(); //viajes con vehiculo ya asignados por el sistema
	private ArrayList<IViaje> viajesEnCurso = new ArrayList<IViaje>(); //Viajes que estan en curso en este momento
	private ArrayList<IViaje> viajesFinalizados = new ArrayList<IViaje>(); //Viajes ya finalizados por el chofer
	//private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int cantChoferes; //
	private int cantClientes;
	private ArrayList<Observer> observadores = new ArrayList<>();
	
	public RecursoCompartido(Sistema s) {
		this.empresa = s;
	}
	
	public int getCantChoferes() {
		return cantChoferes;
	}


	public void setCantChoferes(int cantChoferes) {
		this.cantChoferes = cantChoferes;
	}


	public int getCantClientes() {
		return cantClientes;
	}


	public void setCantClientes(int cantClientes) {
		this.cantClientes = cantClientes;
	}
	
	public Vehiculo buscaVehiculoDisp(Pedido pedido) throws VehiculosNoDisponiblesException {
		Vehiculo vehiculo = null;
		Integer maxPrioridad = 0, aux = null;
		assert pedido != null : "Pedido null";
		for (Vehiculo i : vehiculosDisp) {
			aux = i.getPrioridad(pedido);
		    if (aux != null && aux> maxPrioridad) {
				vehiculo = i;
				maxPrioridad = aux;
			}
		}
			
		if(vehiculo == null )
			throw new VehiculosNoDisponiblesException("No hay vehiculos disponibles, no se puede hacer el viaje en este momento");

		return vehiculo;
		
	}
	
	public synchronized void asignaVehiculo() {
		
		IViaje viaje;
		//busca un viaje en estadosolicitado;
		while(vehiculosDisp.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		viaje = viajesSolicitados.get(0);
		viajesSolicitados.remove(0);
		Vehiculo vehiculo;
		try {
			vehiculo = empresa.buscaVehiculoDisp(viaje.getPedido());
			viaje.setVehiculo(vehiculo);
			viaje.setEstado("Con Vehiculo");
			viajesSolicitados.remove(viaje);
			viajesConVehiculo.add(viaje);
			vehiculosDisp.remove(vehiculo);
			vehiculosNoDisp.add(vehiculo);
			
		} catch (VehiculosNoDisponiblesException e) {
			e.printStackTrace();
		}
		
		notifyAll();	
		setChanged();
		notifyObservers(viaje);
	}
	
	public Pedido creaPedido() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean validaPedido(Pedido pedido) {
		
		if(!pedido.isPedidoValido()) 
			return false;
		
		if (this.cantChoferes <= 0)
			return false;
		
		int i= empresa.getVehiculos().size() - 1;
		while (i>0 && empresa.getVehiculos().get(i).getPrioridad(pedido)==null )
			i--;
		if ( empresa.getVehiculos().get(i).getPrioridad(pedido) != null )
			return true;
		else
			return false;
	}
	
	public synchronized IViaje creaViaje(Pedido pedido) throws VehiculosNoDisponiblesException, ChoferNoDisponibleException, PedidoInvalidoException, ZonaInvalidaException {
	
		IViaje viaje = empresa.creaViaje(pedido);
		this.viajesSolicitados.add(viaje);
		viaje.setEstado("Solicitado");
		notifyAll();
		setChanged();
		notifyObservers(viaje);
		return viaje;
	}

	

	public void pagarViaje(IViaje viaje) {
		
		while (viaje.getEstado().equals("Iniciado")) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		viaje.setEstado("Pagado");
		notifyAll();
		setChanged();
		notifyObservers(viaje);
		
	}

	public synchronized IViaje tomaViaje() {
		
		while ( viajesConVehiculo.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		IViaje viaje = viajesConVehiculo.get(0);
		viajesConVehiculo.remove(0);
		viaje.setEstado("Iniciado");
		viajesEnCurso.add(viaje);
		notifyAll();
		setChanged();
		notifyObservers(viaje);
		return viaje;
	}

	public synchronized void finalizaViaje(IViaje viaje) {
		
		while (!viaje.getEstado().equals("Pagado")) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		viaje.setEstado("Finalizado");
		setChanged();
		notifyObservers(viaje);
		viajesEnCurso.remove(viaje);
		viajesFinalizados.add(viaje);
		vehiculosNoDisp.remove(viaje.getVehiculo());
		vehiculosDisp.add(viaje.getVehiculo());
		
	}

	public void addObservers(Observer obj){
		this.observadores.add(obj);
	}
}
