package models;

public abstract class Chofer {
   private String dni;
   private String nombre;
   // tengo que agregar el atributo cant viajes para calcular el sueldo de chofer temporario???
   public Chofer(String dni,String nombre) {
	   super();
	   this.dni=dni;
	   this.nombre=nombre;
   }
   
   public String getDNI(){
      return this.dni;
   }

   public String getNombre(){
      return this.nombre;
   }

   public abstract double getSueldo();

}
