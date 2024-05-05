package models;

public class FactoryViaje {
	
	private static FactoryViaje instancia = null;
	
	public FactoryViaje() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * Instancia un FactoryViaje si no existia uno antes.
 * @return objeto de tipo FactoryViaje
 */
	public static FactoryViaje getIntancia() {
		
		if (instancia == null)
			instancia = new FactoryViaje();
		
		return instancia;
	}
/**
 * Genera un viaje de tipo IViaje utilizando el patron Decorator para "decorar" el calculo del
 * costo del viaje en funcion de la zona a la cual se dirige, si pide mascotas o no y si pide baul o no.
 * <b>pre:<b> El pedido no debe ser null.
 * <b>pre:<b> El Vehiculo no debe ser null.
 * <b>pre:<b> El Chofer no debe ser null.
 * @param pedido
 * @param vehiculo
 * @param chofer
 * @return viaje
 * @throws ZonaInvalidaException
 */
	public IViaje getViaje(Pedido pedido, Vehiculo vehiculo, Chofer chofer) throws ZonaInvalidaException {
		IViaje encapsulado = null;
		IViaje encapsulado2 = null;
		IViaje rta = null;
		if (pedido.getZona().equals("Zona Peligrosa")) 
			encapsulado = new ViajeZonaP(pedido, vehiculo, chofer);
		else
			if (pedido.getZona().equals("Zona Estandar"))
				encapsulado = new ViajeZonaEstandar(pedido, vehiculo, chofer);
			else
				if (pedido.getZona().equals("Zona Calle de Tierra"))
					encapsulado = new ViajeCalleTierra(pedido, vehiculo, chofer);
				else
					throw new ZonaInvalidaException("Zona Incorrecta");
		
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
