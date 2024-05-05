package models;

public class ViajeCalleTierra extends Viaje implements Cloneable {

	public ViajeCalleTierra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViajeCalleTierra(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
		super(pedido, vehiculo, chofer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCosto() {
		// TODO Auto-generated method stub
		return Viaje.getBase()*0.2*getPasajero() + Viaje.getBase()*0.15*this.distancia;
	}

	@Override
	public int getPasajero() {
		// TODO Auto-generated method stub
		return this.getPedido().getCantPasajeros();
	}

	@Override
	public ViajeCalleTierra clone() throws CloneNotSupportedException{
		
		ViajeCalleTierra clon = null;
		
		clon = (ViajeCalleTierra) super.clone();
		clon.pedido = (Pedido) this.pedido.clone();
		return clon;
	}


	
}
