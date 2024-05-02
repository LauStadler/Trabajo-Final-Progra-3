package models;

public class Auto extends Vehiculo{

    public Auto(String patente){
        super(patente);
        this.baul = true;
        this.mascota = true;
        this.cantpasajeros = 4;
        
    }


    @Override
    public int getPrioridad(Pedido pedido){
        
    	if((pedido.isBaul())&&(pedido.getCantPasajeros() <= this.getCantPasajeros()))
          
        	return 40*pedido.getCantPasajeros();
        
        else 
        	if (pedido.getCantPasajeros()<=this.getCantPasajeros())
        
        		return 30*pedido.getCantPasajeros();
       
        else 
        	return 0;
    }

	@Override
	public String toString() {
		return "Auto patente: " + patente + ", baul: " + baul + ", mascota: " + mascota + ", cantpasajeros: "
				+ cantpasajeros;
	}

    
    
}