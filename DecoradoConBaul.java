package models;

import java.util.GregorianCalendar;

public class DecoradoConBaul extends DecoratorBaul{

	public DecoradoConBaul(IViaje encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCosto() {
		// TODO Auto-generated method stub
		return this.encapsulado.getCosto()+ + Viaje.getBase()*0.1*getPasajero()+ Viaje.getBase()*0.05*getDistancia();
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
	public DecoradoConBaul clone() {
		
		DecoradoConBaul clon = null;
		
		try {
			clon = (DecoradoConBaul) super.clone();
		} catch (CloneNotSupportedException e) {
		
		}
		try {
			clon.encapsulado = ((Viaje) this.encapsulado).clone();
		} catch (CloneNotSupportedException e) {
			
		}
		
		return clon;
	}

	@Override
	public GregorianCalendar getFecha() {
		return this.encapsulado.getFecha();
	}

}