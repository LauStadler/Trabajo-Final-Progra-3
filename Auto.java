package mpdels;

public class Auto extends Vehiculo{

    public Auto(String patente){
        super(patente);
    }

    @Override
    public int getCantPasajeros(){
        return 4;
    }

    @Override
    public int getPrioridad(Pedido pedido){
        if((pedido.isBaul())&&(pedido.getCantPasajeros()<=this.getCantPasajeros()))
           return 40*pedido.getCantPasajeros();
        else if (pedido.getCantPasajeros()<=this.getCantPasajeros())
           return 30*pedido.getCantPasajeros;
        else return 0;
    }
}