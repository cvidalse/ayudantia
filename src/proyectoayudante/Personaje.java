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
public class Personaje implements Comparable<Personaje> {

    protected Random rdm = new Random();
    protected double hp;
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
       public double getVida() {
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
    
    @Override
    public int compareTo(Personaje o) {
//        if (spd > o.spd) {
//            return -1;
//        }
//        if (spd < o.spd) {
//            return 1;
//        }
        return Integer.compare(o.spd, spd);
    }
}
