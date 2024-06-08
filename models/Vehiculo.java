package models;

import java.io.Serializable;

public abstract class Vehiculo implements Serializable {
	protected String patente;
	protected boolean baul;
	protected boolean mascota;
	protected int cantpasajeros=0;
	protected String tipo;

	public Vehiculo() {
		super();
	}
	
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
	
    public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
     * Este metodo verifica el uso de Baul.<br>
     * <b> pre:</b> El pedido tiene ser distinto de null y validado.
     * @param pedido Pedido solicitado por un cliente
     * @return true/false
     */
	public abstract boolean verificaBaul(Pedido pedido);
	/**
     * Este metodo verifica el uso de Mascota.<br>
     * <b> pre:</b> El pedido tiene ser distinto de null y validado.
     * @param pedido Pedido solicitado por un cliente
     * @return true/false
     */
	public abstract boolean verificaMascota(Pedido pedido);
	 /**
	  * Calcula el Indice de prioridad del vehiculo.<br>
	  * <b>pre:</b> El pedido debe ser valido.
	  * @param pedido Pedidio solicitado por un cliente.
	  * @return Valor del indice mayor a 0.
	  */
	public abstract int getIndice(Pedido pedido);
	/**
     * Este metodo calcula el indice de prioridad del vehiculo.<br>
     * <b> pre:</b> El pedido tiene ser distinto de null y validado.
     * @param pedido Pedido solicitado por un cliente
     * @return Retorna un numero mayor o igual a 0 si el pedidio cumple con las condiones del vehiculo, null en caso contrario. 
     */
	public Integer getPrioridad(Pedido pedido) {
		
		assert pedido != null : "El pedido es null";
		boolean condicionMascota=this.verificaMascota(pedido);
		boolean condicionBaul=this.verificaBaul(pedido);
		boolean condicionCantPasajeros = this.getCantPasajeros() >= pedido.getCantPasajeros();
		
		if(condicionMascota && condicionBaul && condicionCantPasajeros)
			return this.getIndice(pedido);
		else
			return null;
		
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public void setBaul(boolean baul) {
		this.baul = baul;
	}

	public void setMascota(boolean mascota) {
		this.mascota = mascota;
	}

	public void setCantpasajeros(int cantpasajeros) {
		this.cantpasajeros = cantpasajeros;
	}

}