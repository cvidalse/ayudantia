/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoayudante;

import java.util.ArrayList;

/**
 *
 * @author Ce
 */
public class Proyectoayudante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    ArrayList<Luchador> vin = new ArrayList<>();
      InventarioObjeto invObj=new InventarioObjeto();
      Monstruo m=new Monstruo();
      InventarioLuchadores invLuch =new InventarioLuchadores();
      
      invLuch.agregarLuchadores();
      invLuch.agregarLuchadores();
      invLuch.agregarLuchadores();
      invLuch.agregarLuchadores();
       invLuch.agregarLuchadores();
        invLuch.agregarLuchadores();
         invLuch.agregarLuchadores();
     invLuch.agregarLuchadores();
     invLuch.agregarLuchadores();
     invLuch.mostrarInventario();
     ;
      Party part = new Party(invLuch);
      part.mostrarInventario();
      JuegoDado jd=new JuegoDado();
      Combate pelea = new Combate(m,part,jd,invObj);
      //part.party.get(0).mostrarTodo();
      //m.mostrarCaract();
   }
    
}
