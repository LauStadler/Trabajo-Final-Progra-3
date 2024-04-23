package models;

public class ViajeZonaEstandar extends Viaje{

	public ViajeZonaEstandar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViajeZonaEstandar(Pedido pedido, Vehiculo vehiculo, Chofer chofer, double distancia) {
		super(pedido, vehiculo, chofer, distancia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCosto() {
		// TODO Auto-generated method stub
		return Viaje.getBase()*0.1*getPasajero() + Viaje.getBase()*0.1*this.distancia;
	}

	@Override
	public int getPasajero() {
		// TODO Auto-generated method stub
		return this.getPedido().getCantPasajeros();
	}

	
	
}
