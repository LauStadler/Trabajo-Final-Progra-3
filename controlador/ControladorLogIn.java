package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Cliente;
import models.ContrasenaIncorrectaException;
import models.OjoHumano;
import models.RecursoCompartido;
import models.UsuarioInexistenteException;
import models.UsuarioYaExistenteException;
import vista.IVistaLogIn;
import vista.VistaCliente;

public class ControladorLogIn implements ActionListener {

	private RecursoCompartido modelo;
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
			String usuario= vista.getUsuario();
			String contra= vista.getContrasena();

			if(usuario!=null && contra!=null){
				try{
					Cliente cliente = modelo.verificaUsuario(usuario, contra);
<<<<<<< Updated upstream
					//abre la vista de VistaCliente,
					VistaCliente vista=new VistaCliente();
					Controlador controlador = new Controlador( modelo , vista );
					vista.setActionListener(controlador);
					controlador.setCliente(cliente);
					vista.setVisible(true);
					this.vista.setVisible(false);
=======
					loggeado(cliente); //abre la vista de VistaCliente,
>>>>>>> Stashed changes
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
			String usuario= vista.getNuevoUsuario();
			String contra= vista.getNuevaContrasena();
			
			if(usuario!=null && contra!=null){
				try{
					Cliente cliente= modelo.nuevoCliente(usuario, contra);
<<<<<<< Updated upstream
					//abre la vista de VistaCliente,
					VistaCliente vista=new VistaCliente();
					Controlador controlador = new Controlador( modelo , vista );
					vista.setActionListener(controlador);
					controlador.setCliente(cliente);
					vista.setVisible(true);
					this.vista.setVisible(false);
=======
					loggeado(cliente); //abre la vista de VistaCliente,
>>>>>>> Stashed changes
				}
				catch (UsuarioYaExistenteException e){
					vista.ventanaAviso("El usuario ya existe! Pruebe otro don!");
				}
			}


        }
		
	}

	public void loggeado(Cliente cliente){
		
		modelo.setCantClientes(modelo.getCantClientes()+1);
		VistaCliente vistaCl=new VistaCliente();
		Controlador controlador = new Controlador( modelo , vistaCl );
		vistaCl.setActionListener(controlador);
		controlador.setCliente(cliente);
		vistaCl.setVisible(true);
		this.vista.setVisible(false);

		new OjoHumano(modelo, cliente, vistaCl);
		
	}

}
