package models;

import java.util.GregorianCalendar;

public abstract class Viaje implements IViaje, Cloneable{
	protected Pedido pedido;
	protected Vehiculo vehiculo;
	protected Chofer chofer;
	protected double distancia;
	protected GregorianCalendar fecha = new GregorianCalendar();
	protected static double base= 1000;
	
	
	public Viaje() {
		super();
	}
/**
 * Inicializa el objeto Viaje<br>
 * @param pedido
 * @param vehiculo
 * @param chofer
 */
	public Viaje(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
		super();
		this.pedido = pedido;
		this.vehiculo = vehiculo;
		this.chofer = chofer;
		this.distancia = pedido.getKm();
		this.fecha = pedido.getFecha();
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
	/**
	 * Implementa clonacion para el listado de Viajes
	 */
	@Override
	public Viaje clone() throws CloneNotSupportedException {
		return (Viaje)super.clone();
	}
	
}