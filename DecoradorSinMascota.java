package models;

public class DecoradorSinMascota extends DecoratorMascota{

	public DecoradorSinMascota(IViaje encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCosto() {
		// TODO Auto-generated method stub
		return this.encapsulado.getCosto();
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
	public DecoradorSinMascota clone() throws CloneNotSupportedException{
		
		DecoradorSinMascota clon = null;
		
		clon = (DecoradorSinMascota) super.clone();
		clon.encapsulado = ((Viaje) this.encapsulado).clone();
		
		return clon;
	}
}

