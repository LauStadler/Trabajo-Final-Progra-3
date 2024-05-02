package models;

public class FactoryViaje {
	
	private static FactoryViaje instancia = null;
	
	public FactoryViaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static FactoryViaje getIntancia() {
		
		if (instancia == null)
			instancia = new FactoryViaje();
		
		return instancia;
	}

	public IViaje getViaje(Pedido pedido, Vehiculo vehiculo, Chofer chofer, double distancia) throws ZonaInvalidaException {
		IViaje encapsulado = null;
		IViaje encapsulado2 = null;
		IViaje rta = null;
		
		if (pedido.getZona().equals("Zona Peligrosa")) 
			encapsulado = new ViajeZonaP(pedido, vehiculo, chofer, distancia);
		else
			if (pedido.getZona().equals("Zona Estandar"))
				encapsulado = new ViajeZonaEstandar(pedido, vehiculo, chofer, distancia);
			else
				if (pedido.getZona().equals("Zona Calle de Tierra"))
					encapsulado = new ViajeCalleTierra(pedido, vehiculo, chofer, distancia);
				else
					throw new ZonaInvalidaException();
		
		if (encapsulado != null)
			if (pedido.isMascota())
				encapsulado2 = new DecoradoConMascota(encapsulado);
			else
				encapsulado2 = new DecoradorSinMascota(encapsulado);
			if (pedido.isBaul())
				rta = new DecoradoConBaul(encapsulado2);
			else
				rta = new DecoradorSinBaul(encapsulado2);
			
		return rta;
		
	}
	
}
