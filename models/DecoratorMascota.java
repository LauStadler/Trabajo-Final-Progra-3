package models;

import java.util.GregorianCalendar;

public abstract class DecoratorMascota implements IViaje, Cloneable{
	protected IViaje encapsulado;

	public DecoratorMascota(IViaje encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}
	
	public double getCosto() {
		// TODO Auto-generated method stub
		return this.encapsulado.getCosto();
	}

	
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return this.encapsulado.getCliente();
	}
	
	public String toString() {
		return this.encapsulado.toString();
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
	
	@Override
	public Vehiculo getVehiculo() {
		// TODO Auto-generated method stub
		return this.encapsulado.getVehiculo();
	}

	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		DecoradoConMascota clon = null;
		
		try {
			clon = (DecoradoConMascota) super.clone();
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
	
	@Override
	public Pedido getPedido() {
		// TODO Auto-generated method stub
		return this.encapsulado.getPedido();
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return this.encapsulado.getEstado();
	}

	@Override
	public void setEstado(String estado) {
		this.encapsulado.setEstado(estado);
		
	}

	@Override
	public void setVehiculo(Vehiculo vehiculo) {
		this.encapsulado.setVehiculo(vehiculo);
		
	}
	public void setChofer(Chofer chofer) {
		this.encapsulado.setChofer(chofer);
	}

}

