package models;

public abstract class Vehiculo {
	private String patente;
	private boolean baul,mascota;
	pivate int cantpasajeros;
    public Vehiculo (String patente,boolean mascota,boolean baul,int cantpasajeros){
		super();
		this.baul=baul;
		this.mascota=mascota;
		this.cantpasajeros=cantpasajeros;
		this.patente=patente;
	}
	public String getPatente(){
		return this.patente;
	}
	public abstract int getPrioridad();
}
