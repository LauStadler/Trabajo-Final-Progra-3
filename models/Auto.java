package models;

public class Auto extends Vehiculo{ //AUTO loquiii
/**
 * Inicializa el objeto auto<br>
 * <b>pre:<b> patente debe ser distinto de null y no ser vacio.
 * @param patente Patente del auto
 */
    public Auto(String patente){
    	super(patente);
    	assert patente.equals("") != true : "La patente es vacia";
        assert patente != null : "La patente es null";
        this.baul = true;
        this.mascota = true;
        this.cantpasajeros = 4;//asd
        
    }

	@Override
	public String toString() {
		return "Auto patente: " + patente + ", baul: " + baul + ", mascota: " + mascota + ", cantpasajeros: "
				+ cantpasajeros;
	}

	@Override
	public boolean verificaBaul(Pedido pedido) {
		assert pedido != null : "El pedido es null";
		return true;
	}

	@Override
	public boolean verificaMascota(Pedido pedido) {
		assert pedido != null : "El pedido es null";
		return true;
	}

	@Override
	public int getIndice(Pedido pedido) {
		assert pedido != null : "El pedido es null";
		if(pedido.isBaul())   
        	return 40 * pedido.getCantPasajeros();
        else 
        	return 30*pedido.getCantPasajeros();
	}

    
    
}