package models;

import java.util.GregorianCalendar;

public interface IViaje extends Cloneable {
	public double getCosto();
	public int getPasajero();
	public double getDistancia();
	public Cliente getCliente();
	public Chofer getChofer();
	public Vehiculo getVehiculo();
	public GregorianCalendar getFecha();
	public Object clone() throws CloneNotSupportedException;
}