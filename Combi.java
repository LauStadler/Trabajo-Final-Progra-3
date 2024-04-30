package models;

public class Combi extends Vehiculo{

    public Combi(String patente){
        super(patente);
    }

    @Override
    public boolean getMacota(){
        return false;
    }

    @Override
    public int getCantPasajeros(){
        return 10;
    }

    @Override
    public int getPrioridad(Pedido pedido){
        if((!pedido.isMascota())&&(pedido.getCantPasajeros<=this.cantPasajeros()))
           if(pedido.isBaul)
             return 10*pedido.getCantPasajeros+100;
           else
              return 10*pedido.getCantPasajeros;
        else
          return 0;
    }
}