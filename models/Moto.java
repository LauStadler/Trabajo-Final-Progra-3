package models;

public class Moto extends Vehiculo{
	/**
	 * Inicializa el objeto moto<br>
	 * <b>pre:<b> patente debe ser distinto de null y no ser vacio.
	 * @param patente Patente del auto
	 */
    public Moto (String patente){
        super(patente);
        assert patente.equals("") != true : "La patente es vacia";
        assert patente != null : "La patente es null";
        this.baul = false;
        this.mascota = false;
        this.cantpasajeros = 1;
    }
    
    
    @Override 
    public int getIndice(Pedido pedido) {
    	assert pedido != null : "El pedido es null";
    	return 1000;
    }
    
    @Override
	public String toString() {
		return "MotoS patente: " + patente + ", baul: " + baul + ", mascota: " + mascota + ", cantpasajeros: "
				+ cantpasajeros;
	}


	@Override
	public boolean verificaBaul(Pedido pedido) {
		assert pedido != null : "El pedido es null";
		if (pedido.isBaul() == false)
			return true;
		else
			return false;
	}


	@Override
	public boolean verificaMascota(Pedido pedido) {
		assert pedido != null : "El pedido es null";
		if (pedido.isMascota() == false)
			return true;
		else
			return false;
	}
}
