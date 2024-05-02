package models;

public class Combi extends Vehiculo{

    public Combi(String patente){
        super(patente);
        this.baul = true;
        this.mascota = false;
        this.cantpasajeros = 10;
    }

    @Override
    public int getPrioridad(Pedido pedido){
        if((!pedido.isMascota()) && (pedido.getCantPasajeros() <= this.cantpasajeros))
           if(pedido.isBaul())
             return 10*pedido.getCantPasajeros() +100;
           else
              return 10*pedido.getCantPasajeros();
        else
          return 0;
    }

    @Override
	public String toString() {
		return "Auto patente: " + patente + ", baul: " + baul + ", mascota: " + mascota + ", cantpasajeros: "
				+ cantpasajeros;
	}
    
    
    
}