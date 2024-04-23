package models;

import java.util.Date;

public class Pedido {
	
	private int cantPasajeros;
	private String zona;
	private boolean mascota;
	private boolean baul;
	private Date fecha;
	
	public Pedido(int cantPasajeros, String zona, boolean mascota, boolean baul, Date fecha) {
		super();
		this.cantPasajeros = cantPasajeros;
		this.zona = zona;
		this.mascota = mascota;
		this.baul = baul;
		this.fecha = fecha;
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
	public Date getFecha() {
		return fecha;
	}
	
	public boolean isPedidoValido() {
		
		return this.cantPasajeros <= 10 && this.cantPasajeros > 0;
	}

}
