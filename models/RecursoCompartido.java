package models;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class RecursoCompartido extends Observable{

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
		
		for(int i=0; i<s.getChoferes().size(); i++)
			this.choferes.add(s.getChoferes().get(i));

		
		for(int i=0; i<s.getVehiculos().size(); i++)
			this.vehiculosDisp.add(s.getVehiculos().get(i));

		this.cantClientes = s.getClientes().size();
		this.cantChoferes = choferes.size();
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
	
	public IViaje algunCombo(){ //busca si hay algun vehiculo disponible que cumpla los requisitos de algun viaje solicitado
		Integer aux = null;
		Pedido pedido;
		for (IViaje v : viajesSolicitados){
			pedido= v.getPedido();
			for (Vehiculo i : vehiculosDisp) {
				aux = i.getPrioridad(pedido);
				if (aux != null)
					return v;
			}
		}
		return null;
	}

	public synchronized void asignaVehiculo()  {
		IViaje viaje;
		Vehiculo vehiculo;
		
		while( viajesSolicitados.isEmpty() || (viaje=algunCombo())==null && (this.cantChoferes > 0 && this.cantClientes > 0) ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}

		if (this.cantChoferes > 0 && this.cantClientes > 0) {
			viajesSolicitados.remove(viaje);		
			try {
				vehiculo = buscaVehiculoDisp(viaje.getPedido());
				vehiculosDisp.remove(vehiculo);
				viaje.setVehiculo(vehiculo);
				viaje.setEstado("Con Vehiculo");
				viajesConVehiculo.add(viaje);
				vehiculosNoDisp.add(vehiculo);
				setChanged();
				notifyObservers(viaje);
				notifyAll();	
			} catch (VehiculosNoDisponiblesException e) {
				e.printStackTrace();
			}
		}
		else {
			viaje.setEstado("Rechazado");
			setChanged();
			notifyObservers(viaje);
		}
		
		
	}
		
	

	public Pedido creaPedido(Cliente cliente){
		int cantPasajeros = (int) (Math.random() * 10) + 1;
		boolean baul;
		boolean mascota;
		String zona;
		double distancia =  (double) (Math.random() * 10.0) + 1;

		if ((int) (Math.random() * 1) == 1)
			baul = true;
		else
			baul = false; 

		if ((int) (Math.random() * 1) == 1)
			mascota = true;
		else
			mascota = false;	
		int opc= (int) (Math.random() * 3 ) + 1;
		if ( opc == 1)
			zona = "Zona Peligrosa";
		else if (opc==2)
			zona  = "Zona Estandar"; 	
		else
			zona = "Zona Calle de Tierra";
		return new Pedido(cantPasajeros, zona, baul, mascota, cliente, distancia);
	}
	
	public boolean validaPedido(Pedido pedido) {
		
		if(!pedido.isPedidoValido())
			return false;
		
<<<<<<< Updated upstream
		//if (this.cantChoferes <= 0)  no es necesario, lo chequea en creaViaje
		//	return false;
		
		int i= empresa.getVehiculos().size() - 1;
		while (i>0 && empresa.getVehiculos().get(i).getPrioridad(pedido)==null )
			i--;
		if ( empresa.getVehiculos().get(i).getPrioridad(pedido) != null )
			return true;
		else
=======
		if(empresa.buscaVehiculoDisp(pedido) == null)
>>>>>>> Stashed changes
			return false;
		return true;
	}
	
	public synchronized IViaje creaViaje(Pedido pedido) throws VehiculosNoDisponiblesException, ChoferNoDisponibleException, PedidoInvalidoException, ZonaInvalidaException {
	
		IViaje viaje = empresa.creaViaje(pedido);
		viaje.setEstado("Solicitado");
		this.viajesSolicitados.add(viaje);
		notifyAll();
		setChanged();
		notifyObservers(viaje);
		return viaje;
	}
	
	public synchronized void pagarViaje(IViaje viaje) {
		
		while ( this.getCantChoferes() > 0 && !viaje.getEstado().equals("Iniciado") ) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.getCantChoferes() > 0){
			viaje.setEstado("Pagado");
			notifyAll();
			setChanged();
			notifyObservers(viaje);
		}
		
		
	}

	public synchronized IViaje tomaViaje(Chofer chofer) {
		
		IViaje viaje = null;
		while ( viajesConVehiculo.isEmpty() &&  this.getCantClientes() > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (this.cantClientes >0 ){
			viaje = viajesConVehiculo.get(0);
			viaje.setChofer(chofer);
			viajesConVehiculo.remove(0);
			viaje.setEstado("Iniciado");
			viajesEnCurso.add(viaje);
			setChanged();
			notifyObservers(viaje);
			notifyAll();
		}
		return viaje;
	}

	public synchronized void finalizaViaje(IViaje viaje) {
		
		while (!viaje.getEstado().equals("Pagado") && this.getCantClientes() > 0) {
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

	public Cliente nuevoCliente(String usuario, String contra) throws UsuarioYaExistenteException {
<<<<<<< Updated upstream
		return empresa.nuevoCliente(usuario, contra);
=======
		Cliente cliente= empresa.nuevoCliente(usuario, contra);
		return cliente;
>>>>>>> Stashed changes
	}

    public Cliente verificaUsuario(String usuario, String contra) throws UsuarioInexistenteException, ContrasenaIncorrectaException {
        return empresa.verificaUsuario(usuario, contra);
    }

	public synchronized void finalizar() {
		notifyAll();
		
	}
}
