/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proyectoayudante.*;

/**
 *
 * @author Ce
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    JuegoDado jDado;
    JButton dados;
    JButton combate;
    JButton party;
    JButton luchador;
    InventarioLuchadores invent;
    InventarioObjeto inventObj;
    Monstruo mo;
    Combate comb;
    Party grupo;
    JLabel etiqueta;
    JTextField numeroParty;
    int valorDados;

    public VentanaPrincipal() {

        invent = new InventarioLuchadores();
        inventObj = new InventarioObjeto();
        jDado = new JuegoDado();
        valorDados = 0;
        setDefaultCloseOperation(3);
        setResizable(false);
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(null);
        dados = new JButton("lanzar dados");
        dados.setBounds(10, 50, 150, 20);
        this.add(dados);
//        etiquetaDados = new JLabel("0");
//        etiquetaDados.setBounds(170, 50, 150, 20);
//        this.add(etiquetaDados);
        dados.addActionListener(this);
        party = new JButton("n° party");
        party.setBounds(10, 80, 150, 20);
        this.add(party);
        numeroParty = new JTextField();
        numeroParty.setBounds(170, 80, 150, 20);
        numeroParty.setVisible(true);
        this.add(numeroParty);
        party.addActionListener(this);
        luchador = new JButton("agregarLuchador");
        luchador.setBounds(10, 110, 150, 20);
        this.add(luchador);
        luchador.addActionListener(this);
        combate = new JButton("Combatir");
        combate.setBounds(10, 140, 150, 20);
        this.add(combate);
        combate.addActionListener(this);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dados) {

//            etiquetaDados.setText("" + jDado.getValorResta());
            valorDados = jDado.getValorResta();
            JOptionPane.showMessageDialog(this, "valor de los dados :" + valorDados);
            dados.setEnabled(false);
        }
        if (e.getSource() == party) {

            int valor = 0;
            try {//existen 2 condiciones que el valor ingresado no sea un numero o que falle la creacion de la clase
                valor = Integer.parseInt(numeroParty.getText());
                if(valor>invent.getTamaño()){
                JOptionPane.showMessageDialog(this, "solo se pueden agregar "+invent.getTamaño()+" luchadores");
              
                }
                
                
                grupo = new Party(invent, valor);
                
                JOptionPane.showMessageDialog(this, "party creada");
                party.setEnabled(false);
            } catch (Exception d) {//muestra un mensaje indicando el error, se maneja solo como excepcion porque pueden ser de 2 tipos
                JOptionPane.showMessageDialog(this, "valor no valido, intente denuevo");

            }

        }
        if (e.getSource() == luchador) {
            invent.agregarLuchadores();
            JOptionPane.showMessageDialog(this, "Se ha agregado un luchador a su inventario "+invent.getNombreUltimo());
        }
        if (e.getSource() == combate) {
            try {//la condicion para que gatille la excepcion es que la clase Party aun no hubiese sido creada
                mo = new Monstruo();
                comb = new Combate(mo, grupo, jDado, inventObj);
                dados.setEnabled(true);
                party.setEnabled(true);
                VentanaResultado vent = new VentanaResultado(comb.toString(), inventObj);

            } catch (NullPointerException np) {//muestra un mensaje mediante JOptionPane, la eleccion se debe a que ese es el tipo de exception que arroja al apuntar a algo inexistente
                JOptionPane.showMessageDialog(this, "agrege peleadores a party antes de presionar este boton");
            }
        }
    }

    public static void main(String[] args) {

        VentanaPrincipal vp = new VentanaPrincipal();

    }
}
