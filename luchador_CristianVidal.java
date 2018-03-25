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
public class luchadores {
    Random rdm = new Random(); 
    int hp;
    int atk;
    int def;
    int spd;
    String faccion;
    String nombre; 
    int estrellas;   
   
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
  
  public void setStats(){ //asigna cada uno de los stats del luchador     
  hp= aleatorio(basevida(),estrellas() ); 
  atk = aleatorio(baseatk(), estrellas());
  def = aleatorio(basedef(), estrellas());
  spd = aleatorio(basems(), estrellas());
  faccion = decidirFaccion(faccion());
  nombre = decidirNombres(names());
  }
  
  private int estrellas(){//define las estrellas de cada luchador 
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
  return estrellas;//devuelve el numero de estrellas para el calculo final
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
  
  public void mostrar(){ //resumen de los stats del peleador
  System.out.println("el nombre del guerrero es "+nombre+" la faccion es "+faccion);
  System.out.println("la vida es "+hp+" el ataque es "+atk+" al defensa es "+def+" la velocidad de movimiento es "+spd);
  }
  
  //public void auxiliar(){
  //Double d = rdm.nextDouble()*100;
  //System.out.println(""+d);
  //}
}  

