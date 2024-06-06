package models;

public class ClienteThread extends Thread {
	
	private RecursoCompartido rc;
	private int cantSolicitudes;
	private Cliente cliente;
	
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
		
		while (pedidosValidos < cantSolicitudes && rc.getCantChoferes() > 0) {
			pedido = rc.creaPedido();
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
}
