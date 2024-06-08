package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ChoferNoDisponibleException;
import models.IViaje;
import models.Pedido;
import models.PedidoInvalidoException;
import models.RecursoCompartido;
import models.VehiculosNoDisponiblesException;
import models.ZonaInvalidaException;
import vista.VistaCliente;

public class Controlador implements ActionListener {

	private RecursoCompartido modelo;
	private VistaCliente vista;
	private IViaje viaje;
	
	public Controlador(RecursoCompartido modelo, VistaCliente vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}


	public RecursoCompartido getModelo() {
		return modelo;
	}

	public VistaCliente getVista() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean baul;
		boolean mascota;
		
		if (e.getActionCommand().equals("Aceptar")) {
			baul = vista.isBaul();
			mascota = vista.isMascota();
			double distancia = vista.getIngresaDistancia();
			int cantPasajeros = vista.getCantPasajeros();
			Pedido pedido = modelo.creaPedido();		
			if (modelo.validaPedido(pedido)) {		
				try {
					this.viaje = modelo.creaViaje(pedido);
				} catch (VehiculosNoDisponiblesException | ChoferNoDisponibleException | PedidoInvalidoException
						| ZonaInvalidaException e1) {
					e1.printStackTrace();
				}
			}
		}
		else
			if(e.getActionCommand().equals("Pagar"))
				modelo.pagarViaje(this.viaje);
		
	}

}
