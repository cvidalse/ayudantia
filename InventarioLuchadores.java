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
public class InventarioLuchadores extends Inventario {

    ArrayList<Luchador> inventario;

    InventarioLuchadores() {
        inventario = new ArrayList<>();
        agregarLuchadores();
    }

    public int getTamaño() {
        return this.inventario.size();
    }

    public void agregarLuchadores() {
        if (maxHeroes()) {
            inventario.add(new Luchador());
        }
 
    }

    
    private boolean maxHeroes() {
        boolean max = false;
        if (inventario.size() > 25) {
            System.out.println("Usted a alcanzado el numero maximo de heroes");
        } else {
            max = true;
        }
        return max;
    }

    public void mostrarUno(int heroe) {
        if (inventario.size() > heroe) {
            inventario.get(heroe).mostrarTodo();
        } else {
            System.out.println("no existe heroe en esa posicion");

        }

    }

    public void mostrarInventario() {
        for (int i = 0; i < inventario.size(); i++) {
            System.out.print("heroe " + (i + 1) + " ");
            inventario.get(i).mostrar();

        }
    }

    public void borrarLuchadores(int pos) {
        if (cantMinima() && inventario.size() > pos) {
            inventario.remove(pos);
        } else {
            System.out.println("no existe heroe en esa posicion");

        }
    }

    public void mostrarCant() {
        System.out.println("Se tienen " + inventario.size() + " heroes");
    }

    /**
     *
     * @param busqueda
     * @param inventario
     * @return
     */
    public ArrayList<Luchador> filtrarFaccion(String busqueda) {
        ArrayList<Luchador> filtrado = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getFaccion().equals(busqueda)) {
                filtrado.add(j, inventario.get(i));
                j = +1;

            }
        }
        return filtrado;
    }

    public ArrayList<Luchador> filtrarRango(int busqueda) {
        ArrayList<Luchador> filtrado = new ArrayList<>();
        if (cantMinima()) {

            int j = 0;
            for (int i = 0; i < inventario.size(); i++) {
                if (inventario.get(i).getRango() == busqueda) {
                    filtrado.add(j, inventario.get(i));
                    j = +1;

                }
            }
        }
        return filtrado;
    }

    public void mostrarFiltrado(ArrayList<Luchador> filtro) {
        if (filtro.size() > 0) {
            System.out.println("La lista de luchadores filtrados por rango ");
            for (int i = 0; i < filtro.size(); i++) {
                System.out.print("heroe " + (i + 1) + " ");
                filtro.get(i).mostrar();
            }
        } else {
            System.out.println("no hay luchadores de ese rango");

        }
    }

    private boolean cantMinima() {
        boolean min = false;
        if (inventario.size() < 2) {
            System.out.println("Usted no cuenta con luchadores");
        } else {
            min = true;
        }

        return min;

    }

}
