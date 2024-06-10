package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ChoferNoDisponibleException;
import models.Cliente;
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
	private Cliente cliente;
	
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

	public void setCliente(Cliente cliente) {
		this.cliente= cliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getActionCommand().equals("Aceptar")) {
<<<<<<< Updated upstream
			
			Pedido pedido = new Pedido(vista.getCantPasajeros(), vista.getZona(), vista.isMascota(), vista.isBaul(), this.cliente, vista.getIngresaDistancia());

			this.vista.appendText("Pedido creado");
			if (modelo.validaPedido(pedido)) {		
				try {
					this.vista.appendText("Pedido valido");
					this.viaje = modelo.creaViaje(pedido);
					//this.vista.appendText("Viaje solicitado"); se encarga el ojoHumano
					this.vista.habilitaPago();
				} catch (VehiculosNoDisponiblesException | ChoferNoDisponibleException | PedidoInvalidoException
						| ZonaInvalidaException e1) {
					e1.printStackTrace();
=======
			String zona= vista.getZona();
			Pedido pedido = new Pedido(vista.getCantPasajeros(), zona, vista.isMascota(), vista.isBaul(), this.cliente, vista.getIngresaDistancia());
			if (modelo.getCantChoferes() > 0 && modelo.getCantClientes() > 0) {
				this.vista.appendText("Pedido creado");
				if (!zona.equals("") && modelo.validaPedido(pedido)) {		
					try {
						this.vista.appendText("Pedido valido");
						this.vista.deshabilitaPedir();
						this.viaje = modelo.creaViaje(pedido);
					} catch (VehiculosNoDisponiblesException | ChoferNoDisponibleException | PedidoInvalidoException
							| ZonaInvalidaException e1) {
						e1.printStackTrace();
					}
>>>>>>> Stashed changes
				}
				else
					this.vista.appendText("Pedido invalido, intente de nuevo");
			}
			else {
				this.vista.finalizar();
				modelo.setCantClientes((modelo.getCantClientes()-1));
			}
		}
		else
			if(e.getActionCommand().equals("Pagar")){
				modelo.pagarViaje(this.viaje);
				vista.deshabilitarPago();
				vista.habilitaPedir();
			}
	}

}
