/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoayudante;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Ce
 */
public class Combate {

    Monstruo enemigo;
    Party aliados;
    JuegoDado dado;
    InventarioObjeto inventObj;
    private double ataqueAliado;
    private double ataqueMonstruo;
    private double hpHeroe;
    private double hpMonstruo;
//    private ArrayList<Personaje> orden = new ArrayList<>();

    Combate(Monstruo m, Party p, JuegoDado jd, InventarioObjeto io) {
        aliados = p;
        enemigo = m;
        dado = jd;
        inventObj = io;
        combate();

    }

    private void analizarDados(int i) {
        int resta = dado.getValorResta();

        if (resta > 0) {
            /*for(int i=0;i<aliados.party.size();i++){
    
             */
            ataqueAliado = aliados.party.get(i).getAtk() * resta;
            ataqueMonstruo = enemigo.getAtk();
        } else {

            if (dado.getValorResta() < 0) {
                ataqueMonstruo = enemigo.getAtk() * resta * -1;
                ataqueAliado = aliados.party.get(i).getAtk();

            } else {
                ataqueAliado = aliados.party.get(i).getAtk();
                ataqueMonstruo = enemigo.getAtk();
            }
        }
    }

    private void analizarFaccion(int i) {

        if (aliados.party.get(i).getFaccion().endsWith("agua") && enemigo.getFaccion().endsWith("fuego")) {
            ataqueAliado = this.ataqueAliado * 1.5;
            ataqueMonstruo = this.ataqueMonstruo * 0.75;
//            System.out.println("favorable para el heroe agua vs fuego");
        } else {

            if (aliados.party.get(i).getFaccion().endsWith("fuego") && enemigo.getFaccion().endsWith("planta")) {
                ataqueAliado = this.ataqueAliado * 1.5;
                ataqueMonstruo = this.ataqueMonstruo * 0.75;
//                System.out.println("fuego vs planta");
            } else {

                if (aliados.party.get(i).getFaccion().endsWith("planta") && enemigo.getFaccion().endsWith("agua")) {
                    ataqueAliado = this.ataqueAliado * 1.5;
                    ataqueMonstruo = this.ataqueMonstruo * 0.75;
//                    System.out.println("planta vs agua");
                } else {
                    if (aliados.party.get(i).getFaccion() == enemigo.getFaccion()) {
                        ataqueAliado = this.ataqueAliado;
                        ataqueMonstruo = this.ataqueMonstruo;
//                        System.out.println("tienen la misma faccion");
                    } else {
                        ataqueAliado = this.ataqueAliado * 0.75;
                        ataqueMonstruo = this.ataqueMonstruo * 1.5;
//                        System.out.println("faccion del heroe" + aliados.party.get(i).getFaccion());
//                        System.out.println("faccion del monstruo" + enemigo.getFaccion());
                    }
                }
            }
        }
    }

    private double fijarDañoHeroe(int i) {
        analizarDados(i);
        analizarFaccion(i);
        double daño = ataqueAliado - enemigo.getDefensa();
        //System.out.println("heroe"+ataqueAliado+"defensa"+enemigo.getDefensa());
        return daño;
    }

    private double fijarDañoMonstruo(int i) {
        analizarDados(i);
        analizarFaccion(i);
        double daño = ataqueMonstruo - aliados.party.get(i).getDefensa();
        //System.out.println("ataque monstruo "+ataqueMonstruo+" defensa ALIDO"+aliados.party.get(i).getDef());
        return daño;
    }

