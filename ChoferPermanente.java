package models;

import java.util.GregorianCalendar;

public class ChoferPermanente extends Chofer{
   private double sueldobase;
   private static double plusantiguedad = 0.1, plushijos = 0.05, aportes = 0.15;//cte??;
   private int antiguedad, canthijos;
   private GregorianCalendar fechaingreso = new GregorianCalendar();

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
   public double getSueldoBruto(){
      return this.sueldobase + this.canthijos * this.plushijos + this.sueldobase * this.antiguedad * this.plusantiguedad;
   }

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

