package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ContrasenaIncorrectaException;
import models.RecursoCompartido;
import models.UsuarioInexistenteException;
import models.UsuarioYaExistenteException;
import vista.IVistaLogIn;
import vista.VentanaLogIn;
import vista.VistaCliente;

public class ControladorLogIn implements ActionListener {

	private RecursoCompartido modelo; //seria el sistema no?? pq va a modificar la lista de clientes y eso :D
	private IVistaLogIn vista;
	
	public ControladorLogIn(RecursoCompartido modelo, IVistaLogIn vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}


	public RecursoCompartido getModelo() {
		return modelo;
	}

	public IVistaLogIn getVista() {
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
					//abre la vista de VistaCliente,
					VistaCliente vista=new VistaCliente();
					Controlador controlador = new Controlador( modelo , vista );
					vista.setActionListener(controlador);
					vista.setVisible(true);
					this.vista.setVisible(false);
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
					//abre la vista de VistaCliente,
					VistaCliente vista=new VistaCliente();
					Controlador controlador = new Controlador( modelo , vista );
					vista.setActionListener(controlador);
					vista.setVisible(true);
					this.vista.setVisible(false);
				}
				catch (UsuarioYaExistenteException e){
					vista.ventanaAviso("El usuario ya existe! Pruebe otro don!");
				}
			}


        }
		
	}

}
