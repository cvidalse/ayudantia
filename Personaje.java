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
public class Personaje {

    protected Random rdm = new Random();
    protected int hp;
    protected double atk;
    protected int def;
    protected int spd;
    protected String faccion;
    protected String nombre;
    protected int estrellas;
    
     protected String[] faccion() {//array de facciones
        String[] facciones = new String[3];
        facciones[0] = "fuego";
        facciones[1] = "agua";
        facciones[2] = "planta";
        return facciones;
    }
       public int getVida() {
        return this.hp;
    }

    public double getAtk() {
        return this.atk;
    }

    public int getDefensa() {
        return this.def;
    }

    public int getVelocidad() {
        return this.spd;
    }

    public String getFaccion() {
        return this.faccion;
    }

}
