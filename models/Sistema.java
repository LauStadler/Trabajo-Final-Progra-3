package models;

import java.util.ArrayList;

public class Sistema {
	private static Sistema instancia=null;
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();//add y remove
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();//add y remove
	private ArrayList<IViaje> viajes = new ArrayList<IViaje>();	//add 
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public ArrayList <IViaje> getViajes() {
		return viajes;
	}
	
	public ArrayList <Chofer> getChoferes() {
		return choferes;
	}
	
	public ArrayList <Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public ArrayList <Cliente> getClientes() {
		return clientes;
	}
	private Sistema(){
		super();
	}
    /**
     * Este metodo instancia una unica vez a la clase sistema
     * @return
     */
	public static Sistema getInstancia(){
		if (instancia==null)
		    instancia= new Sistema();
		return instancia;
	}
    /**
     * Este metodo cuenta los viajes de un chofer, se utiliza para el calculo del sueldo del chofer temporario.
     * *<b>pre:</b> El chofer ya viene validado.
     * *<b>post:</b> Se ha calculado la cantidad de viajes de un determinado socio.
     * @param chofer Es el chofer al que se le quiere calcular la cantidad de viajes que realizo.
     * @return
     */
	public int cantviajesChofer(Chofer chofer){
        int aux=0;
        assert chofer != null : "El chofer es null";
		for(int i=0;i<viajes.size();i++){
			if (chofer.equals(viajes.get(i).getChofer()))
			   aux++;
		}
		assert aux >= 0;
		return aux;
	}
	/**
	 * Calcula el sueldo del chofer contratado.
	 * <b>pre:</b> El chofer debe pertenecer a la lista de choferes.
	 * <b>post:</b> Devuelde el sueldo de un determinado chofer contratado.
	 * @param chofer chofer perteneciente a la lista de choferes.
	 * @return
	 */
	public double getSueldoChoferContratado(Chofer chofer) {
		int aux = 0;
		assert choferes.contains(chofer) : "El chofer no pertenece a la empresa";
		for(int i=0;i<viajes.size();i++){
			if (chofer.equals(viajes.get(i).getChofer()))
			   aux += viajes.get(i).getCosto();
		}
		assert aux >= 0;
		return aux;
	}
	/**
	 * Este metodo busca un vehicolo disponible de acuerdo a las condiciones del pedido.<br>
	 * *<b>pre:</b> El pedido tiene que estar validado.
	 * @param pedido Es el pedido que realiza un cliente.
	 * @return Devuelve un vehiculo disponible que cumple con el pedido.
	 * @throws VehiculosNoDisponiblesException si no hubiera vehiculos desponibles para realizar el pedido, se dispara una excepcion indicando que no se puede realizar el viaje por falta de vehiculos.
	 */
	public Vehiculo buscaVehiculoDisp(Pedido pedido) throws VehiculosNoDisponiblesException {
		Vehiculo vehiculo = null;
		Integer maxPrioridad = 0, aux = null;
		assert pedido != null : "Pedido null";
		for (Vehiculo i : vehiculos) {
			aux = i.getPrioridad(pedido);
		    if (aux != null && aux> maxPrioridad) {
				vehiculo = i;
				maxPrioridad = aux;
			}
		}
			
		if(vehiculo == null )
			throw new VehiculosNoDisponiblesException("No hay vehiculos disponibles, no se puede hacer el viaje");

		return vehiculo;
		
	}
	/**
	 * Este metodo busca un chofer disponible en la lista de choferes.<br>
	 * @return Devuelve el primer chofer dispnoble de la lista.
	 * @throws ChoferNoDisponibleException Si no hubiera un chofer disponoble en la lista, se dispara la excepcion indicando que el viaje no se puede relizar por la falta de un chofer.
	 */
	public Chofer buscaChoferDisp() throws ChoferNoDisponibleException {
		if (choferes.size() != 0)
			return choferes.get(0);
		else 
			throw new ChoferNoDisponibleException("No hay choferes disponibles");
	}
	
    /**
     * Este metodo crea un viaje.
     * @param pedido Pedido que realiza un cliente.
     * @return Retorna un viaje.
     * @throws PedidoInvalidoException Si el pedido fuera invalido, dispara la excepcion indicando el problema.
     * @throws ZonaInvalidaException 
     * @throws VehiculosNoDisponiblesException
     * @throws ChoferNoDisponibleException
     */
	public IViaje creaViaje(Pedido pedido) throws PedidoInvalidoException, ZonaInvalidaException, VehiculosNoDisponiblesException, ChoferNoDisponibleException{
		
		IViaje viaje = null;
		if(pedido.isPedidoValido()) {
			
			viaje = FactoryViaje.getIntancia().getViaje(pedido, null, null);
	
		}		
	   else
		  throw new PedidoInvalidoException("Pedido no valido, no se puede hacer el viaje");
	   
	   return viaje; 
	}
  
	public IViaje IniciaViaje(Pedido pedido) throws PedidoInvalidoException, ZonaInvalidaException, VehiculosNoDisponiblesException, ChoferNoDisponibleException {
		IViaje viaje = null;
		try {
			viaje = creaViaje(pedido);
			choferes.remove(viaje.getChofer());
			vehiculos.remove(viaje.getVehiculo());
			viajes.add(viaje);
			
		}
		
		finally {
		}
		
		return viaje;
	}
	/**
	 * Este metodo actualiza los puntajes de los choferes.
	 */
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
	/**
	 * Este metodo finaliza el viaje y agrega al vehiculo y al chofer que realizaron el mismo al final de sus respectivas listas.<br>
	 * <b>pre:</b>Viaje valido.
	 * <b>post:</b> Pone al final de cada lista al chofer y al vehiculo que realizaron el viaje.
	 * @param viaje Viaje finalizado.
	 */
	public void finalizaViaje(IViaje viaje) {
		assert viaje != null : "Viaje null";
		choferes.add(viaje.getChofer());
		vehiculos.add(viaje.getVehiculo());
	}
	
	
	/**
	 * Este metodo agrega un vehiculo a la lista.
	 * <b>pre:</b> El tipo tiene que ser valido y la patente distinto de nulo y espacio vacio.
	 * @param tipo Tipo del vehiculo a crear.
	 * @param patente Pateten del vehiculo a agregar.
	 */
	public void agregarVehiculo(String tipo,String patente) {
		assert patente.equals("") != true : "La patente es vacia";
        assert patente != null : "La patente es null";
        assert (tipo.equals("Zona Peligrosa") == true || tipo.equals("Zona Estandar") == true || tipo.equals("Zona Calle de Tierra") == true);
		Vehiculo aux = FactoryVehiculo.getInstancia().getVehiculo(tipo, patente);
		this.vehiculos.add(aux);
	}
	
	public void agregaChofer(Chofer aux) {
		this.choferes.add(aux);
		
	}
	
}