package models;

import java.util.GregorianCalendar;

public abstract class DecoratorBaul implements IViaje, Cloneable{

	protected IViaje encapsulado;

	public DecoratorBaul(IViaje encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	public IViaje getEncapsulado() {
		return encapsulado;
	}

	public double getCosto() {
		// TODO Auto-generated method stub
		return this.encapsulado.getCosto();
	}

	
	public int getPasajero() {
		// TODO Auto-generated method stub
		return this.encapsulado.getPasajero();
	}

	
	public double getDistancia() {
		// TODO Auto-generated method stub
		return this.encapsulado.getDistancia();
	}

	
	public Chofer getChofer() {
		// TODO Auto-generated method stub
		return this.encapsulado.getChofer();
	}

	
	public Vehiculo getVehiculo() {
		// TODO Auto-generated method stub
		return this.encapsulado.getVehiculo();
	}
	
	@Override
	public DecoradorSinBaul clone() throws CloneNotSupportedException {
		
		DecoradorSinBaul clon = null;
		
		try {
			clon = (DecoradorSinBaul) super.clone();
			clon.encapsulado = (IViaje) this.encapsulado.clone();
		} 
		finally {
			
		}
		return clon;
	}

	
	public GregorianCalendar getFecha() {
		// TODO Auto-generated method stub
		return this.encapsulado.getFecha();
	}
	
	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return this.encapsulado.getCliente();
	}

	@Override
	public String toString() {
		return this.encapsulado.toString();
	}
	
}
