package models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pedido implements Cloneable, Serializable{
	
	private int cantPasajeros;
	private String zona;
	private boolean mascota;
	private boolean baul;
	private GregorianCalendar fecha;
	private Cliente cliente;
	private double km;
	
	public Pedido () {
		super();
	}
	
	/**
	 * Inicializa el objeto pedido<br>
	 * @param cantPasajeros
	 * @param zona
	 * @param mascota
	 * @param baul
	 * @param cliente
	 * @param km
	 */
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
	/**
	 * Informa si mi pedido es valido en funcion de mi atributo cantPasajeros
	 * @return boolean
	 */
	public boolean isPedidoValido() {
		
		return (this.cantPasajeros <= 10 && this.cantPasajeros > 0) && (this.km >0) ;
	}


	public Cliente getCliente() {
		return cliente;
	}
	
	
	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public void setMascota(boolean mascota) {
		this.mascota = mascota;
	}

	public void setBaul(boolean baul) {
		this.baul = baul;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setKm(double km) {
		this.km = km;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Pedido clonado = null;
		clonado = (Pedido)super.clone(); // relacion agregacion con cliente
		return clonado;
	}



	@Override
	public String toString() {
		return "Pedido [cantPasajeros=" + cantPasajeros + ", zona=" + zona + ", mascota=" + mascota + ", baul=" + baul
				+ ", fecha=" + fecha.get(Calendar.DATE)+(fecha.get(Calendar.MONTH)+1)+fecha.get(Calendar.YEAR) + ", cliente=" + cliente + ", km=" + km + "]";
	}
    
}
