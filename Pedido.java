package models;

import java.util.Date;

public class Pedido implements Cloneable{
	
	private int cantPasajeros;
	private String zona;
	private boolean mascota;
	private boolean baul;
	private Date fecha;
	private Cliente cliente;
	
	public Pedido(int cantPasajeros, String zona, boolean mascota, boolean baul, Date fecha, Cliente cliente) {
		super();
		this.cantPasajeros = cantPasajeros;
		this.zona = zona;
		this.mascota = mascota;
		this.baul = baul;
		this.fecha = fecha;
		this.cliente = cliente;
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


	public Cliente getCliente() {
		return cliente;
	}

}
