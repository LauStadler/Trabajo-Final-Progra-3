package models;

import java.util.ArrayList;

public class Sistema {
	private static Sistema instancia=null;
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();//add y remove
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();//add y remove
	private ArrayList<IViaje> viajes = new ArrayList<IViaje>();	//add 
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	private Sistema(){
		super();
	}

	public static Sistema getInstancia(){
		if (instancia==null)
		    instancia= new Sistema();
		return instancia;
	}

	public int cantviajesChofer(Chofer chofer){
        int aux=0;
		for(int i=0;i<viajes.size();i++){
			if (chofer.equals(viajes.get(i).getChofer()))
			   aux++;
		}
		return aux;
	}
	
	public Vehiculo buscaVehiculoDisp(Pedido pedido) throws VehiculosNoDisponiblesException {
		Vehiculo vehiculo = null;
		Integer maxPrioridad = null, aux = null;
		
		for (Vehiculo i : vehiculos) {
			aux = i.getPrioridad(pedido);
			if (aux != null && aux> maxPrioridad) {
				vehiculo = i;
				maxPrioridad = aux;
			}
		}
			
		if(vehiculo == null )
			throw new VehiculosNoDisponiblesException("No hay autos disponibles, no se puede hacer el viaje");

		return vehiculo;
		
	}
	
	public Chofer buscaChoferDisp() throws ChoferNoDisponibleException {
		if (choferes.size() != 0)
			return choferes.get(0);
		else 
			throw new ChoferNoDisponibleException("No hay choferes disponibles");
	}
	

	public IViaje creaViaje(Pedido pedido) throws PedidoInvalidoException, ZonaInvalidaException, VehiculosNoDisponiblesException, ChoferNoDisponibleException{
		
		Vehiculo vehiculo = null;
		Chofer chofer = null;

		if(pedido.isPedidoValido()) {
			vehiculo = this.buscaVehiculoDisp(pedido);
			chofer = this.buscaChoferDisp();	
		}		
	   else
		  // si isPedidoValido()==false tiro exception de viaje no posible
		  throw new PedidoInvalidoException("Pedido no valido, no se puede hacer el viaje");
	   
	   return FactoryViaje.getIntancia().getViaje(pedido, vehiculo, chofer);
	}
  
	public IViaje IniciaViaje(Pedido pedido) {
		IViaje viaje = null;
		try {
			viaje = creaViaje(pedido);
			choferes.remove(viaje.getChofer());
			vehiculos.remove(viaje.getVehiculo());
			viajes.add(viaje);
			
		}
		catch (PedidoInvalidoException e) {
			System.out.println(e.getLocalizedMessage());
		}
		catch(VehiculosNoDisponiblesException e){
			System.out.println(e.getLocalizedMessage());
			
		}
		catch (ChoferNoDisponibleException e) {
			System.out.println(e.getLocalizedMessage());
		}
		catch (ZonaInvalidaException e) {
			System.out.println(e.getLocalizedMessage());
		}
		finally {
		}
		
		return viaje;
	}
	
	public void actualizaPuntajesChoferes() {
		int act, kmsrecorrido, maxkm = 0;
		Chofer maxkmRecorridos = null;
		
		for (Chofer i : choferes) {
			act = 0;
			kmsrecorrido = 0;
			for(IViaje j : viajes) 
				if (j.getChofer() == i) {
					act += 5;
					kmsrecorrido += j.getDistancia();
				}
			i.actualizaPuntaj(act);
			if (kmsrecorrido > maxkm) {
				maxkm = kmsrecorrido;
				maxkmRecorridos = i;
			}
		}
		
		maxkmRecorridos.actualizaPuntaj(15);
		
	}
	
	public void finalizaViaje(IViaje viaje) {
		choferes.add(viaje.getChofer());
		vehiculos.add(viaje.getVehiculo());
	}
	
	public void listarViajes() {
		
	}
  	
	public void listarChoferes() {
		for (Chofer i : choferes)
			System.out.println(i);
	}
	
	public void listarVehiculos() {
		for(Vehiculo i : vehiculos)
			System.out.println(i);
	}
	
	public void listaClientes() {
		for(Cliente i : clientes)
			System.out.println(i);
		
	}
	
	public void reporteSalarios() {
		for (Chofer i : choferes)
			System.out.println(i.getSueldo());
	}
	
	public void agregarVehiculo(String tipo,String patente) {
		Vehiculo aux = FactoryVehiculo.getInstancia().getVehiculo();
		this.vehiculos.add(aux);
	}
	
}