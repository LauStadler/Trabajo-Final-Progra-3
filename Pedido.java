package models;

import java.util.GregorianCalendar;

public class Pedido implements Cloneable{
	
	private int cantPasajeros;
	private String zona;
	private boolean mascota;
	private boolean baul;
	private GregorianCalendar fecha;
	private Cliente cliente;
	private double km;
	
	public Pedido(int cantPasajeros, String zona, boolean mascota, boolean baul, Cliente cliente, double km) {
		super();
		this.cantPasajeros = cantPasajeros;
		this.zona = zona;
		this.mascota = mascota;
		this.baul = baul;
		this.fecha = new GregorianCalendar();
		this.cliente = cliente;
		this.km = km;
		}
	
	
	
	public double getKm() {
		return km;
	}

	public int getCantPasajeros() {
		return cantPasajeros;
	}
	public String getZona() {
		return zona;
	}
	public boolean isMascota() {
		return mascota;
	}
	public boolean isBaul() {
		return baul;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	public boolean isPedidoValido() {
		
		return this.cantPasajeros <= 10 && this.cantPasajeros > 0;
	}


	public Cliente getCliente() {
		return cliente;
	}

}
