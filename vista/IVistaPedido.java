package vista;

import java.awt.event.ActionListener;

import controlador.Controlador;

public interface IVistaPedido { //La vista en la que se genera el pedido

	 public void setControlador(Controlador controlador);
	 public int getCantidadPasajeros();
	 public String getTexto();
	 public double getKm();
	 public boolean getBaul();
	 public boolean getMascota();
}
