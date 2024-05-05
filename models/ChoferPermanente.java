package models;

import java.util.GregorianCalendar;

public class ChoferPermanente extends Chofer{
   private static double sueldobase = 200000;
   private static double plusantiguedad = 0.03, plushijos = 0.05, aportes = 0.05;
   private int canthijos;
   private GregorianCalendar fechaingreso = new GregorianCalendar();
   /**
    * Inicializa los atributos del chofer permanente.<br>
    * <b>pre:</b> Los parametros enteros deben ser mayores o iguales a 0 y los tipo String deben ser distintos de null y espacio.
    * @param dni DNI del chofer.
    * @param nombre Nombre del chofer.
    * @param antiguedad Cantidad de años trabando en la empresa.
    * @param canthijos Cantidad de hijos.
    * @param dia Dia que empezo a trabajar.
    * @param mes Mes que empezo a trabajar.
    * @param anio Año que empezo a trabajar.
    */
   public ChoferPermanente(String dni,String nombre,int canthijos, int dia, int mes, int anio){
     super(dni,nombre);
     this.canthijos=canthijos;
     this.fechaingreso.set(anio, mes, dia);
   } 
   
   public double getPlusAntiguedad() {
	   return plusantiguedad;
	   
   }

   public double getPlusHijos() {
	   return plushijos;
   }
   
   public double getAportes() {
	   return aportes;
   }
   
   
   public static double getSueldobase() {
	return sueldobase;
}

	public static double getPlusantiguedad() {
		return plusantiguedad;
	}
	
	public static double getPlushijos() {
		return plushijos;
	}
	
	public int getCanthijos() {
		return canthijos;
	}
	
	public GregorianCalendar getFechaingreso() {
		return fechaingreso;
	}

/**
    * Este metodo retorna la antiguedad del chofer permanente.<br>
    * Al año actual se le resta el alño en el que ingreso.
    * @return Retorna años de antiguedad del chofer.
    */
   public int getAntiguedad() {
	   
	   GregorianCalendar hoy = new GregorianCalendar();
	   
	   return hoy.get(1) - this.fechaingreso.get(1);
   }
   
   /**
    * Este metodo retorna el sueldo bruto del chofer permanete.<br>
    * Al sueldo base se le agrega el plus por hijos y antiguedad.
    * @return Retorna el sueldo bruto del chofer contratado.
    */
   public double getSueldoBruto(){
      return ChoferPermanente.sueldobase + this.canthijos * ChoferPermanente.plushijos + ChoferPermanente.sueldobase * this.getAntiguedad() * ChoferPermanente.plusantiguedad;
   }
   /**
    * Este metodo calcula el sueldo neto del chofer permanente.<br>
    * Al sueldo bruto se le resta el porcentaje de aportes.<br>
    * @return Devuelde el sueldo neto.
    */
   @Override
   public double getSueldo(){
      return this.getSueldoBruto() - this.getSueldoBruto()* ChoferPermanente.aportes;
   }
   
	@Override
	public String toString() {
		return "ChoferPermanente: "+ nombre + ", dni: "+ dni+ "aportes: " + aportes +  ", canthijos: " + canthijos
				+ ", fechaingreso: " + fechaingreso;
	}


}