    private boolean ordenAtaque(int i) {
        boolean orden;
        if (aliados.party.get(i).getVelocidad() > enemigo.getVelocidad()) {
            orden = true;
            System.out.println("el luchador atacara primero");
        } else {
            orden = false;
            System.out.println("el monstruo atacara primero");
        }
        return true;
    }

//    public void combate() {
//        hpMonstruo = enemigo.getVida();
//
//        for (int i = 0; i < aliados.party.size(); i++) {
//            hpHeroe = aliados.party.get(i).getVida();
//
//            double dañoM = fijarDañoMonstruo(i);
//            double dañoH = fijarDañoHeroe(i);
//            boolean orden = ordenAtaque(i);
//            do {
//                if (orden) {
//
//                    this.hpMonstruo = hpMonstruo - (dañoH);
//                    System.out.println("la vida restante " + hpMonstruo);
//                    if (hpMonstruo < 0) {
//
//                        i = aliados.party.size();
//                        System.out.println("El enemigo a muerto, se agregara un Item a tu inventario");
//                        enemigo.Dropmuerte(true, inventObj);
//                        inventObj.mostrarInventario();
//                        break;
//                    }
    //System.out.println("el daño fue increible "+dañoH+"vida"+hpMonstruo);
//
//                    hpHeroe = this.hpHeroe - dañoM;
//                    System.out.println("vida heroe restante" + hpHeroe + " daño monstruo" + dañoM);
//                    if (hpHeroe < 0) {
//                        System.out.println("uno de tus peleadores cayo en batalla");
//                        break;
//                    }
//System.out.println(" "+hpHeroe+" daño "+dañoM);
//
//                } else {
//
//                    hpHeroe = this.hpHeroe - dañoM;
//                    System.out.println("el daño fue increible al heroe" + hpHeroe);
//                    if (hpHeroe < 0) {
//                        System.out.println("uno de tus peleadores cayo en batalla");
//
//                        break;
//
//                    }
//
//                    hpMonstruo = this.hpMonstruo - dañoH;
//
//                    if (hpMonstruo < 0) {
//
//                        i = aliados.party.size();
//
//                        System.out.println("El enemigo a muerto, se agregara un Item a tu inventario");
//
//                        enemigo.Dropmuerte(true, inventObj);
//
//                        inventObj.mostrarInventario();
//
//                        break;
//                    }
//                }
//
//            } while (hpMonstruo > 0 && hpHeroe > 0);
//        }
//        if (hpMonstruo > 0) {
//            System.out.println("todos tus luchadores han sido derrotados");
//        }
//    }
    public void combate() {
        hpMonstruo = enemigo.getVida();
        int x = 1;

        do {

            boolean monstruoAtaque = false;
            System.out.println("turno " + x);
            System.out.println("" + aliados.party.size());
            for (int i = 0; i < aliados.party.size(); i++) {
                hpHeroe = aliados.party.get(i).getVida();

                double dañoM = fijarDañoMonstruo(i);
                double dañoH = fijarDañoHeroe(i);
                if (aliados.party.get(i).getVelocidad() < enemigo.getDefensa()) {
                    if (monstruoAtaque) {
                        hpMonstruo = hpMonstruo - dañoH;
                        System.out.println("ataca el heroe" + i);
                        if (hpMonstruo < 0) {
                            break;
                        }

                    } else {
                        aliados.party.get(0).setHpPelea(dañoM);
                        monstruoAtaque = true;
                        System.out.println("montruo ataco ");
                        if (aliados.party.get(0).getHpPelea() < 0) {
                            aliados.party.remove(0);
                        }
                    }
                } else {
                    hpMonstruo = hpMonstruo - dañoH;

                    System.out.println("ataca el heroe" + i);
                    System.out.println(hpMonstruo);
                    if (hpMonstruo < 0) {
                        break;
                    }
                }
                if (i == aliados.party.size()-1) {
                    aliados.party.get(0).setHpPelea(dañoM);
                    System.out.println("ataco monstgruo");
                    if(aliados.party.get(0).getHpPelea()<0){
                    aliados.party.remove(0);
                    }
                }
            }

            x = x + 1;
        } while (hpMonstruo > 0 && aliados.party.size() > 0);

        if (hpMonstruo > 0) {
            System.out.println("todos tus luchadores han sido derrotados");
        } else {
            System.out.println("El enemigo a muerto, se agregara un Item a tu inventario");

            enemigo.Dropmuerte(true, inventObj);

            inventObj.mostrarInventario();

        }
    }
}
