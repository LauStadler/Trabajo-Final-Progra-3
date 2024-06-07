package vista;

import java.awt.event.ActionListener;

import controlador.Controlador;

public interface IVistaLogIn { //La vista en la que se loguea/registra el usuario

	 public void setControlador(Controlador controlador);
	 public String getUser();
	 public String getContra();
	 public String getNuevoUser();
	 public String getNuevaContra();
}
