package models;

public abstract class Viaje implements IViaje, Cloneable{
	protected Pedido pedido;
	protected Vehiculo vehiculo;
	protected Chofer chofer;
	protected double distancia;
	private static double base= 1000;
	
	public Viaje() {
		super();
	}

	public Viaje(Pedido pedido, Vehiculo vehiculo, Chofer chofer, double distancia) {
		super();
		this.pedido = pedido;
		this.vehiculo = vehiculo;
		this.chofer = chofer;
		this.distancia = distancia;
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
	
}