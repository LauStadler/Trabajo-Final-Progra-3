package models;

import java.util.ArrayList;

public class ConvertidorDTO {
	//DTO SISTEMA
	public static SistemaDTO sistemaDTOfromSistema(Sistema sistema)
	{
		SistemaDTO respuesta = new SistemaDTO();
		ArrayList<ChoferDTO> choferesDTO = new ArrayList<ChoferDTO>();
		ArrayList<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		ArrayList<ViajeDTO> viajesDTO = new ArrayList<ViajeDTO>();
		ArrayList<VehiculoDTO> vehiculosDTO = new ArrayList<VehiculoDTO>();
		for (int i = 0; i < sistema.getChoferes().size(); i++)
		    choferesDTO.add(ConvertidorDTO.choferDTOfromChofer(sistema.getChoferes().get(i)));
		for (int i = 0; i < sistema.getClientes().size(); i++)
		    clientesDTO.add(ConvertidorDTO.clienteDTOfromCliente(sistema.getClientes().get(i)));
		for (int i = 0; i < sistema.getViajes().size(); i++)
		    viajesDTO.add(ConvertidorDTO.viajeDTOfromViaje(sistema.getViajes().get(i)));
		for (int i = 0; i < sistema.getVehiculos().size(); i++)
		    vehiculosDTO.add(ConvertidorDTO.vehiculoDTOfromVehiculo(sistema.getVehiculos().get(i)));
		respuesta.setChoferesDTO(choferesDTO);
		respuesta.setClientesDTO(clientesDTO);
		respuesta.setVehiculosDTO(vehiculosDTO);
		respuesta.setViajesDTO(viajesDTO);
		return respuesta;
	}
	public static /*Sistema*/void sistemafromSistemaDTO(SistemaDTO sistema)
	{
		Sistema respuesta = Sistema.getInstancia();
		for (int i = 0; i < sistema.getClientesDTO().size(); i++)
		{
		    respuesta.agregaCliente(ConvertidorDTO.clientefromClienteDTO(sistema.getClientesDTO().get(i)));
		    System.out.println(ConvertidorDTO.clientefromClienteDTO(sistema.getClientesDTO().get(i)));
		}
		for (int i = 0; i < sistema.getChoferesDTO().size(); i++) {

			respuesta.agregaChofer(ConvertidorDTO.choferfromChoferDTO(sistema.getChoferesDTO().get(i)));
		}
		for (int i = 0; i < sistema.getVehiculosDTO().size(); i++) {
		    respuesta.agregaVehiculo(ConvertidorDTO.vehiculofromVehiculoDTO(sistema.getVehiculosDTO().get(i)));
		}

		for (int i = 0; i < sistema.getViajesDTO().size(); i++)
		    respuesta.agregaViaje(ConvertidorDTO.iviajefromViajeDTO(sistema.getViajesDTO().get(i)));

		//return respuesta;
	}
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
	respuesta.setTipo(chofer.getTipo());
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
	respuesta.setTipo(vehiculo.getTipo());
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
	respuesta.setVehiculoDTO(ConvertidorDTO.vehiculoDTOfromVehiculo(viaje.getVehiculo())); // COMO HAGO CON EL STATIC ??
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
	
}