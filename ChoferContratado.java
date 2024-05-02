package models;

public class ChoferContratado extends Chofer {

    
    public ChoferContratado(String nombre,String dni){
        super(dni,nombre);
    }

    @Override
    public double getSueldo(){
    	
        return  0;
    }

	@Override
	public String toString() {
		return "ChoferContratado: " + nombre + ", dni : " + dni;
	}

	


}


