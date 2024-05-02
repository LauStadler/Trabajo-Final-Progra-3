package models;

public class Moto extends Vehiculo{

    public Moto (String patente){
        super(patente);
        this.baul = false;
        this.mascota = false;
        this.cantpasajeros = 1;
    }
    
    @Override 
    public int getPrioridad(Pedido pedido){
        if((!pedido.isMascota())&&(!pedido.isMascota())&&(pedido.getCantPasajeros()==this.getCantPasajeros()))
          return 1000;
        else
          return 0;
    }
    
    @Override
	public String toString() {
		return "Auto patente: " + patente + ", baul: " + baul + ", mascota: " + mascota + ", cantpasajeros: "
				+ cantpasajeros;
	}
}
