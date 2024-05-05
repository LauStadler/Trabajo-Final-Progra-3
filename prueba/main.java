
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class main {

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
			
			Pedido p1 = new Pedido(8, "ViajeZonaP", true, true, lau, 3);
			s.IniciaViaje(p1);
			
			
			ListadoViajes(s.getViajes());
			ListadoChoferes(s.getChoferes());
			ListadoVehiculos(s.getVehiculos());
			ListadoClientes(s.getClientes());
			//aca vamos a instanciar todo
		}
		catch (Exception e){
			System.out.println(e.getLocalizedMessage());
			
		}
		finally {
			
		}
	}
	public static void ListadoViajes(ArrayList<IViaje> viajes) throws CloneNotSupportedException{
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
}
