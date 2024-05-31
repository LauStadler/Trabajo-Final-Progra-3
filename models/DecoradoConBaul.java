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

	
}