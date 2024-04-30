package models;

import java.util.ArrayList;

public class Sistema {
	private static Sitema instancia=null;
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();//add y remove
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();//add y remove
	private ArrayList<IViaje> viajes = new ArrayList<IViaje>();	//add 
	
	private Sistema(){
		super();
	}

	public static Sistema getIntancia(){
		if (instancia==null)
		    instancia= new Sistema();
		return instancia;
	}

	public int cantviajesChofer(Chofer chofer){
        int aux=0;
		for(int i=0;i<viajes.size();i++){
			if (chofer.equals(viajes.get(i).getChofer())
			   aux++;
		}
		return aux;
	}

	public IViaje creaViaje(Pedido pedido) throws ViajeNoPosibleException {
		
		int maxPrioridad = 0;
		Vehiculo i, vehiculo = null;
		double km;
		Chofer chofer;
		// donde chequeo la zona??
		if(pedido.isPedidoValido()) {
			
			for ( Vehiculo i : vehiculos.size()) 
				if (i.getPrioridad(pedido) > maxPrioridad ) {
					maxPrioridad = i.getPrioridad();
					vehiculo = i;
				}
			if(vehiculo == null )
				throw new VehiculoNoDisponibleException("No hay autos disponibles, no se puede hacer el viaje");
			else {
				if (choferes.size() != 0) {
					chofer = choferes<0>;
					choferes.remove(chofer);
					return FactoryViaje.getIntancia().getViaje(pedido, vehiculo, chofer, km);
				}
				else
					throw new ChoferNoDisponibleException("No hay chpoferes disponibles, no se puede hacer el viaje");
			}
		}
	   else{
		  // si isPedidoValido()==false tiro exception de viaje no posible
		  throw new PedidoInvalidoException("Pedido no valido, no se puede hacer el viaje");
	   }
		
	}
  
  	
}
