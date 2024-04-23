package models;

import java.util.ArrayList;

public class Sistema {
	
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private ArrayList<Viaje> viajes = new ArrayList<Viaje>();	
	
	
	public IViaje creaViaje(Pedido pedido) {
		
		int maxPrioridad = 0;
		Vehiculo i, vehiculo = null;
		double km;
		Chofer chofer;
		
		if(pedido.isPedidoValido()) {
			
			for ( Vehiculo i : vehiculos.size()) 
				if (i.getPrioridad() > maxPrioridad ) {
					maxPrioridad = i.getPrioridad();
					vehiculo = i;
				}
			if(vehiculo == null )
				throw new VehiculosNoDisponibles;
			else {
				if (choferes.size() != 0) {
					chofer = choferes<0>;
					choferes.remove(chofer);
					return FactoryViaje.getIntancia().getViaje(pedido, vehiculo, chofer, km);
				}
				else
					throw new ChoferesNodDisponibles();
			}
		}
	}
	
}
