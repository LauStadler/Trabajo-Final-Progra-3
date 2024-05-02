package models;

public class ViajeZonaP extends Viaje{

	public ViajeZonaP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViajeZonaP(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
		super(pedido, vehiculo, chofer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCosto() {
		// TODO Auto-generated method stub
		return Viaje.getBase()*0.1*getPasajero() + Viaje.getBase()*0.2*this.distancia;
	}

	@Override
	public int getPasajero() {
		// TODO Auto-generated method stub
		return this.getPedido().getCantPasajeros();
	}
	
	@Override
	public ViajeZonaP clone() throws CloneNotSupportedException{
		
		ViajeZonaP clon = null;
		
		clon = (ViajeZonaP) super.clone();
		return clon;
	}
	

}
