package vista;

import java.awt.event.ActionListener;

import controlador.Controlador;

public interface IVistaPedido { //La vista en la que se genera el pedido

	 public void setActionListener(Controlador c);
	 public double getIngresaDistancia();
	 public Integer getCantPasajeros();
	 public boolean isBaul();
	 public boolean isMascota();
}
