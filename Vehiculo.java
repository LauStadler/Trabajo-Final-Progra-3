package models;

public abstract class Vehiculo {
	private String patente;
	private boolean baul=true,mascota=true;
	private int cantpasajeros=0;

    public Vehiculo (String patente){
		super();
		this.patente=patente;
	}
	
	public boolean getBaul(){
		return this.baul;
	}

	public boolean getMascota(){
		return this.mascota;
	}

	public int getCantPasajeros(){
		return this.cantpasajeros;
	}

	public String getPatente(){
		return this.patente;
	}

	public abstract int getPrioridad(Pedido pedido);
}
