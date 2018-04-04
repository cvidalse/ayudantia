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
public class Monstruo {
    private int vida;
    private int atk;
    private int defensa;
    private int velocidad;
    Random rdm = new Random();
    
    Monstruo(){
    crearMonstruo();
    }
    
    private void valorVida(){
    vida = rdm.nextInt(501)+3000;
    }
    
    private void valorAtaque(){
    atk = rdm.nextInt(501)+1000;
    }
    
    private void valorDefensa(){
    defensa = rdm.nextInt(21)+5;
    }
    
    private void valorVelocidad(){
    velocidad = rdm.nextInt(91)+10;
    }
    private void crearMonstruo(){
    valorVelocidad();
    valorAtaque();
    valorDefensa();
    valorVida();
    }
    
    private ArrayList<ObjetoEquipable> crearObjetoDropeable(){
    ArrayList<ObjetoEquipable> auxiliar = new ArrayList<>();
    auxiliar.add(new ObjetoEquipable());
    return auxiliar;
    }
    
    public void mostrarCaract(){
    System.out.println("vida-------------------ataque---------------defensa-----------------velocidad");
    System.out.println(""+vida+"------------------"+atk+"-------------------"+defensa+"-----------------------"+velocidad);
    }
    
    
    
    public void mostrarDrop(){
    ArrayList<ObjetoEquipable> aux = crearObjetoDropeable();
    System.out.println("el objeto que podria dropear es ");
    aux.get(0).mostrarTodo();
    }
}
