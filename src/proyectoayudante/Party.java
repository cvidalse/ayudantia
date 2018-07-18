/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoayudante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Spliterator;

/**
 *
 * @author Ce
 */
public class Party {

    private Map<Integer, Luchador> cache = new HashMap<Integer, Luchador>();
    InventarioLuchadores invLuch;
//    private Random rdm = new Random();
    ArrayList<Luchador> party;
    private int valor;
    Random rdm = new Random();

    public Party(InventarioLuchadores inv, int valorLectura) {
        invLuch = inv;
        this.valor = valorLectura;
        party = new ArrayList<>();
        
        elejirPary();
        ordenParty();

    }

    private int numeroLuch() {
        int numero = rdm.nextInt(invLuch.getTamaño());
        return numero;
//        int numero;
//        Scanner sc = new Scanner(System.in);
//        try {
//            System.out.println("ingrese el numero de luchador");
//            numero = sc.nextInt();
////            System.out.println(numero);
//            return numero;
//
//        } catch (InputMismatchException ip) {
////            System.out.println("shais");
//            return numeroLuch();
//        }

    }

    private int validacion(int numero) {
//        System.out.println("validando");

        if (numero > invLuch.getTamaño() || numero < 0 || cache.containsValue(invLuch.inventario.get(numero))) {
            System.out.println("el nummero no cumple el formato");
            return validacion(numeroLuch());

        } else {
//            System.out.println("paso aqui");
            return numero;
        }
    }

    public void addLuchador() {
        int numero = validacion(numeroLuch());
        party.add(invLuch.inventario.get(numero));

//        System.out.println("aqui");
        System.out.println("agrgaste a " + invLuch.inventario.get(numero).nombre);
        cache.put(numero, invLuch.inventario.get(numero));
    }

//    private void elejirParty() {
//        ArrayList<Integer> aux = new ArrayList<>();
//        if (invLuch.getTamaño() < 6) {
//            party = invLuch.inventario;
//        } else {
//            aux.add(0);
//
//            int numero;
//
//            for (int i = 0; i < 6; i++) {
//
//                for (int j = 0; j < aux.size(); j++) {
//                    numero = numeroLuch();
//
//                    if (numero == aux.get(j)) {
//
//                        System.out.println("este luchador ya se encuentra en la party");
//                    } else {
//                        aux.add(numero);
//
//                        try{
//                            party.add(i, invLuch.inventario.get(numero));
//                        }catch(IndexOutOfBoundsException ie){
//                         party.add(i, invLuch.inventario.get(numeroLuch()));
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//    }
    public void elejirPary() {

        
        while (party.size() < valor && invLuch.getTamaño() != party.size() && party.size()<7) {
            System.out.println("tamaño" + party.size());
            try {
                addLuchador();

            } catch (Exception e) {
                System.out.println("fallo");
            }

        }
    }

    public void ordenParty() {
        Collections.sort(party);
    }

    public void mostrarInventario() {
        for (int i = 0; i < party.size(); i++) {
            System.out.print("luchadores que pelearan " + (i + 1) + " ");
            party.get(i).mostrarTodo();

        }
    }

}
