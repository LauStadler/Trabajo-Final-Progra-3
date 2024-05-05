package models;
/**
 * Clase concreta que se extendiente de la clase Chofer.<br>
 */
public class ChoferTemporario extends Chofer {
    private double sueldobasico;
    private double aportes;
    private static double pluscantviajes = 0.15;
    
    /**
     * Inicializa las variables.<br>
     * <b>pre: 
     * @param dni
     * @param nombre
     */
    public ChoferTemporario(String dni,String nombre){
        super(dni,nombre);
    }
    /**
     * Este metodo calcula el sueldo bruto del chofer contratado.<br>
     * De acuerdo a la cantidad de viajes que realiza en el mes mas el sueldo base.<br>
     * @return Devuelde el sueldo del chofer.
     */
    public double getSueldoBruto(){
        return this.sueldobasico + this.sueldobasico * Sistema.getInstancia().cantviajesChofer(this) * this.pluscantviajes;
    }
     /**
      * Este metodo calcula el sueldo neto del chofer temporario.<br>
      * Al sueldo bruto se le resta el porcentaje de aportes.<br>
      * @return Devuelde el sueldo neto del chofer.
      */
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
