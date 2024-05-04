package models;
import java.util.ArrayList;
public class main {

	public static void main(String[] args) {
		Sistema s = new Sistema();
		ListadoViajes(s.getViajes());
		ListadoChoferes(s.getChoferes());
		ListadoVehiculos(s.getVehiculos());
		ListadoClientes(s.getClientes());
	}
	public void ListadoViajes(ArrayList<IViaje> viajes) {
		for (IViaje i : viajes)
			System.out.println(i.clone());
	}
	public void ListadoChoferes(ArrayList<Choferes> choferes) {
		for (Chofer i : choferes)
			System.out.println(i);
	}
	public void ListadoVehiculos(ArrayList<Vehiculos> vehiculos) {
		for(Vehiculo i : vehiculos)
			System.out.println(i);
	}
	public void ListadoClientes(ArrayList<Clientes> clientes) {
		for(Cliente i : clientes)
			System.out.println(i);
	}
	public void reporteSalarios(ArrayList<Choferes> choferes) {
		for (Chofer i : choferes)
			System.out.println(i.getSueldo());
	}	
	public void listarViajes_Chofer_Fechas(ArrayList<IViajes> viajes, Chofer chofer, GregorianCalendar fecha1, GregorianCalendar fecha2) {
		for (IViaje i : viajes)
			if ( (chofer.equals(i.getChofer())) && (i.getfecha().) && () )
		
}
