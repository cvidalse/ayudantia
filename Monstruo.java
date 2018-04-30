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
    private double atk;
    private int defensa;
    private int velocidad;
    Random rdm = new Random();
    private String faccion;
    private ArrayList<ObjetoEquipable> drops;

    Monstruo() {
        drops = new ArrayList<>();
        crearMonstruo();
    }

    private ArrayList<String> listFaccion() {
        ArrayList<String> fac = new ArrayList<>();
        fac.add("fuego");
        fac.add("planta");
        fac.add("agua");
        return fac;
    }

    private void facciones(ArrayList<String> fac) {
        int selct = rdm.nextInt(3);

        faccion = fac.get(selct);
    }

    public int getVida() {
        return this.vida;
    }

    public double getAtk() {
        return this.atk;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public String getFaccion() {
        return this.faccion;
    }

    public void setAtk(double modificado) {
        atk = this.atk * modificado;
    }

    private void valorVida() {
        vida = rdm.nextInt(501) + 3000;
    }

    private void valorAtaque() {
        atk = rdm.nextInt(501) + 1000;
    }

    private void valorDefensa() {
        defensa = rdm.nextInt(21) + 5;
    }

    private void valorVelocidad() {
        velocidad = rdm.nextInt(91) + 10;
    }

    private void crearMonstruo() {
        valorVelocidad();
        valorAtaque();
        valorDefensa();
        valorVida();
        facciones(listFaccion());
        crearObjetoDropeable();
    }

    private void crearObjetoDropeable() {
        int estrellas = 1;
        for (int i = 0; 3 > i; i++) {
            drops.add(i, new ObjetoEquipable(estrellas));
            estrellas = estrellas + 2;
        }
    }

    public void mostrarCaract() {
        System.out.println("vida-------------------ataque---------------defensa-----------------velocidad");
        System.out.println("" + vida + "------------------" + atk + "-------------------" + defensa + "-----------------------" + velocidad);
    }

    public void Dropmuerte(boolean muerte, InventarioObjeto inventObj) {
        if (muerte) {
            int lugar = decidirDrop();
            inventObj.agregarObjetoDropeado(drops.get(lugar));
        }
    }

    /*public void contador(){
    for(int i=0;i<6;i++){
    System.out.println(""+i);
    }
    }    
     */
    private int decidirDrop() {
        int lugar;
        double posibilidad = rdm.nextDouble() * 100;
        if (60 > posibilidad) {
            lugar = 0;
        } else {

            if (90 > posibilidad) {
                lugar = 1;
            } else {
                lugar = 2;
            }

        }
        return lugar;
    }

    public void mostrarDrop() {
        for (int i = 0; 3 > i; i++) {
            System.out.println("el objeto que podria dropear es ");
            drops.get(i).mostrarTodo();
        }
    }
}
