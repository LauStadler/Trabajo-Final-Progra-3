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
	return viajes;
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
/**   
public void agregarChofer(Chofer chofer) { // hacen falta?
	this.choferes.add(chofer);
}

public void eliminarChofer(Chofer chofer) {
	this.choferes.remove(chofer);
}

public void agregarVehiculo(Vehiculo vehiculo) {
	this.vehiculos.add(vehiculo);
}
public void eliminarVehiculo(Vehiculo vehiculo) {
	this.vehiculos.remove(vehiculo);
}
public void agregarCliente(Cliente cliente) {
	this.clientes.add(cliente);
}
public void agregarViaje(IViaje viaje) {
	this.viajes.add(viaje);
}
**/   
}
