
package com.mycompany.implementacionjava.Modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafico {
    
    XYSeries ejeX = new XYSeries("Eje X");
    XYSeries ejeY = new XYSeries("Eje Y");
    XYSeries puntoA1 = new XYSeries("Punto A1");
    XYSeries puntoA2 = new XYSeries("Punto A2");
    XYSeries puntoA3 = new XYSeries("Punto A3");
    XYSeries puntoB1 = new XYSeries("Punto B1");
    XYSeries recta = new XYSeries("Recta");
    
    XYSeriesCollection dataset = new XYSeriesCollection();
    
    public Grafico () {

    }
    
    public Grafico (float Y1, float Y2, float X1, float X2) {
        this.ejeX.add(-2, 0);
        this.ejeX.add(2, 0);
        this.ejeY.add(0, 2);
        this.ejeY.add(0, -2);
        this.puntoB1.add(1.0, 1.0);
        this.puntoA1.add(1.0, -1.0);
        this.puntoA2.add(-1.0, 1.0);
        this.puntoA3.add(-1.0, -1.0);
       
        if ((Y1 <= 2) && (Y1 >= -2)) {
            
            this.recta.add(2, Y1);  
            
        } else {
            
            if (Y1 > 2) {
                
                this.recta.add(X1, 2); 
                
            } else {
                
                if (Y1 < -2) {
                
                    this.recta.add(X2, -2); 
                
                }
                
            }

        }
        
        if ((Y2 <= 2) && (Y2 >= -2)) {
            
            this.recta.add(-2, Y2);  
            
        } else {
            
            if (Y2 > 2) {
                
                this.recta.add(X1, 2); 
                
            } else {
                
                if (Y2 < -2) {
                
                    this.recta.add(X2, -2); 
                
                }
                
            }

        }    
        
        dataset.addSeries(recta);
        dataset.addSeries(ejeX);
        dataset.addSeries(ejeY);
        dataset.addSeries(puntoB1);
        dataset.addSeries(puntoA1);
        dataset.addSeries(puntoA2);
        dataset.addSeries(puntoA3);
        
    }
    JFreeChart xylineChart = ChartFactory.createXYLineChart(
            "Grafica",
            "Referencias",
            "",
            dataset,
            PlotOrientation.VERTICAL, true, true, false);

    XYPlot plot = xylineChart.getXYPlot();

    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

    public void graficar () {
        
        renderer.setSeriesPaint(0, Color.CYAN);
        renderer.setSeriesPaint(1, Color.BLACK);
        renderer.setSeriesPaint(2, Color.BLACK);
        renderer.setSeriesPaint(3, Color.RED);
        renderer.setSeriesPaint(4, Color.GREEN);
        renderer.setSeriesPaint(5, Color.YELLOW);
        renderer.setSeriesPaint(6, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(1.0f));
        renderer.setSeriesStroke(2, new BasicStroke(1.0f));
        renderer.setSeriesStroke(3, new BasicStroke(2.0f));
        renderer.setSeriesStroke(4, new BasicStroke(2.0f));
        renderer.setSeriesStroke(5, new BasicStroke(2.0f));
        renderer.setSeriesStroke(6, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
        
        ChartPanel panel = new ChartPanel(xylineChart);
 
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(400, 450);
        
        ventana.add(panel);

    }
    
}
