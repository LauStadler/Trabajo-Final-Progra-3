package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Sistema;
import vista.VentanaLogIn;

public class ControladorLogIn implements ActionListener {

	private Sistema modelo; //seria el sistema no?? pq va a modificar la lista de clientes y eso :D
	private VentanaLogIn vista;
	
	public ControladorLogIn(Sistema modelo, VentanaLogIn vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}


	public Sistema getModelo() {
		return modelo;
	}

	public VentanaLogIn getVista() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		if(evento.getActionCommand().equals("Iniciar Sesion")) {
            System.out.println("el pana quiere logearse");
            try{
                //intenta logear
            }
            catch (ContraseniaIncorrectaException e){
                //avisa a la vista que tiene que volver a intentar
            }
        }
        else if(evento.getActionCommand().equals("Registrarse")) {
            System.out.println("el pana quiere logearse");
        }
		
	}

}
