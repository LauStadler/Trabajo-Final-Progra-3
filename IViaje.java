package models;

public interface IViaje extends Cloneable {
	/**
	 * Implementa el calculo del costo de Viaje en base a los decorados
	 * @return costo del viaje
	 */
	public double getCosto();
	public int getPasajero();
	public double getDistancia();
	public Chofer getChofer();
	public Vehiculo getVehiculo();
	public GregorianCalendar getFecha();
}
