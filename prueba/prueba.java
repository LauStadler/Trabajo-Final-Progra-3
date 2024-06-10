package prueba;

import java.io.IOException;
import java.util.ArrayList;


import java.util.GregorianCalendar;

import controlador.Controlador;
import controlador.ControladorLogIn;
import models.Chofer;
import models.ChoferContratado;
import models.ChoferPermanente;
import models.ChoferTemporario;
import models.Cliente;
import models.IViaje;
import models.OjoChofer;
import models.OjoCliente;
import models.OjoSistema;
import models.Pedido;
import models.Sistema;
import models.UsuarioYaExistenteException;
import models.Vehiculo;
import models.ChoferNoDisponibleException;
import models.PedidoInvalidoException;
import models.RecursoCompartido;
import models.Simulacion;
import models.VehiculosNoDisponiblesException;
import vista.VentanaLogIn;
import vista.VentanaSimulacion;
import vista.VistaCliente;
public class prueba {

	public static void main(String[] args) {
		
		Sistema empresa = Sistema.getInstancia();
<<<<<<< Updated upstream
		Simulacion simulacion = new Simulacion();
		RecursoCompartido rc = new RecursoCompartido(empresa);
		VentanaLogIn vistaLogIn = new VentanaLogIn();
		ControladorLogIn controladorLogIn = new ControladorLogIn( rc, vistaLogIn );
		vistaLogIn.setControlador(controladorLogIn);
		vistaLogIn.setVisible(true);
		VistaCliente ventanaPedido = new VistaCliente();
		Controlador controlador  = new Controlador(rc, ventanaPedido);
		ventanaPedido.setActionListener(controlador);
		ventanaPedido.setVisible(true);
		VentanaSimulacion ventanaSimulacion = new VentanaSimulacion();
		ventanaSimulacion.setVisible(true);
=======
>>>>>>> Stashed changes
		
		try {
			empresa.lecturaArchivo();
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
			try {
				empresa.nuevoCliente("pepe", "lapa");
				Chofer c1 = new ChoferPermanente("Permanente","2343254", "Juan", 3, 02, 3, 2017);
				Chofer c2 = new ChoferTemporario("Temporario","423984", "Franco");
				Chofer c3 = new ChoferContratado("Contratado", "4234234", "Pablo");
				Chofer c5 = new ChoferPermanente("Permanente","3463453", "Egardo", 3, 02, 3, 2017);
				Chofer c7 = new ChoferTemporario("Temporario","354534", "Hernesto");
				Chofer c6 = new ChoferContratado("Contratado", "52354435", "Juan Carlos");
				empresa.agregaChofer(c1);
				empresa.agregaChofer(c2);
				
				empresa.agregarVehiculo("Moto", "MOT001");
				empresa.agregarVehiculo("Auto", "AUT001");

				empresa.nuevoCliente("lau","ruffo");
				empresa.nuevoCliente("marcus","1234");
				empresa.nuevoCliente("pili","1234");
				empresa.escrituraArchivo();

			} catch (UsuarioYaExistenteException e1) {
				e1.printStackTrace();			
			
			}
		}
		finally {
			
			RecursoCompartido rc = new RecursoCompartido(empresa);
			Simulacion simulacion = new Simulacion(rc);
			VentanaLogIn vistaLogIn = new VentanaLogIn();
			ControladorLogIn controladorLogIn = new ControladorLogIn( rc, vistaLogIn );
			vistaLogIn.setControlador(controladorLogIn);
			vistaLogIn.setVisible(true);
			VentanaSimulacion ventanaSimulacion = new VentanaSimulacion();
			ventanaSimulacion.setVisible(true);
			simulacion.start(ventanaSimulacion);
			while (!simulacion.isFinalizada()) {
				
			}
			empresa.escrituraArchivo();
				
		} 
		/*	
			try {
				ListadoViajes(empresa.getViajes());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
			ListadoChoferes(empresa.getChoferes());
			
			ListadoVehiculos(empresa.getVehiculos());
			
			ListadoClientes(empresa.getClientes());
		*/	
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


