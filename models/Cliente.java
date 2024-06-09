package models;

import java.io.Serializable;
import java.util.Observable;

public class Cliente extends Observable implements Serializable {

	private String usuario;
	private String contrasenia;
	
    public Cliente() {
    	super();
    }
	
	public Cliente(String usuario, String contrasenia) {
		super();
		assert usuario.equals("") != true : "El usuario esta vacio";
	    assert usuario != null : "El usuario es null";
	    assert contrasenia.equals("") != true : "La contraseña esta vacia";
	    assert contrasenia != null : "La contraseña es null";   
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
