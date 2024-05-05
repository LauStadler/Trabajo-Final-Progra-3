package models;

public class Cliente {

	private String usuario;
	private String contrasenia;
	
	/**
	 * Inicializa los atributos.<br>
	 * <b>pre:</b> Los parametos usuario y contrasenia deben ser distintos de nulo y espacio.
	 * @param usuario Usuario del cliente.
	 * @param contrasenia Contrasenia del cliente.
	 */
	public Cliente(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public String toString() {
		return "Cliente usuario: " + usuario + ", contrasenia: " + contrasenia;
	}
	
	
	
	
}
