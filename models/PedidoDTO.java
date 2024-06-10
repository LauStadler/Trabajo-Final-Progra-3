package models;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class PedidoDTO implements Serializable{
	
	private int cantPasajeros;
	private String zona;
	private boolean mascota;
	private boolean baul;
	private GregorianCalendar fecha;
	private ClienteDTO clienteDTO;
	private double km;
	
	public PedidoDTO() {
		// TODO Auto-generated constructor stub
	}
	public int getCantPasajeros() {
		return cantPasajeros;
	}
	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public boolean isMascota() {
		return mascota;
	}
	public void setMascota(boolean mascota) {
		this.mascota = mascota;
	}
	public boolean isBaul() {
		return baul;
	}
	public void setBaul(boolean baul) {
		this.baul = baul;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	public ClienteDTO getCliente() {
		return clienteDTO;
	}
	public void setCliente(ClienteDTO cliente) {
		this.clienteDTO = cliente;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	
}
