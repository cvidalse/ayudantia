/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoayudante;

import java.util.Random;

/**
 *
 * @author Ce
 */
public class ObjetoEquipable {
    private int rango;
    private int mejoraBase;
    private int mejoraFinal;
    Random rdm= new Random();
    
    ObjetoEquipable(){
        estrellas();
        mejoraBase();
        setMejoraFinal();
    }
    
    
    private int estrellas(){//define las estrellas de cada objeto 
    Double control =rdm.nextDouble()*100;//genera un numero al azar entre 0 y 100 para generar las posibilidades
      if(20>control){
      
          rango=1;
      }
      else{
      
          if(40>control){
             rango=2;
      }
          else{
      
              if(60>control){ 
                  rango=3;
      }
              else{
      
                  if(75>control){
                     rango=4;
      
                  }else{
      
                      if(85>control){    
                         rango=5;
      
                      }else{
      
                          if(90>control){
                              rango=6;
      }
                          else{
      
                              if(94>control){
                                 rango=7;
      }
                              else{
      
                                  if(97>control){
                                     rango=8;
      }
                                  else{
      
                                      if(99>control){
                                          rango=9;
      }
                                      else{
                                          rango=10;    
      }
      }
      }
      }
      }
      }
      }
      }}     
  return rango;//devuelve el numero de estrellas para el calculo final
 }
 
    private void mejoraBase(){
    mejoraBase=rdm.nextInt(8)+1;
    }

    /**
     *
     */
    private void setMejoraFinal(){
    mejoraFinal = mejoraBase*rango;
    }

    public int getMejoraFinal(){
    return this.mejoraFinal;
    }
    
    public void mostrarMejoraFinal(){
    
        System.out.println("la mejora final proporcionada por el item es "+this.mejoraFinal);
    }
    public void mostrarRango(){
    System.out.println("El rango del objeto es "+this.rango);
    }
    
 } 
