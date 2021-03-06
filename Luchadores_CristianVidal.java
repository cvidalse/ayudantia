/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoayudante;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ce
 */
public class Luchadores {
    Random rdm = new Random(); 
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private String faccion;
    private String nombre; 
    private int estrellas;   
   Luchadores(){
   setStats();
   }
   
   public int getHp(){
   return this.hp;
   }
   
   public int getDef(){
   return this.def;
   }
   
   public int getAtk(){
   return this.atk;
   }
   
   public int getSpd(){
   return this.spd;
   }
   
   public String getFaccion(){
   return this.faccion;
   }
   
   public int getRango(){
   return this.estrellas;
   }
   
   private int aleatorio(int base, int estrellas){//genera los stats definitivos con la base y las estrellas
   int stat = base*estrellas;
   return stat;
   }   
  
  private int basevida(){//base de vida
  int base = rdm.nextInt(300)+200; 
  return base;
}
  
  private int baseatk(){//ataque base
  int base = rdm.nextInt(50)+20;
  return base;
  }
  
  private int basedef(){//defensa base
  int base = rdm.nextInt(20)+5; 
   return base;
   }
  
  private int basems(){//velocidad de movimiento base
  int base = rdm.nextInt(90)+10;
        return base;
  }
  
  private void setStats(){ //asigna cada uno de los stats del luchador     
  hp= aleatorio(basevida(),estrellas); 
  atk = aleatorio(baseatk(), estrellas);
  def = aleatorio(basedef(), estrellas);
  spd = aleatorio(basems(), estrellas);
  faccion = decidirFaccion(faccion());
  nombre = decidirNombres(names());
  }
  
 private void estrellas(){//define las estrellas de cada luchador 
 Double control =rdm.nextDouble()*100;//genera un numero al azar entre 0 y 100 para generar las posibilidades
      if(40>control){
      estrellas=1;
      }else{
      if(70>control){
      estrellas=2;
      }else{
      if(85>control){
      estrellas=3;
      }else{
      if(95>control){
      estrellas=4;
      }else{
      estrellas=5;
      }
      }
      }
      }      
  
 }
  
  private String[] faccion(){//array de facciones
  String[] facciones= new String[3];
  facciones[0]= "fuego";
  facciones[1]= "agua";
  facciones[2]="tierra";
  return facciones;
  }
  
  private String decidirFaccion(String[] facciones){//asigna una faccion del array de facciones
  int director = rdm.nextInt(3);
  faccion= facciones[director];
  return faccion;
  }
  
  private ArrayList<String> names(){// arraylist de nombres
  ArrayList<String> nombres = new ArrayList<>();
  nombres.add("Dreck");
  nombres.add("dragonknight");
  nombres.add("dragonslayer");
  nombres.add("dragonborn");
  nombres.add("dragonslash");
  nombres.add("Naomi0001");
  nombres.add("dragonfists");
  nombres.add("dragon");
  nombres.add("dragonblood");
  nombres.add("dragonhunter");
  nombres.add("dragonwarrior");
  nombres.add("dragonlover");
  nombres.add("dragonStigma");
  nombres.add("dragonage");
  nombres.add("elderdragon");
  nombres.add("reddragon");
  return nombres;
  }
  private String decidirNombres(ArrayList<String> nombres){ //asigna un nombre del arrayList de nombres
  int director = rdm.nextInt(16);
  String nombreW = nombres.get(director);
  return nombreW;
  }
  
  public void mostrarTodo(){ //resumen de los stats del peleador
  System.out.println("el nombre del luchador es "+nombre+" la faccion es "+faccion);
  System.out.println("la vida es "+hp+" el ataque es "+atk+" al defensa es "+def+" la velocidad de movimiento es "+spd+" rango "+estrellas);
  }
  
  public void mostrar(){
  
      System.out.println("nombre---------------faccion-------------------rango");
      System.out.println("      "+nombre+"-------------"+faccion+"------------------------"+estrellas);
  
  }
  //public void auxiliar(){
  //Double d = rdm.nextDouble()*100;
  //System.out.println(""+d);
  //}
}  

