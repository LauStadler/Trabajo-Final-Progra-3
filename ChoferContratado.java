package models;

public class ChoferContratado extends Chofer {

	private static double porcentajeSueldo = 0.3;
    
    public ChoferContratado(String nombre,String dni){
        super(dni,nombre);
    }

    @Override
    public double getSueldo(){
    	
        return  Sistema.getInstancia().getSueldoChoferContratado(this) * porcentajeSueldo;
    }

	@Override
	public String toString() {
		return "ChoferContratado: " + nombre + ", dni : " + dni;
	}

	


}


