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
public class Party {
    InventarioLuchadores invLuch;
    private Random rdm =new Random();
    ArrayList<Luchador> party;
   
    Party(InventarioLuchadores inv){
    invLuch = inv;
    party= new ArrayList<>();
    elejirParty();
    }
    
    private int numeroLuch(){
    int numero=rdm.nextInt(invLuch.getTamaño());
    return numero;
    }
    
    private void elejirParty(){
    if(invLuch.getTamaño()<6){
        party=invLuch.inventario;
    }else{
    
        for(int i=0;i<6;i++){
    
            int numero=numeroLuch();
                party.add(i,invLuch.inventario.get(numero));
    }}
    }
     
    public void mostrarInventario(){
        for(int i=0;i<party.size();i++){
            System.out.print("luchadores que pelearan " +(i+1)+" ");
            party.get(i).mostrar(); 
    
        
    }}
    
}
