package models;

public abstract class Viaje implements IViaje{
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
		return pedido;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Chofer getChofer() {
		return chofer;
	}


	public double getDistancia() {
		return distancia;
	}

	public static double getBase() {
		return base;
	}

	public static void setBase(double base) {
		Viaje.base = base;
	}
	
}
