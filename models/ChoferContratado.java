package models;
/**
 * Clase concreta chofer contratado que hereda atributos de chofer.
 */
public class ChoferContratado extends Chofer {

	private static double porcentajeSueldo = 0.3;
    /**
     * Inicializa los atributos.<br>
     * <b>pre:</b> El nombre y dni deber no nulos y distinos de espacio.
     * @param nombre Nombre del chofer
     * @param dni Dni del chofer
     * @param nombre2 
     */
    public ChoferContratado(String tipo,String nombre,String dni ){
        super(dni,nombre);
        assert dni.equals("") != true : "El dni esta vacio";
        assert dni != null : "El dni es null";
        this.setTipo(tipo);
    }
   /**
    * Este metodo calcula el sueldo neto del chofer contratado.<br>
    * @return evuelde el sueldo del chofer.
    */
    @Override
    public double getSueldo(){
    	
        return  Sistema.getInstancia().getSueldoChoferContratado(this) * porcentajeSueldo;
    }

	@Override
	public String toString() {
		return "ChoferContratado: " + nombre + ", dni : " + dni;
	}

	


}


