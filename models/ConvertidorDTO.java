package models;

public class ConvertidorDTO {
	//DTO CLIENTES
	public static ClienteDTO clienteDTOfromCliente(Cliente cliente)
	{
	ClienteDTO respuesta = new ClienteDTO();
	respuesta.setContrasenia(cliente.getContrasenia());
	respuesta.setUsuario(cliente.getUsuario());
	return respuesta;
	}
	public static Cliente clientefromClienteDTO(ClienteDTO cliente)
	{
	Cliente respuesta = new Cliente(cliente.getUsuario(),cliente.getContrasenia());
	return respuesta;
	}
	//DTO CHOFERES
	public static ChoferDTO choferDTOfromChofer(Chofer chofer)
    {
	ChoferDTO respuesta = new ChoferDTO();
	respuesta.setDni(chofer.getDNI());
	respuesta.setNombre(chofer.getNombre());
	respuesta.setPuntaje(chofer.getPuntaje());
	return respuesta;
    }
	public static Chofer choferfromChoferDTO(ChoferDTO choferDTO)
    {
	Chofer respuesta = FactoryChofer.getInstancia().getChofer(choferDTO.getTipo(),choferDTO.getDni(), choferDTO.getNombre()); //FACTORY CHOFERES?
	respuesta.setDni(choferDTO.getDni());
	respuesta.setNombre(choferDTO.getNombre());
	respuesta.setPuntaje(choferDTO.getPuntaje());
	return respuesta;
    }
	//DTO VEHICULO
	public static VehiculoDTO vehiculoDTOfromVehiculo(Vehiculo vehiculo)
    {
	VehiculoDTO respuesta = new VehiculoDTO();
	respuesta.setBaul(vehiculo.isBaul());
	respuesta.setCantpasajeros(vehiculo.getCantPasajeros());
	respuesta.setMascota(vehiculo.isMascota());
	respuesta.setPatente(vehiculo.getPatente());
	return respuesta;
    }
	public static Vehiculo vehiculofromVehiculoDTO(VehiculoDTO vehiculo)
    {
	Vehiculo respuesta = FactoryVehiculo.getInstancia().getVehiculo(vehiculo.getTipo(), vehiculo.getPatente());
	return respuesta;
    }
	//DTO PEDIDOS
	public static PedidoDTO pedidoDTOfromPedido(Pedido pedido)
	{
	PedidoDTO respuesta = new PedidoDTO();
	respuesta.setBaul(pedido.isBaul());
	respuesta.setCantPasajeros(pedido.getCantPasajeros());
	respuesta.setCliente(ConvertidorDTO.clienteDTOfromCliente(pedido.getCliente()));
	respuesta.setFecha(pedido.getFecha());
	respuesta.setKm(pedido.getKm());
	respuesta.setMascota(pedido.isMascota());
	respuesta.setZona(pedido.getZona());
	return respuesta;
	}
	public static Pedido pedidofromPedidoDTO(PedidoDTO pedido)
	{
	Pedido respuesta = new Pedido(pedido.getCantPasajeros(), pedido.getZona() ,pedido.isMascota(),  pedido.isBaul(),ConvertidorDTO.clientefromClienteDTO(pedido.getCliente()),pedido.getKm());
	return respuesta;
	}
	//DTO VIAJES
	public static ViajeDTO viajeDTOfromViaje(IViaje viaje )
    {
	ViajeDTO respuesta = new ViajeDTO();
	respuesta.setChoferDTO(ConvertidorDTO.choferDTOfromChofer(viaje.getChofer()));
	respuesta.setDistancia(viaje.getDistancia());
	respuesta.setEstado(viaje.getEstado());
	respuesta.setPedidoDTO(ConvertidorDTO.pedidoDTOfromPedido(viaje.getPedido()));
	respuesta.setVehiculoDTO(ConvertidorDTO.vehiculoDTOfromVehiculo(viaje.getVehiculo()));
	respuesta.setBase(viaje.getBase()); // COMO HAGO CON EL STATIC ??
	return respuesta;
    }
	public static IViaje iviajefromViajeDTO(ViajeDTO viaje)
    {
	Pedido p = ConvertidorDTO.pedidofromPedidoDTO(viaje.getPedidoDTO());
	Vehiculo v = ConvertidorDTO.vehiculofromVehiculoDTO(viaje.getVehiculoDTO());
	Chofer c = ConvertidorDTO.choferfromChoferDTO(viaje.getChoferDTO());
	IViaje respuesta = null;
	try {
		respuesta = FactoryViaje.getIntancia().getViaje(p, v, c);
	} catch (ZonaInvalidaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return respuesta;
    }
	public static ViajeDTO viajeDTOfromIViaje(IViaje viaje)
	{
	ViajeDTO respuesta = new ViajeDTO();
	PedidoDTO p = ConvertidorDTO.pedidoDTOfromPedido(viaje.getPedido());
	VehiculoDTO v = ConvertidorDTO.vehiculoDTOfromVehiculo(viaje.getVehiculo());
	ChoferDTO c = ConvertidorDTO.choferDTOfromChofer(viaje.getChofer());
	return respuesta;
	}
	
}
