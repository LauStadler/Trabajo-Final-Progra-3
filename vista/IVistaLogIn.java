package vista;

import java.awt.event.ActionListener;

import controlador.ControladorLogIn;

public interface IVistaLogIn { //La vista en la que se loguea/registra el usuario

	 public void setControlador(ControladorLogIn controlador);
	 public String getUsuario();
	 public String getContrasena();
	 public String getNuevoUsuario();
	 public String getNuevaContrasena();
}
