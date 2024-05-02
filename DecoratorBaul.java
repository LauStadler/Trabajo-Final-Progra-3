package models;

public abstract class DecoratorBaul implements IViaje, Cloneable{

	protected IViaje encapsulado;

	public DecoratorBaul(IViaje encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	public IViaje getEncapsulado() {
		return encapsulado;
	}
	
	
}
