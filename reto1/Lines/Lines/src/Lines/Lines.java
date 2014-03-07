package Lines;

/*
 * Ejemplo bÃ¡sico en Java2D
 * 
 * Basado en el Tutorial de Java2D de ZetTutorial: http://zetcode.com/tutorials/java2dtutorial/
 * 
 * Java tiene un tutorial oficial para Java2D: http://docs.oracle.com/javase/tutorial/2d/index.html
 */

/**
 * autor: sebastian garcia valencia
 * 
 * basado en el codigo del profesor de computación grafica
 */

//package points;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.Random; 


public class Lines extends JPanel {

  /*
   * En esta funciÃ³n se dibuja.
   * La funciÃ³n es llamada por Java2D.
   * Se recibe una variable Graphics, que contiene la informaciÃ³n del contexto
   * grÃ¡fico.
   * Es necesario hacerle un cast a Graphics2D para trabajar en Java2D.
   * 
   */
    @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2d = (Graphics2D) g;

      g2d.setColor(Color.BLUE);

      // size es el tamaÃ±o de la ventana.
      Dimension size = getSize();
      // Insets son los bordes y los tÃ­tulos de la ventana.
      Insets insets = getInsets();

      int w =  size.width - insets.left - insets.right;
      int h =  size.height - insets.top - insets.bottom;

      // Generador de nÃºmeros Random
      // Se va a utilizar nextInt, que devuelve un entero.
      Random r = new Random();

      //generar 1000 circulos
      for (int i=0; i<1000; i++)//se ve mejor con solo 100, con mil queda muy atiborrado
      {
          /*usados para simular
           * int x1 = 500;
          int y1 = 500;*/
          
          //aqui los puntos se usan para "desplazar" los circulos, pues bajo el algoritmo
          //se trabaja desde el origen
          int x1 = Math.abs(r.nextInt()) % w;
          int y1 = Math.abs(r.nextInt()) % h;
          
           //dibujar circulo
          //g2d.setColor(Color.GREEN); mejor use colores ramdom
          g2d.setColor(new Color(r.nextFloat(),r.nextFloat(),r.nextFloat()));

          int x = 0;
          //int radio = 100;
          int radio = Math.abs(r.nextInt()) % h;
          int p = 3 - (2 * radio);
          
          int y = radio;
          
          while(x < y)
          {
              if(p < 0)
              {
                  p = p + 4 * x + 6;
              }
              else
              {
                  y--;
                  p = p + 4*(x-y)+10;
              }
        
              //octante 2
              g2d.drawLine(x+x1, y+y1, x+x1, y+y1);
              //octante 1
              g2d.drawLine(y+x1, x+y1,y +x1, x+y1);
              //octante 3
              g2d.drawLine(-x+x1, y+y1, -x+x1, y+y1);
              //octante 4
              g2d.drawLine(y+x1, -x+y1, y+x1, -x+y1);
              
              //octante 7
              g2d.drawLine(x+x1, -y+y1, x+x1, -y+y1);
              //octante 8
              g2d.drawLine(-y+x1, x+y1,-y+x1, x+y1);
              //octante 6
              g2d.drawLine(-x+x1, -y+y1, -x+x1, -y+y1);
              //octante 5
              g2d.drawLine(-y+x1, -x+y1,-y +x1, -x+y1);
              
              x++;
          }
      }
      
      // Generar 100 lineas azules
     /* g2d.setColor(Color.BLUE);
      for (int i=0; i<100; i++) {
          int x1 = Math.abs(r.nextInt()) % w;
          int y1 = Math.abs(r.nextInt()) % h;
          int x2 = Math.abs(r.nextInt()) % w;
          int y2 = Math.abs(r.nextInt()) % h;
         
                   
          // AsÃ­ se pinta un punto
          //g2d.drawLine(x1, y1, x1, y1);
         
          int deltaX = x2 - x1;
          int deltaY = y2 - y1;
          int incE = deltaY * 2;
          int incNE = 2 * deltaY - 2 * deltaX;
          
          int d = 2 * deltaY - deltaX;
          int y = y1;

          for(int x = x1; x <= x2; x++)
          {
             g2d.drawLine(x, y, x, y);
             g2d.drawLine(y, x, y, x);
             if(d <= 0)
             {
                 d += incE;
             }
             else
             {
                 d += incNE;
                 y++;
             }
          }
      }*/
      
      
      // Generar 100 lineas rojas
     /* g2d.setColor(Color.RED);
      for (int i=0; i<0; i++) {
          int x1 = Math.abs(r.nextInt()) % w;
          int y1 = Math.abs(r.nextInt()) % h;
          int x2 = Math.abs(r.nextInt()) % w;
          int y2 = Math.abs(r.nextInt()) % h;
          // AsÃ­ se pinta un punto
          g2d.drawLine(x1, y1, x1, y1);
          //g2d.drawLine(x1, y1, x2, y2);
      }*/
  }

  public static void main(String[] args) {
      // Crear un nuevo Frame
      JFrame frame = new JFrame("Lines");
      // Al cerrar el frame, termina la ejecuciÃ³n de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      frame.add(new Lines());
      // Asignarle tamaÃ±o
      frame.setSize(700, 700);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
  }
}