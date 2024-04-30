package models;

public class ChoferContratado extends Chofer {
    private double ganancia;
    
    public ChoferContratado(String nombre,String dni){
        super(dni,nombre);
        this.ganancia=0;
    }

    @Override
    public double getSueldo(){
        return this.ganancia;
    }
}