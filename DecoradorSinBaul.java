package models;

public class DecoradorSinBaul extends DecoratorBaul{
	

	public DecoradorSinBaul(IViaje encapsulado) {
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
	public DecoradorSinBaul clone() throws CloneNotSupportedException{
		
		DecoradorSinBaul clon = null;
		
		clon = (DecoradorSinBaul) super.clone();
		clon.encapsulado = ((Viaje) this.encapsulado).clone();		
		return clon;
	}
	
}
