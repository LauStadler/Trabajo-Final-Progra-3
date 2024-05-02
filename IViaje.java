package models;

public interface IViaje {
	public double getCosto();
	public int getPasajero();
	public double getDistancia();
	public Chofer getChofer();
	public Vehiculo getVehiculo();
	public IViaje clone() throws CloneNotSupportedException;
}
