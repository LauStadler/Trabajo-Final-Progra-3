package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.RecursoCompartido;
import vista.VistaCliente;

public class Controlador implements ActionListener {

	private RecursoCompartido modelo;
	private VistaCliente vista;
	
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
	public void actionPerformed(ActionEvent evento) {
		int cantidadPasajeros = vista.getCantidadPasajeros();

		if(evento.getActionCommand().equals("Aceptar")) // el boton que ConfirmaPedido
		
	}

}
