package models;

import java.util.GregorianCalendar;


public abstract class Viaje implements IViaje, Cloneable{
	protected Pedido pedido;
	protected Vehiculo vehiculo;
	protected Chofer chofer;
	protected double distancia;
	protected static double base= 1000;
	
	
	public Viaje() {
		super();
	}

	public Viaje(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
		super();
		this.pedido = pedido;
		this.vehiculo = vehiculo;
		this.chofer = chofer;
		this.distancia = pedido.getKm();
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public Chofer getChofer() {
		return this.chofer;
	}


	public double getDistancia() {
		return this.distancia;
	}

	public static double getBase() {
		return Viaje.base;
	}

	public static void setBase(double base) {
		Viaje.base = base;
	}
	public GregorianCalendar getFecha() {
		return this.pedido.getFecha();
	}
	/**
	 * Implementa clonacion para el listado de Viajes
	 */
	@Override
	public Viaje clone() throws CloneNotSupportedException {
		return (Viaje)super.clone();
	}
	
	@Override
	public String toString() {
		return "Viaje " + pedido + ", vehiculo=" + vehiculo + ", chofer=" + chofer + ", distancia=" + distancia
				+ ", " + "]";
	}
	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return this.pedido.getCliente();
	}
	
}