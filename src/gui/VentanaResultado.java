/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import proyectoayudante.InventarioObjeto;

/**
 *
 * @author Ce
 */
public class VentanaResultado extends JFrame implements ActionListener {

    JLabel resultado;
    JButton volver;
    JButton mostrarItem;
    InventarioObjeto inventObj;

    public VentanaResultado(String mensaje, InventarioObjeto invent) {
        inventObj = invent;
        setDefaultCloseOperation(3);
        setResizable(false);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        resultado = new JLabel(mensaje);
        resultado.setBounds(50, 100, 250, 20);
        this.add(resultado);
        volver = new JButton("volver");
        volver.setBounds(100, 200, 150, 20);
        this.add(volver);
        volver.addActionListener(this);
        mostrarItem = new JButton("mostrar Item");
        mostrarItem.setBounds(100, 150, 150, 20);
        this.add(mostrarItem);
        mostrarItem.addActionListener(this);
        mostrarItem.setVisible(false);
        evaluar(mensaje);
        setVisible(true);

    }
    
    public void evaluar(String mensaje){
    if(mensaje.endsWith("inventario")){
    mostrarItem.setVisible(true);
    }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volver) {

            dispose();

        }
        if(e.getSource()== mostrarItem){
       
        JOptionPane.showMessageDialog(this, ""+inventObj.getNombreUltimo());
        }
    }

}
