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
public class InventarioLuchadores {
    ArrayList<Luchadores> inventario = new ArrayList<>(); 
   
    public void agregarLuchadores(){
    if(maxHeroes()){
        inventario.add(new Luchadores());
    }
    }
    private boolean maxHeroes(){
    boolean max=false;
        if(inventario.size()>25){
        System.out.println("Usted a alcanzado el numero maximo de heroes");
        }else{
        max=true;
        }
    return max;
    }
    
    public void mostrarUno(int heroe){
    inventario.get(heroe).mostrarTodo();
    }
    
    public void mostrarInventario(){
    
        for(int i=0;i<inventario.size();i++){
            System.out.print("heroe " +(i+1)+" ");
            inventario.get(i).mostrar(); 
    
        }
    }
    
    public void borrarLuchadores(int pos){
         inventario.remove(pos);   
    }
    
    public void mostrarCant(){
        System.out.println("Se tienen "+inventario.size()+" heroes");
    }
    
    /**
     *
     * @param busqueda
     * @return
     */
    public ArrayList<Luchadores> filtrarFaccion(String busqueda){
    ArrayList<Luchadores> filtrado = new ArrayList<>();
    int j=0;
    for (int i =0;i<inventario.size();i++){
          if(inventario.get(i).getFaccion().equals(busqueda)){
             filtrado.add(j, inventario.get(i));
             j=+1;
        
            }
         }
        return filtrado;
    }
    
    public ArrayList<Luchadores> filtrarRango(int busqueda){
    ArrayList<Luchadores> filtrado = new ArrayList<>();
    int j=0;
    for (int i =0;i<inventario.size();i++){
          if(inventario.get(i).getRango()==busqueda){
             filtrado.add(j, inventario.get(i));
             j=+1;
        
            }
         }
        return filtrado;
    }
    
    public void mostrarFiltrado(ArrayList<Luchadores> filtro){
         for (int i=0;i<filtro.size();i++){
            System.out.print("heroe " +(i+1)+" ");
            filtro.get(i).mostrar(); 
       }
    }
    }


