package models;

public class Moto extends Vehiculo{

    public Moto (String patente){
        super(patente);
    }

    @Override
    public boolean getBaul(){
        return false;
    }

    @Override 
    public boolean getMascota(){
        return false;
    }

    @Override
    public int getCantPasajeros(){
        return 1;
    }
    
    @Override 
    public int getPrioridad(Pedido pedido){
        if((!pedido.isMascota())&&(!pedido.isMascota())&&(pedido.getCantPasajeros()==this.getCantPasajeros()))
          return 1000;
        else
          return 0;
    }
}