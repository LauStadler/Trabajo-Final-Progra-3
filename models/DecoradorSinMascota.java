package models;

import java.util.GregorianCalendar;

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
	public DecoradorSinMascota clone() throws CloneNotSupportedException {
		
		DecoradorSinMascota clon = null;
		
		try {
			clon = (DecoradorSinMascota) super.clone();
			clon.encapsulado = (IViaje) this.encapsulado.clone();
		}
		finally {
			
		}
		
		return clon;
	}

	@Override
	public GregorianCalendar getFecha() {
		// TODO Auto-generated method stub
		return this.encapsulado.getFecha();
	}

	
}

