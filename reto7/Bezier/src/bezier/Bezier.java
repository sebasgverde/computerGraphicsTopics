/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bezier;

/**
 *
 * @author sebastian
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import paqueteMatematico.Vector2D;

public class Bezier extends JPanel {
    int numeroPuntos = 0;    
    Vector2D [] puntos;
    int [] coeficientes;  
    
    Graphics2D g2d;
    int w;
    int h;
    
    Bezier() {
        Scanner sc;
        try {
            sc = new Scanner(new File("especificacion.txt"));
            
            numeroPuntos = Integer.parseInt(sc.nextLine()) - 1;
            
            coeficientes = new int[numeroPuntos + 1];
            puntos = new Vector2D[numeroPuntos + 1];
            
            for (int k = 0; k <= numeroPuntos; k++) {
                coeficientes[k] = calcC(numeroPuntos, k);
            }
            for (int i = 0; i <= numeroPuntos; i++) {
                String [] punt = sc.nextLine().split(" ");
                double x = Double.parseDouble(punt[0]);
                double y = Double.parseDouble(punt[1]);
                puntos[i] = new Vector2D(x, y,1);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bezier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Vector2D p(double u) {
        Vector2D acumulador = new Vector2D(0, 0,1);
        for(int k = 0; k <= numeroPuntos; k++) {
            Vector2D punto = puntos[k].multiplicar(bezCoef(k, u));
            acumulador = acumulador.sumar(punto);
        }
        return acumulador;
    }
    

    int calcC(int n, int k) {
        return factorial(n)/(factorial(k)*factorial(n-k));
    }
    
    double bezCoef(int k, double u) {
        double d = coeficientes[k] * Math.pow(u, k) * Math.pow((1-u), (numeroPuntos-k));
        return d;
    }
    
    
    int factorial(int n) {
        int acum = 1;
        for(int i = 1; i <= n; i++) {
            acum = acum * i;
        }
        return acum;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;
        int steps = 100;
        
      Dimension size = getSize();
      Insets insets = getInsets();

      w =  (size.width - insets.left - insets.right);//496
      h =  size.height - insets.top - insets.bottom;//474
      
      g2d.drawLine(w/2, 0, w/2, h);
      g2d.drawLine(w,h/2,0, h/2);
        
        g2d.setColor(Color.GREEN);
        
        Vector2D puntoAnterior = p(0);
        
        for(double u = 1/(double)steps; u <= 1; u = u + 1/(double)steps ) {
            Vector2D punto = p(u);
            g2d.drawLine(puntoAnterior.mapearX(w), puntoAnterior.mapearY(h),
                    punto.mapearX(w), punto.mapearY(h));
            puntoAnterior = punto;
        }
        g2d.drawLine((int)puntoAnterior.mapearX(w), (int)puntoAnterior.mapearY(h),
                    (int)p(1).mapearX(w), (int)p(1).mapearY(h));      
    }

    
    public static void main(String [] args) {
        JFrame frame = new JFrame("Bezier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bezier b = new Bezier();
        frame.add(b);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);      
    }       
}
