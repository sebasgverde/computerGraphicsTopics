/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dibujandolineas;

import paqueteMatematico.Vector2D;

/**
 *
 * @author sebastian
 */

import java.io.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import paqueteMatematico.Matriz3;

public class DibujandoLineas extends JPanel {
    
    int w;
    int h;
    Graphics2D g2d;
    
    ArrayList<Vector2D> puntos;
    

    @Override
  public void paintComponent(Graphics g) {
      
      puntos = new ArrayList<Vector2D>();
      super.paintComponent(g);

      g2d = (Graphics2D) g;

      g2d.setColor(Color.BLUE);

      // size es el tamaÃƒÂ±o de la ventana.
      Dimension size = getSize();
      // Insets son los bordes y los tÃƒÂ­tulos de la ventana.
      Insets insets = getInsets();

      w =  (size.width - insets.left - insets.right);//496
      h =  size.height - insets.top - insets.bottom;//474
      
  try{
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream("especificacion.txt");
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  
        /*Matriz3 mat = new Matriz3(1,2,3,4,5,6,7,8,9);
      Matriz3 matr = new Matriz3(1,0,2,0,1,0,0,0,1);
      
      Matriz3 matri = mat.mulMatMat3(matr);*/
  
  int numeroPuntos;
  String strLine;
  //Read File Line By Line
  numeroPuntos = Integer.parseInt(br.readLine());
 
  
  for(int i = 0; i< numeroPuntos; i++)
  {
      int x = Integer.parseInt(br.readLine());
      int y = Integer.parseInt(br.readLine());
      
      x = mapearX(x, w);
      y = mapearY(y, h);
      
      Vector2D temp = new Vector2D(x, y);
      
      puntos.add(temp);
  }
  
  int numLineas;
  
    numLineas = Integer.parseInt(br.readLine());
   
     for(int i = 0; i< numLineas; i++)
     {
         int punto1 = Integer.parseInt(br.readLine());
         int punto2 = Integer.parseInt(br.readLine());
         
         g2d.drawLine((int)puntos.get(punto1).getX(), (int)puntos.get(punto1).getY(), (int)puntos.get(punto2).getX(), (int)puntos.get(punto2).getY());
     }

    

     // Print the content on the console
  
    //Close the input stream
     in.close();
    }catch (Exception e){//Catch exception if any
    System.err.println("Error: " + e.getMessage());
  }
  }
  
  int mapearX(int x, int w)
  {
      return (x+w/2);
  }
  
  int mapearY(int y, int h)
  {
      return (h/2-y);
  }
 
    
    /**
     * Programa principal
     * @param args 
     */
    public static void main(String[] args) {
              // Crear un nuevo Frame
      JFrame frame = new JFrame("Lines");
      // Al cerrar el frame, termina la ejecuciÃƒÂ³n de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      frame.add(new DibujandoLineas());
      // Asignarle tamaÃƒÂ±o
      frame.setSize(512+16, 512+38);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
    }
    

}