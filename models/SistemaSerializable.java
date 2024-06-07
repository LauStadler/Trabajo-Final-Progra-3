package models;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaSerializable implements Serializable {
   private ArrayList<IViaje>viajes= new ArrayList<IViaje>();
   private ArrayList<Chofer>choferes= new ArrayList<Chofer>();
   private ArrayList<Cliente>clientes= new ArrayList<Cliente>();
   private ArrayList<Vehiculo>vehiculos= new ArrayList<Vehiculo>();
   
   public SistemaSerializable() {
	   super();
   }

public void setViajes(ArrayList<IViaje> viajes) {
	this.viajes = viajes;
}

public void setChoferes(ArrayList<Chofer> choferes) {
	this.choferes = choferes;
}

public void setClientes(ArrayList<Cliente> clientes) {
	this.clientes = clientes;
}

public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
	this.vehiculos = vehiculos;
}

public ArrayList<IViaje> getViajes() {
	return viajes;
}

public ArrayList<Chofer> getChoferes() {
	return choferes;
}

public ArrayList<Cliente> getClientes() {
	return clientes;
}

public ArrayList<Vehiculo> getVehiculos() {
	return vehiculos;
}
   
public void agregarChofer(Chofer chofer) {
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
   
}
