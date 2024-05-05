package models;
/**
 * Clase concreta que se extendiente de la clase Chofer.<br>
 */
public class ChoferTemporario extends Chofer {
    private static double sueldobasico = 200000;
    private static double aportes = 0.05;
    private static double pluscantviajes = 0.15;
    
    
    public ChoferTemporario(String dni,String nombre){
        super(dni,nombre);
    }
    
    public static double getSueldobasico() {
		return sueldobasico;
	}

	public static double getAportes() {
		return aportes;
	}

	public static double getPluscantviajes() {
		return pluscantviajes;
	}

	/**
     * Este metodo calcula el sueldo bruto del chofer contratado.<br>
     * De acuerdo a la cantidad de viajes que realiza en el mes mas el sueldo base.<br>
     * @return Devuelde el sueldo del chofer.
     */
    public double getSueldoBruto(){
        return ChoferTemporario.sueldobasico + ChoferTemporario.sueldobasico * Sistema.getInstancia().cantviajesChofer(this) * ChoferTemporario.pluscantviajes;
    }
     /**
      * Este metodo calcula el sueldo neto del chofer temporario.<br>
      * Al sueldo bruto se le resta el porcentaje de aportes.<br>
      * @return Devuelde el sueldo neto del chofer.
      */
    @Override
    public double getSueldo(){
        return this.getSueldoBruto() - this.getSueldoBruto() * ChoferTemporario.aportes;
    }

	@Override
	public String toString() {
		return "Chofer Temporario: " + nombre +", dni: "+ dni + ", sueldobasico: " + sueldobasico + ", aportes: " + aportes + ", pluscantviajes: "
				+ pluscantviajes;
	}
    
    
}
