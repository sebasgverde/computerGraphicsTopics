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
/**
 * Bezier
 * Este programa demuestra la construcciónd de curvas en 2D utilizando el
 * algoritmo de Bézier
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bezier extends JPanel {
    int n = 0;              // hay n+1 numeros de control
    Punto [] puntos;
    int [] coeficientes;     // hay k+1 coeficientes
    boolean DEBUG = false;
    
    Graphics2D g2d;
    int w;
    int h;
    
    /**
     * Constructor
     * Se leen los puntos de control de un archivo llamado puntos.txt
     * Primero se lee el grado de la curva (n)
     * Luego se leen n+1 puntos de control como pares de números
     * primero la x de cada punto de control y luego la y.
     * 
     * Ejemplo de un archivo con puntos de control:
     *  3
     *  100,0 100,0
     *  200,0 300,0
     *  300,0 -100,0
     * 400,0 100,0
     * 
     */
    Bezier() {
        //n = myN;
        Scanner sc;
        try {
            sc = new Scanner(new File("puntos.txt"));
            n = sc.nextInt();
            coeficientes = new int[n + 1];
            puntos = new Punto[n + 1];
            for (int k = 0; k <= n; k++) {
                coeficientes[k] = calcularC(n, k);
                if (DEBUG) {
                    System.out.println(coeficientes[k]);
                }
            }
            for (int i = 0; i <= n; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                puntos[i] = new Punto(x, y);
                if(DEBUG) System.out.println(puntos[i]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bezier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Calcula el valor del punto sobre la curva, dado el valor del parámetro (u)
     * @param u Valor del parámetro: 0 es el comienzo y 1 es el final.
     * @return 
     */
    Punto p(double u) {
        Punto acum = new Punto(0d, 0d);
        for(int k = 0; k <= n; k++) {
            Punto pn = puntos[k].multiplicar(bez(k, u));
            if(DEBUG) System.out.println("bez " + bez(k, u) );
            acum = acum.sumar(pn);
        }
        if(DEBUG) System.out.println("acum" + acum);
        return acum;
    }
    
    /**
     * Cálculo de los coeficientes del binomio
     * @param n grado de la curva
     * @param k número del punto de control
     * @return valor del coeficiente del binomio
     */
    final int calcularC(int n, int k) {
        return fact(n)/(fact(k)*fact(n-k));
    }
    
    double bez(int k, double u) {
        double d = coeficientes[k] * 
                exponente(u, k) * 
                exponente((1-u), (n-k));
        return d;
    }
    
    /**
     * Eleva el número base a la potencia exp
     * @param base base
     * @param exp exponente
     * @return base ** exp
     */
    double exponente(double base, int exp){
        double acum = 1d;
        for (int i = 0; i < exp; i++) {
            acum *= base;
        }
        return acum;
    }
    
    /**
     * Calcula el factorial de n
     * @param n valor cuyo factorial de va a calcular
     * @return n!
     */
    int fact(int n) {
        int acum = 1;
        for(int i = 1; i <= n; i++) {
            acum = acum * i;
        }
        return acum;
    }
    
    /**
     * Se dibuja la curva de control como una serie de rectas.
     * @param steps número de rectas que se van a utilizar para aproximar
     *   la curva
     * @param g2d 
     */
    public void dibujar(int steps, Graphics2D g2d) {
        g2d.setColor(Color.red);
        Punto puntoAnterior = p(0);
        for(double u = 1/(double)steps; u <= 1; u = u + 1/(double)steps ) {
            Punto punto = p(u);
            g2d.drawLine((int)puntoAnterior.x, (int)puntoAnterior.y,
                    (int)punto.x, (int)punto.y);
            System.out.println(p(u));
            puntoAnterior = punto;
        }
        g2d.drawLine((int)puntoAnterior.x, (int)puntoAnterior.y,
                    (int)p(1).x, (int)p(1).y); 
        System.out.println(p(1));
    }
    
        @Override
        /**
         * Dibjar la curva
         */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;
        dibujar(100, g2d);
    }

    
        /**
         * Programa principal
         * @param args 
         */
    public static void main(String [] args) {
        JFrame frame = new JFrame("Bezier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bezier b = new Bezier();
        frame.add(b);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
    /**
     * Clase interna para encapsular los valores X e Y del punto
     */
    private class Punto {
        public double x;
        public double y;
        
        public Punto(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        Punto multiplicar(double escalar) {
            Punto p = new Punto(this.x * escalar, this.y * escalar);
            return p;
        }
        
        Punto sumar(Punto p1) {
            Punto p = new Punto(this.x + p1.x, this.y + p1.y);
            return p;
        }
        
        @Override
        public String toString() {
            return "<" + x + "," + y + ">";
        }
    }
    
}
