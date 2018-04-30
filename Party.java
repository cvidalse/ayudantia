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
    private Random rdm = new Random();
    ArrayList<Luchador> party;

    Party(InventarioLuchadores inv) {
        invLuch = inv;
        party = new ArrayList<>();
        elejirParty();
    }

    private int numeroLuch() {
        int numero = rdm.nextInt(invLuch.getTamaño());
        System.out.println("" + invLuch.getTamaño());
        return numero;
    }

    private void elejirParty() {
        ArrayList<Integer> aux = new ArrayList<>();
        if (invLuch.getTamaño() < 6) {
            party = invLuch.inventario;
        } else {
            aux.add(0);

            int numero;

            for (int i = 0; i < 6; i++) {

                for (int j = 0; j < aux.size(); j++) {
                    numero = numeroLuch();

                    if (numero == aux.get(j)) {

                        System.out.println("este luchador ya se encuentra en la party");
                    } else {
                        aux.add(numero);

                        party.add(i, invLuch.inventario.get(numero));
                        break;
                    }
                }
            }
        }
    }

    public void mostrarInventario() {
        for (int i = 0; i < party.size(); i++) {
            System.out.print("luchadores que pelearan " + (i + 1) + " ");
            party.get(i).mostrarTodo();

        }
    }

}
