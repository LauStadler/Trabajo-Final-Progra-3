package models;

public class ViajeDTO {
	protected PedidoDTO pedidoDTO;
	protected VehiculoDTO vehiculoDTO;
	protected ChoferDTO choferDTO;
	protected double distancia;
	protected String estado;
	protected static double base= 1000;
	public ViajeDTO() {
		// TODO Auto-generated constructor stub
	}
	public PedidoDTO getPedidoDTO() {
		return pedidoDTO;
	}
	public void setPedidoDTO(PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
	}
	public VehiculoDTO getVehiculoDTO() {
		return vehiculoDTO;
	}
	public void setVehiculoDTO(VehiculoDTO vehiculoDTO) {
		this.vehiculoDTO = vehiculoDTO;
	}
	public ChoferDTO getChoferDTO() {
		return choferDTO;
	}
	public void setChoferDTO(ChoferDTO choferDTO) {
		this.choferDTO = choferDTO;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static double getBase() {
		return base;
	}
	public static void setBase(double base) {
		ViajeDTO.base = base;
	}
	
}
