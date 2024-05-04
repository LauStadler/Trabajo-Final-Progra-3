package models;
import java.util.ArrayList;
import java.util.GregorianCalendar;
public class main {

	public static void main(String[] args) {
		Sistema s = Sistema.getInstancia();
		ListadoViajes(s.getViajes());
		ListadoChoferes(s.getChoferes());
		ListadoVehiculos(s.getVehiculos());
		ListadoClientes(s.getClientes());
	}
	public static void ListadoViajes(ArrayList<IViaje> viajes) {
		for (IViaje i : viajes)
			System.out.println(i.clone());
	}
	public static void ListadoChoferes(ArrayList<Chofer> choferes) {
		for (Chofer i : choferes)
			System.out.println(i);
	}
	public static void ListadoVehiculos(ArrayList<Vehiculo> vehiculos) {
		for(Vehiculo i : vehiculos)
			System.out.println(i);
	}
	public static void ListadoClientes(ArrayList<Cliente> clientes) {
		for(Cliente i : clientes)
			System.out.println(i);
	}
	public static void reporteSalarios(ArrayList<Chofer> choferes) {
		for (Chofer i : choferes)
			System.out.println(i.getSueldo());
	}	
	public void listarViajes_Chofer_Fechas(ArrayList<IViaje> viajes, Chofer chofer, GregorianCalendar fecha1, GregorianCalendar fecha2) {
		for (IViaje i : viajes)
			if ( ( i.getFecha().compareTo(fecha1) == 1 ) && ( i.getFecha().compareTo(fecha2) == -1 ) && ( i.getChofer().equals(chofer) ) )
				System.out.println(i);
	}
	public void listarViajes_Clientes_Fechas(ArrayList<IViaje> viajes, Cliente cliente, GregorianCalendar fecha1, GregorianCalendar fecha2) {
		for (IViaje i : viajes)
			if ( ( i.getFecha().compareTo(fecha1) == 1 ) && ( i.getFecha().compareTo(fecha2) == -1 ) && ( i.getCliente().equals(cliente) ) )
				System.out.println(i);
	}
