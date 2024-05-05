package models;
/**
 * Clase abstracta de chofer.
 */
public abstract class Chofer {
   protected String dni;
   protected String nombre;
   protected int puntaje;
   
   /**
    * Iniciliza al obejto chofer.
    * <b>pre: </b> El dni y nombre deben ser distinto de null y espacio vacio.
    * @param dni Dni el chofer.
    * @param nombre Nombre del chofer.
    */
   public Chofer(String dni, String nombre) {
	   super();
	   this.dni=dni;
	   this.nombre=nombre;
	   this.puntaje = 0;
   }
   /**
    * Este metodo actualiza el puntaje del chofer.<br>
    * <b>pre:</b> El parametro actualiza debe ser mayor o igual 0.
    * <b>post:</b> Actualiza el puntaje del chofer.
    * @param actualiza Cantidad de puntos a actualizar.
    */
   public void actualizaPuntaj(int actualiza) {
	   this.puntaje += actualiza;
   }
   
   public String getDNI(){
      return this.dni;
   }

   public String getNombre(){
      return this.nombre;
   }
   /**
    * Metodo abstracto que calcula el sueldo del chofer.
    * @return sueldo del chofer
    */
   public abstract double getSueldo();

}