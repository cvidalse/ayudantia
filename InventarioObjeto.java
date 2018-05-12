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
public class InventarioObjeto extends Inventario {

    ArrayList<ObjetoEquipable> inventObjeto;

    InventarioObjeto() {
        inventObjeto = new ArrayList<>();
    }

    public void agregarObjetoDropeado(ObjetoEquipable obj) {
        if (cantMaxima()) {
            inventObjeto.add(obj);
        }
    }

    public void agregarObjeto() {
        if (cantMaxima()) {
            inventObjeto.add(new ObjetoEquipable());
        }
    }

    public void eliminarObjeto(int pos) {
        if (cantMinima() && inventObjeto.size() > pos) {
            inventObjeto.remove(pos);
        } else {
            System.out.println("no tiene objetos");
        }
    }

    public void mostrarInventario() {
        if (cantMinima()) {
            for (int i = 0; i < inventObjeto.size(); i++) {
                System.out.print("Objeto" + (i + 1) + " ");
                inventObjeto.get(i).mostrarTodo();

            }
        }
    }

    private boolean cantMinima() {
        boolean min = false;
        if (inventObjeto.size() < 1) {
            System.out.println("Usted no cuenta con luchadores");
        } else {
            min = true;
        }

        return min;
    }

    private boolean cantMaxima() { //cantoidad maxima de luchadores
        boolean max = false;
        if (inventObjeto.size() > 10) {
            System.out.println("Usted no tiene espacio para almacenar un nueov objeto");
        } else {
            max = true;
        }
        return max;
    }

    public ArrayList<ObjetoEquipable> filtrar(int busqueda) {
        ArrayList<ObjetoEquipable> filtrado = new ArrayList<>();
        if (cantMinima()) {
            int j = 0;
            for (int i = 0; i < inventObjeto.size(); i++) {
                if (inventObjeto.get(i).getRango() == busqueda) {
                    filtrado.add(j, inventObjeto.get(i));
                    j = +1;

                }
            }
        }
        return filtrado;
    }

    public void mostrarFiltrado(ArrayList<ObjetoEquipable> filtro) {
        for (int i = 0; i < filtro.size(); i++) {
            System.out.print("heroe " + (i + 1) + " ");
            filtro.get(i).mostrarTodo();
        }
    }
}
