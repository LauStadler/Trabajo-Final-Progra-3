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
       
           if(pedido.isBaul())
             return 10*pedido.getCantPasajeros() +100;
           else
              return 10*pedido.getCantPasajeros();
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
		
		if (pedido.isMascota() == false)
			return true;
		else
			return false;
	}
    
    
    
}