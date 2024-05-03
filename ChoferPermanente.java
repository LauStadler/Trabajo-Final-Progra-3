package models;

import java.util.GregorianCalendar;

public class ChoferPermanente extends Chofer{
   private double sueldobase;
   private static double plusantiguedad = 0.1, plushijos = 0.05, aportes = 0.15;//cte??;
   private int antiguedad, canthijos;
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
   public ChoferPermanente(String dni,String nombre,int antiguedad,int canthijos, int dia, int mes, int anio){
     super(dni,nombre);
     this.antiguedad=antiguedad;
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
   
   /**
    * Este metodo retorna el sueldo bruto del chofer permanete.<br>
    * Al sueldo base se le agrega el plus por hijos y antiguedad.
    * @return Retorna el sueldo bruto del chofer contratado.
    */
   public double getSueldoBruto(){
      return this.sueldobase + this.canthijos * this.plushijos + this.sueldobase * this.antiguedad * this.plusantiguedad;
   }
   /**
    * Este metodo calcula el sueldo neto del chofer permanente.<br>
    * Al sueldo bruto se le resta el porcentaje de aportes.<br>
    * @return Devuelde el sueldo neto.
    */
   @Override
   public double getSueldo(){
      return this.getSueldoBruto() - this.getSueldoBruto()*this.aportes;
   }

@Override
public String toString() {
	return "ChoferPermanente: "+ nombre + ", dni: "+ dni+ "aportes: " + aportes + ", antiguedad: " + antiguedad + ", canthijos: " + canthijos
			+ ", fechaingreso: " + fechaingreso;
}


}

