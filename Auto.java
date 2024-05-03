package models;

public class Auto extends Vehiculo{ //AUTO loquiii

    public Auto(String patente){
        super(patente);
        this.baul = true;
        this.mascota = true;
        this.cantpasajeros = 4;
        
    }

	@Override
	public String toString() {
		return "Auto patente: " + patente + ", baul: " + baul + ", mascota: " + mascota + ", cantpasajeros: "
				+ cantpasajeros;
	}

	@Override
	public boolean verificaBaul(Pedido pedido) {
		return true;
	}

	@Override
	public boolean verificaMascota(Pedido pedido) {
		return true;
	}

	@Override
	public int getIndice(Pedido pedido) {
		if(pedido.isBaul())   
        	return 40 * pedido.getCantPasajeros();
        else 
        	return 30*pedido.getCantPasajeros();
	}

    
    
}