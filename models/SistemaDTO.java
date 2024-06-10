package models;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaDTO implements Serializable {
   private ArrayList<ViajeDTO>viajesDTO= new ArrayList<ViajeDTO>(); //PERSISTIMOS VIAJES??
   private ArrayList<ChoferDTO>choferes= new ArrayList<ChoferDTO>();
   private ArrayList<ClienteDTO>clientes= new ArrayList<ClienteDTO>();
   private ArrayList<VehiculoDTO>vehiculos= new ArrayList<VehiculoDTO>();
   
   public SistemaDTO() {
	   super();
   }

public void setViajesDTO(ArrayList<ViajeDTO> viajes) {
	this.viajesDTO = viajes;
}

public void setChoferesDTO(ArrayList<ChoferDTO> choferes) {
	this.choferes = choferes;
}

public void setClientesDTO(ArrayList<ClienteDTO> clientes) {
	this.clientes = clientes;
}

public void setVehiculosDTO(ArrayList<VehiculoDTO> vehiculos) {
	this.vehiculos = vehiculos;
}

public ArrayList<ViajeDTO> getViajesDTO() {
	return viajesDTO;
}

public ArrayList<ChoferDTO> getChoferesDTO() {
	return choferes;
}

public ArrayList<ClienteDTO> getClientesDTO() {
	return clientes;
}

public ArrayList<VehiculoDTO> getVehiculosDTO() {
	return vehiculos;
}
   
}
