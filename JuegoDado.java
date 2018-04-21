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
public class JuegoDado {
   private Random rdm = new Random();
   private int valorResta;
    
 JuegoDado(){
 restaDados();
 }
   
 private int dadoOcho(){
    int valorOcho=rdm.nextInt(8)+1;
        return valorOcho;
    }
     private int dadoSeis(){
     int valorSeis=rdm.nextInt(6)+1;
     return valorSeis;
     }
     private void restaDados(){
     int valorResta=dadoOcho()-dadoSeis();
     }
     public int getValorResta(){
     return this.valorResta;
     }
    }
