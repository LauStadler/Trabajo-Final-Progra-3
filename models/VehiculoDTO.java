package models;

import java.io.Serializable;

public class VehiculoDTO implements Serializable{
	protected String patente;
	protected boolean baul;
	protected boolean mascota;
	protected int cantpasajeros=0;
	protected String tipo;
	public VehiculoDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public boolean isBaul() {
		return baul;
	}
	public void setBaul(boolean baul) {
		this.baul = baul;
	}
	public boolean isMascota() {
		return mascota;
	}
	public void setMascota(boolean mascota) {
		this.mascota = mascota;
	}
	public int getCantpasajeros() {
		return cantpasajeros;
	}
	public void setCantpasajeros(int cantpasajeros) {
		this.cantpasajeros = cantpasajeros;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
