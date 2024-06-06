package models;

import java.util.ArrayList;

public class RecursoCompartido {

	private boolean available;
	private Sistema empresa;
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	private ArrayList<Vehiculo> vehiculosNoDisp = new ArrayList<Vehiculo>();//add y remove
	private ArrayList<Vehiculo> vehiculosDisp = new ArrayList<Vehiculo>();
	private ArrayList<IViaje> viajesSolicitados = new ArrayList<IViaje>();	
	private ArrayList<IViaje> viajesConVehiculo = new ArrayList<IViaje>();
	private ArrayList<IViaje> viajesFinalizado = new ArrayList<IViaje>();
	//private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int cantChoferes; //
	private int cantClientes;
	
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
	
	public synchronized void creaViaje(Pedido pedido) throws VehiculosNoDisponiblesException, ChoferNoDisponibleException, PedidoInvalidoException, ZonaInvalidaException {
		
		while (!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		available=false;
		//ddsdscdcd
		available=true;
		notifyAll();
		
		this.viajesSolicitados.add(empresa.creaViaje(pedido));
		
	}
}
