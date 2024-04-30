package models;

public class ChoferTemporario extends Chofer {
    private double sueldobasico;
    private double aportes;
    private double pluscantviajes;

    public ChoferTemporario(String dni,String nombre){
        super(dni,nombre);
    }

    public double getSueldoBruto(){
        // nose como calculo la cantidad de viajes ...
        return this.sueldobasico+this.sueldobasico*canviajes*this.pluscantviajes;
    }

    @Override
    public double getSueldo(){
        return this.getSueldoBruto-this.getSueldoBruto()*this.aportes;
    }
}