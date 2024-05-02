package models;

public class DecoradoConMascota extends DecoratorMascota {

	public DecoradoConMascota(IViaje encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCosto() {
		// TODO Auto-generated method stub
		return this.encapsulado.getCosto() + Viaje.getBase()*0.1*getPasajero() + Viaje.getBase()*0.2*getDistancia();
	}

	@Override
	public int getPasajero() {
		// TODO Auto-generated method stub
		return this.encapsulado.getPasajero();
	}

	@Override
	public double getDistancia() {
		// TODO Auto-generated method stub
		return this.encapsulado.getDistancia();
	}

	@Override
	public Chofer getChofer() {
		// TODO Auto-generated method stub
		return this.encapsulado.getChofer();
	}
	
	@Override
	public Vehiculo getVehiculo() {
		// TODO Auto-generated method stub
		return this.encapsulado.getVehiculo();
	}

	
	@Override
	public DecoradoConMascota clone() throws CloneNotSupportedException{
		
		DecoradoConMascota clon = null;
		
		clon = (DecoradoConMascota) super.clone();
		clon.encapsulado = ((Viaje) this.encapsulado).clone();
		
		return clon;
	}
}
