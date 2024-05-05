package models;

public class Combi extends Vehiculo{
	
    public Combi(String patente){
        super(patente);
        this.baul = true;
        this.mascota = false;
        this.cantpasajeros = 10;
    }

 
    @Override
    public int getIndice(Pedido pedido){
    	assert pedido != null : "El pedido es null";
           if(pedido.isBaul())
             return 10*pedido.getCantPasajeros() +100;
           else
              return 10*pedido.getCantPasajeros();
    }

    @Override
	public String toString() {
		return "Combi patente: " + patente + ", baul: " + baul + ", mascota: " + mascota + ", cantpasajeros: "
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
		if (pedido.isMascota() == false)
			return true;
		else
			return false;
	}
    
    
    
}