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

	public abstract boolean verificaBaul(Pedido pedido);
	
	public abstract boolean verificaMascota(Pedido pedido);
	
	public abstract int getIndice(Pedido pedido);
	
	public Integer getPrioridad(Pedido pedido) {
		boolean condicionMascota=this.verificaMascota(pedido);
		boolean condicionBaul=this.verificaBaul(pedido);
		boolean condicionCantPasajeros = this.getCantPasajeros() >= pedido.getCantPasajeros();
		
		if(condicionMascota && condicionBaul && condicionCantPasajeros)
			return this.getIndice(pedido);
		else
			return null;
		
	}

}