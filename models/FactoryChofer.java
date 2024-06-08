package models;

public class FactoryChofer {
private static FactoryChofer instancia = null;
	
	public FactoryChofer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static FactoryChofer getInstancia() {
		
		if (instancia == null)
			instancia = new FactoryChofer();
		
		return instancia;
	}

    public Chofer getChofer(String tipo, String dni, String nombre){
        
    	Chofer respuesta = null;
        
    	assert tipo.equals("") != true : "El tipo esta vacio";
        assert tipo != null : "El tipo es null";
    	
        if (tipo.equals("Permanente"))
            respuesta = new ChoferPermanente(dni,nombre);
        else 
        	if(tipo.equals("Temporario"))
        		respuesta = new ChoferTemporario(dni,nombre);
			else 
				if (tipo.equals("Contratado"))
				
					respuesta = new ChoferContratado(dni,nombre);
		return respuesta;
	}
    
}


