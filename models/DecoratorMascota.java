package models;

public abstract class DecoratorMascota implements IViaje, Cloneable{
	protected IViaje encapsulado;

	public DecoratorMascota(IViaje encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}
	@Override
    public Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }
	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return this.encapsulado.getCliente();
	}
	@Override
	public String toString() {
		return this.encapsulado.toString();
	}
	
}

