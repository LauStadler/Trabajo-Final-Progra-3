package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ContrasenaIncorrectaException;
import models.Sistema;
import models.UsuarioInexistenteException;
import models.UsuarioYaExistenteException;
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
			String usuario= vista.getUsuario();
			String contra= vista.getContrasena();

			if(usuario!=null && contra!=null){
				try{
					modelo.verificaUsuario(usuario, contra);
					//abre la vista de VistaPedido!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				}
				catch (UsuarioInexistenteException e){
					vista.ventanaAviso("Usuario Inexistente! Registrese don!");
				}
				catch (ContrasenaIncorrectaException e){
					vista.ventanaAviso("Contrasena incorrecta! Pruebe de nuevo don!");
				}
			}
        }
        else if(evento.getActionCommand().equals("Registrarse")) {
        
			System.out.println("el pana quiere Registrarse");	
			String usuario= vista.getNuevoUsuario();
			String contra= vista.getNuevaContrasena();
			
			if(usuario!=null && contra!=null){
				try{
					modelo.nuevoCliente(usuario, contra);
					//abre la vista de VistaPedido!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				}
				catch (UsuarioYaExistenteException e){
					vista.ventanaAviso("El usuario ya existe! Pruebe otro don!");
				}
			}


        }
		
	}

}
