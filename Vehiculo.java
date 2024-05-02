package models;

public abstract class Vehiculo {
	protected String patente;
	protected boolean baul;
	protected boolean mascota;
	protected int cantpasajeros=0;

    public Vehiculo (String patente){
		super();
		this.patente=patente;
	}
	
	public boolean isBaul(){
		return this.baul;
	}

	public boolean isMascota(){
		return this.mascota;
	}

	public int getCantPasajeros(){
		return this.cantpasajeros;
	}

	public String getPatente(){
		return this.patente;
	}

	public int getPrioridad(Pedido pedido) {
		
	}

}