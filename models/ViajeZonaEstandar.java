package models;

public class ViajeZonaEstandar extends Viaje{

	public ViajeZonaEstandar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViajeZonaEstandar(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
		super(pedido, vehiculo, chofer);
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

	@Override
	public ViajeZonaEstandar clone() throws CloneNotSupportedException{
		
		ViajeZonaEstandar clon = null;
		
		clon = (ViajeZonaEstandar) super.clone();
		clon.pedido = (Pedido) this.pedido.clone();
		return clon;
	}
	
}
