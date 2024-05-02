package models;

public abstract class Chofer {
   protected String dni;
   protected String nombre;
   protected int puntaje;
   
   // tengo que agregar el atributo cant viajes para calcular el sueldo de chofer temporario???
   public Chofer(String dni, String nombre) {
	   super();
	   this.dni=dni;
	   this.nombre=nombre;
	   this.puntaje = 0;
   }
   
   public void actualizaPuntaj(int actualiza) {
	   this.puntaje += actualiza;
   }
   
   public String getDNI(){
      return this.dni;
   }

   public String getNombre(){
      return this.nombre;
   }

   public abstract double getSueldo();

}