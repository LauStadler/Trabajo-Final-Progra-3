package models;

import java.io.Serializable;

/**
 * Clase abstracta de chofer.
 */
public abstract class Chofer implements Serializable {
   /**
	 * 
	 */
   protected String dni;
   protected String nombre;
   protected int puntaje;
   
   public Chofer() {
	   super();
   }
   /**
    * Iniciliza al obejto chofer.
    * <b>pre: </b> El dni y nombre deben ser distinto de null y espacio vacio.
    * @param dni Dni el chofer.
    * @param nombre Nombre del chofer.
    */
   public Chofer(String dni, String nombre) {
	   super();
	   assert dni.equals("") != true : "El dni esta vacio";
       assert dni != null : "El dni es null";
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
	   assert actualiza >= 0 : "Puntaje negativo"; 
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
   public void setDni(String dni) {
	  this.dni = dni;
   }
   public void setNombre(String nombre) {
	  this.nombre = nombre;
   }
   public void setPuntaje(int puntaje) {
	 this.puntaje = puntaje;
   }
   
   
}