package prueba;

import java.util.ArrayList;


import java.util.GregorianCalendar;
import models.Chofer;
import models.ChoferPermanente;
import models.ChoferTemporario;
import models.Cliente;
import models.IViaje;
import models.Pedido;
import models.Sistema;
import models.Vehiculo;
import models.ChoferNoDisponibleException;
import models.PedidoInvalidoException;
import models.VehiculosNoDisponiblesException;
public class prueba {

	public static void main(String[] args) {
		
		Sistema s = Sistema.getInstancia();
		try {			
			Chofer c1 = new ChoferPermanente("2343254", "Juan", 3, 02, 3, 2017);
			Chofer c2 = new ChoferTemporario("423984", "Franco");
			s.agregaChofer(c1);
			s.agregaChofer(c2);
			
			s.agregarVehiculo("Moto", "op34p2");
			s.agregarVehiculo("Auto", "4odi432");
			
			Cliente lau = new Cliente("Laurita", "RuffoElMasLindo");
			
			Pedido p1 = new Pedido(4, "Zona Peligrosa", true, true, lau, 3);
			IViaje viaje1= s.IniciaViaje(p1);
			s.finalizaViaje(viaje1);
			
			ListadoViajes(s.getViajes());
			
			ListadoChoferes(s.getChoferes());
			
			ListadoVehiculos(s.getVehiculos());
			
			ListadoClientes(s.getClientes());
			
		}
		catch (Exception e){
			System.out.println(e.getLocalizedMessage());
			
		}
		finally {
			
		}
	}
	/**
  	 * Este metodo lista a los viajes de la lista.
  	 */
	public static void ListadoViajes(ArrayList<IViaje> viajes) throws CloneNotSupportedException{
		for (IViaje i : viajes)
			System.out.println(i.clone());
	}
	/**
  	 * Este metodo lista a los choferes de la lista.
  	 */
	public static void ListadoChoferes(ArrayList<Chofer> choferes) {
		for (Chofer i : choferes)
			System.out.println(i);
	}
	/**
	 * Este metodo lista a los vehiculos de la lista.
	 */
	public static void ListadoVehiculos(ArrayList<Vehiculo> vehiculos) {
		for(Vehiculo i : vehiculos)
			System.out.println(i);
	}
	/**
	 * Este metodo lista a los clientes de la lista.
	 */
	public static void ListadoClientes(ArrayList<Cliente> clientes) {
		for(Cliente i : clientes)
			System.out.println(i);
	}
	/**
	 * Este metodo hace un reporte de todos los salarios de los choferes que hay en la lista.
	 */
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
}


