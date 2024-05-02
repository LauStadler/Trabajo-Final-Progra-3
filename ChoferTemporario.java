package models;

public class ChoferTemporario extends Chofer {
    private double sueldobasico;
    private double aportes;//constante??;
    private static double pluscantviajes = 0.15;

    public ChoferTemporario(String dni,String nombre){
        super(dni,nombre);
    }

    public double getSueldoBruto(){
        return this.sueldobasico + this.sueldobasico*Sistema.getInstancia().cantviajesChofer(this) * this.pluscantviajes;
    }

    @Override
    public double getSueldo(){
        return this.getSueldoBruto()-this.getSueldoBruto()*this.aportes;
    }

	@Override
	public String toString() {
		return "Chofer Temporario: " + nombre +", dni: "+ dni + ", sueldobasico: " + sueldobasico + ", aportes: " + aportes + ", pluscantviajes: "
				+ pluscantviajes;
	}
    
    
}
