package models;

import java.util.GregorianCalendar;

public interface IViaje extends Cloneable {
	public Pedido getPedido();
	public double getCosto();
	public int getPasajero();
	public double getDistancia();
	public Cliente getCliente();
	public Chofer getChofer();
	public Vehiculo getVehiculo();
	public GregorianCalendar getFecha();
	public String getEstado();
	public void setEstado(String estado);
	public Object clone() throws CloneNotSupportedException;
	public void setVehiculo(Vehiculo vehiculo);
	public void setChofer(Chofer chofer);
}