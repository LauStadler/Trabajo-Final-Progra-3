package models;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ClienteThread extends Thread {
	
	private RecursoCompartido rc;
	private int cantSolicitudes;
	private Cliente cliente;
	private ArrayList<Observer> observadores = new ArrayList<>();
	
	
	public ClienteThread(RecursoCompartido rc, int cantSolicitudes, Cliente cliente) {
		super();
		this.rc = rc;
		this.cantSolicitudes = cantSolicitudes;
		this.cliente = cliente;
	}
	
	public void run () {
		
		int pedidosValidos = 0; //cantidad de pedidos que hizo el cliente y que fueron validos
		IViaje viaje;
		Pedido pedido;
		
		while (pedidosValidos < this.cantSolicitudes && rc.getCantChoferes() > 0) {
			
			pedido = rc.creaPedido(this.cliente);
			if (rc.validaPedido(pedido)) {
				pedidosValidos ++;
				try {
					viaje = rc.creaViaje(pedido);
					rc.pagarViaje(viaje);
					
				} catch (VehiculosNoDisponiblesException | ChoferNoDisponibleException | PedidoInvalidoException
						| ZonaInvalidaException e) {
					e.printStackTrace();
				}
				
			}
		
		}
		rc.setCantClientes(rc.getCantClientes()-1);
	}
	
	
	
	public RecursoCompartido getRc() {
		return rc;
	}

	public int getCantSolicitudes() {
		return cantSolicitudes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public ArrayList<Observer> getObservadores() {
		return observadores;
	}

	public void addObservers(Observer obj) {
		observadores.add(obj);
	}
}

