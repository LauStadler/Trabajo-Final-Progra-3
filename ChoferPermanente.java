package models;
public class ChoferPermanente extends Chofer{
   private double sueldobase;
   private double plusantiguedad, plushijos,aportes;
   private int antiguedad, canthijos;
   private String fechaingreso;

   public ChoferPermanente(String dni,String nombre,int antiguedad,int canthijos){
     super(dni,nombre);
     this.antiguedad=antiguedad;
     this.canthijos=canthijos;
   } 

   public double getSueldoBruto(){
      return this.sueldobase+this.sueldobasethis.canthijos*this.plushijos+this.sueldobase*this.antiguedad*this.plusantiguedad;
   }

   @Override
   public double getSueldo(){
      return this.getSueldoBruto-this.getSueldoBruto()*this.aportes;
   }
}