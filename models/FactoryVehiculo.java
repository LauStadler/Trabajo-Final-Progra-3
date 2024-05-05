package models;

public class FactoryVehiculo {
	
	private static FactoryVehiculo instancia = null;
	
	public FactoryVehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static FactoryVehiculo getInstancia() {
		
		if (instancia == null)
			instancia = new FactoryVehiculo();
		
		return instancia;
	}
    /**
     * Este metodo genera un vehiculo.
     * <b>pre:<b> patente debe ser distinto de null y no ser vacio.
     * @param tipo
     * @param patente
     * @return Retorna el tipo de vehiculo solicitado.
     */
    public Vehiculo getVehiculo(String tipo, String patente){
        
    	Vehiculo respuesta = null;
        
    	assert patente.equals("") != true : "La patente es vacia";
        assert patente != null : "La patente es null";
    	
        if (tipo.equals("Moto"))
            respuesta = new Moto(patente);
        else 
        	if(tipo.equals("Auto"))
        		respuesta = new Auto(patente);
			else 
				if (tipo.equals("Combi"))
				
					respuesta = new Combi(patente);
		return respuesta;
	}
    
}
