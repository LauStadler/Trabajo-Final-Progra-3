package models;

public abstract class DecoratorMascota implements IViaje, Cloneable{
	protected IViaje encapsulado;

	public DecoratorMascota(IViaje encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	
}

