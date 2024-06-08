package models;

public class ConvertidorDTO {
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
	Chofer respuesta = new Chofer(choferDTO.getDni(), choferDTO.getNombre()); //FACTORY CHOFERES?
	respuesta.setDni(chofer.getDNI());
	respuesta.setNombre(chofer.getNombre());
	respuesta.setPuntaje(chofer.getPuntaje());
	return respuesta;
    }
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
	IViaje respuesta = FactoryViaje.getIntancia().getViaje(p, v, c);
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
