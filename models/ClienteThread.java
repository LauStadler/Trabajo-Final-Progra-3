package models;

public class ClienteThread extends Cliente implements Runnable {
	
	private RecursoCompartido rc;
	private int cantSolicitudes;
	
	public ClienteThread(RecursoCompartido rc, int cantSolicitudes) {
		super();
		this.rc = rc;
		this.cantSolicitudes = cantSolicitudes;
	}
	
	public void run () {
		
		int pedidosValidos = 0; //cantidad de pedidos que hizo el cliente y que fueron validos
		IViaje viaje;
		Pedido pedido;
		
		while (pedidosValidos < cantSolicitudes && rc.getCantChoferes() > 0) {
			pedido = rc.creaPedido();
			notifyObservers("El cliente "+ this.getUsuario() +" creo un pedido");
			if (rc.validaPedido(pedido)) {
				notifyObservers("Se valido el pedido del cliente "+ this.getUsuario());
				pedidosValidos ++;
				try {
					viaje = rc.creaViaje(pedido);
					notifyObservers("Se se solicito un viaje del cliente "+ this.getUsuario());
					rc.pagarViaje(viaje);
					
				} catch (VehiculosNoDisponiblesException | ChoferNoDisponibleException | PedidoInvalidoException
						| ZonaInvalidaException e) {
					e.printStackTrace();
				}
				
			}
			else
				notifyObservers("Pedido invalido");
		
		}
		rc.setCantClientes(rc.getCantClientes()-1);
	}
}

