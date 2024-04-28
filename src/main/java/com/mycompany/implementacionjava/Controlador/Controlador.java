
package com.mycompany.implementacionjava.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

import com.mycompany.implementacionjava.Vista.Ventana;
import com.mycompany.implementacionjava.Modelo.Grafico;
import com.mycompany.implementacionjava.Modelo.PerceptronSimpleAND;

public class Controlador implements ActionListener {
    
     //Atributos
    private Ventana view;
    private Grafico grafico;
    private PerceptronSimpleAND perceptronSimpleAND;
    
    //Constructor
    public Controlador (Ventana view, Grafico grafico, PerceptronSimpleAND perceptronSimpleAND) {
        
        this.view = view;
        this.grafico = grafico;
        this.perceptronSimpleAND = perceptronSimpleAND;
        this.view.btnEntrenamiento.addActionListener(this);
        this.view.btnAprendizaje.addActionListener(this);
        this.view.btnPrueba.addActionListener(this);
    }
    
    //Metodo que inicia la vista. 
    public void iniciar () {
        
        view.setTitle("PERCEPTRÓN SIMPLE AND");
        view.setLocationRelativeTo(null);
        
    }
    
    //Función que realizan los botones. 
    public void actionPerformed (ActionEvent e) {
        
        if (e.getSource() == view.btnEntrenamiento) {

            perceptronSimpleAND.Entrenamiento();

            if (perceptronSimpleAND.getFila() == 4) {

                view.jlbEstado.setText("ENTRENAMIENTO COMPLETADO - DATOS FINALES:");

            } else {

                view.jlbEstado.setText("ENTRENAMIENTO FALLIDO - DATOS OBTENIDO:");

            }

            view.jlbEntrada1.setText("Entada 1: " + Float.toString(perceptronSimpleAND.getEntradas(1)));
            view.jlbEntrada2.setText("Entada 2: " + Float.toString(perceptronSimpleAND.getEntradas(2)));

            view.jlbPeso1.setText("Peso 1: " + Float.toString(perceptronSimpleAND.getW1()));
            view.jlbPeso2.setText("Peso 2: " + Float.toString(perceptronSimpleAND.getW2()));
            view.jlbUmbral.setText("Umbral: " + Float.toString(perceptronSimpleAND.getW0()));

            view.jlbSalidaDeseada.setText("Salida Deseada: " + Float.toString(perceptronSimpleAND.getSalidas((int) perceptronSimpleAND.getFila())));
            view.jlbSalidaObtenida.setText("Salida Obtenida: " + Float.toString(perceptronSimpleAND.getY()));

            float punto1 = (-1 / perceptronSimpleAND.getW2()) * perceptronSimpleAND.getW0();
            float punto2 = (-1 / perceptronSimpleAND.getW1()) * perceptronSimpleAND.getW0();

            float m = (0 - (punto1)) / ((punto2) - 0);
            float n = 0 - (punto2 * m);

            float y1 = ((m) * (2)) + (n);
            float y2 = ((m) * (-2)) + (n);

            float x1 = ((n) - 2) / -(m);
            float x2 = ((n) + 2) / -(m);

            grafico = new Grafico(y1, y2, x1, x2);

            grafico.graficar();

        }
        
        if (e.getSource() == view.btnAprendizaje) {
            
            perceptronSimpleAND.Aprendizaje();
            
            showMessageDialog(null, "Recalculamos los Pesos" + "\n Nuevo Umbral = " + perceptronSimpleAND.getW0() + "\n Nuevo Peso 1 = " + perceptronSimpleAND.getW1() + "\n Nuevo Peso 2 = " + perceptronSimpleAND.getW2());
            
        }
        
        if (e.getSource() == view.btnPrueba) {
            
            String Entrada1 = view.jtfEntrada1.getText();
            String Entrada2 = view.jtfEntrada2.getText();
            boolean bandera = false ;
            
            if ((((Entrada1.compareTo("1")) != 0) && ((Entrada1.compareTo("-1")) != 0)) || (((Entrada2.compareTo("1")) != 0) && ((Entrada2.compareTo("-1")) != 0))) {
                
                showMessageDialog(null, "ERROR. Solamente se haceptan valores 1 o -1");
                bandera = true;
                
            }
            
            if (bandera == false) {
                float y = perceptronSimpleAND.PruebaFuncionamiento(Integer.parseInt(Entrada1), Integer.parseInt(Entrada2));
                view.jlbSalidaPrueba.setText("Salida Obtenida: " + Float.toString(y));
            }
            
        }
        
    }
    
}
