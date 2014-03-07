/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dibujandotransformaciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

import paqueteMatematico.*;

/**
 *
 * @author sebastian
 */
public class DibujandoTransformaciones extends JPanel {
    
    int w;
    int h;
    Graphics2D g2d;
    
    boolean banderaGlobal = true;
    boolean bandRepintarTodo =false;
    
  public ArrayList<Forma> formas;
  
  Matriz2 mat;
  
  public void funcion()
  {
      formas = new ArrayList<Forma>();
      
      mat = new Matriz2(0,0,0,0);
      
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

        Forma form = new Forma();
        
        for(int i = 0; i< numeroPuntos; i++)
        {
            double x = Double.parseDouble(br.readLine());
            double y = Double.parseDouble(br.readLine());

            //x = mapearX((int)x, w);
            //y = mapearY((int)y, h);

            Vector2D temp = new Vector2D(x, y,1);

            form.puntos.add(temp);
        }

        int numLineas;

          numLineas = Integer.parseInt(br.readLine());

           for(int i = 0; i< numLineas; i++)
           {
               Integer punto1 = Integer.parseInt(br.readLine());
               form.conexiones.add(punto1);
               Integer punto2 = Integer.parseInt(br.readLine());
               form.conexiones.add(punto2);


              // g2d.drawLine((int)puntos.get(punto1).x, (int)puntos.get(punto1).y, (int)puntos.get(punto2).x, (int)puntos.get(punto2).y);
           }

           formas.add(form);

           // Print the content on the console

          //Close the input stream
           in.close();
    }catch (Exception e){//Catch exception if any
    System.err.println("Error: " + e.getMessage());
  }
  }
  
    @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
            
      g2d = (Graphics2D) g;

      g2d.setColor(Color.BLUE);
      

      // size es el tamaÃƒÆ’Ã‚Â±o de la ventana.
      Dimension size = getSize();
      // Insets son los bordes y los tÃƒÆ’Ã‚Â­tulos de la ventana.
      Insets insets = getInsets();

      w =  (size.width - insets.left - insets.right);//496
      h =  size.height - insets.top - insets.bottom;//474
      
      g2d.drawLine(w/2, 0, w/2, h);
      g2d.drawLine(w,h/2,0, h/2);
      
      if(banderaGlobal)
        funcion();
      
      int inicial;
      if(bandRepintarTodo)
        inicial = 0;
      else
          inicial = formas.size()-1;
       
      for(int j = inicial; j< formas.size();j++)
       {
            ArrayList<Vector2D> puntos = formas.get(j).puntos;
            ArrayList<Integer> conexiones= formas.get(j).conexiones;

            for(int i = 0; i< conexiones.size();i=i)
            {
                int punto1 = conexiones.get(i++);
                int punto2 = conexiones.get(i++);
                g2d.drawLine((int)puntos.get(punto1).mapearX(w), (int)puntos.get(punto1).mapearY(h), (int)puntos.get(punto2).mapearX(w), (int)puntos.get(punto2).mapearY(h));
            }
       }
     
          

        
          
  }
  
  public int mapearX(int x, int w)
  {
      return (x+w/2);
  }
  
  public int mapearY(int y, int h)
  {
      return (h/2-y);
  }
  
   public void escalar(double x, double y)
  {
      banderaGlobal = false;
     Matriz2 s = mat.scale(x, y);
     
         Forma nuevF =new Forma();
    nuevF.conexiones = formas.get(formas.size()-1).conexiones;
      
      for(int i = 0; i < formas.get(formas.size()-1).puntos.size();i++)
      {
          //puntos.add(r.multVector(puntos.get(i)));
        nuevF.puntos.add(s.multVector(formas.get(formas.size()-1).puntos.get(i))); 
               System.out.println(nuevF.puntos.get(i).x);

      }
      formas.add(nuevF);
   repaint();
  }
  
  public void trasladar(int x, int y)
  {
      banderaGlobal = false;
   Matriz2 t = mat.translate(x, y);
   
    Forma nuevF =new Forma();
    nuevF.conexiones = formas.get(formas.size()-1).conexiones;
      
      for(int i = 0; i < formas.get(formas.size()-1).puntos.size();i++)
      {
          //puntos.add(r.multVector(puntos.get(i)));
        nuevF.puntos.add(t.multVector(formas.get(formas.size()-1).puntos.get(i))); 
               System.out.println(nuevF.puntos.get(i).x);

      }
      formas.add(nuevF);
   repaint();
  }
  
  public void rotar(double theta)
  {
      banderaGlobal=false;
      Matriz2 r = mat.rotation(theta);
      
      Forma nuevF =new Forma();
      nuevF.conexiones = formas.get(formas.size()-1).conexiones;
      
      for(int i = 0; i < formas.get(formas.size()-1).puntos.size();i++)
      {
          //puntos.add(r.multVector(puntos.get(i)));
        nuevF.puntos.add(r.multVector(formas.get(formas.size()-1).puntos.get(i))); 
               System.out.println(nuevF.puntos.get(i).x);

      }
      formas.add(nuevF);
      repaint();
  }
  
  public void draw()
  {
      repaint();
  }
 
    
    /**
     * Programa principal
     * @param args 
     */
    /*public static void main(String[] args) {
              // Crear un nuevo Frame
      JFrame frame = new JFrame("Lines");
      // Al cerrar el frame, termina la ejecuciÃƒÆ’Ã‚Â³n de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      frame.add(new DibujandoTransformaciones());
      // Asignarle tamaÃƒÆ’Ã‚Â±o
      frame.setSize(512+16, 512+38);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
    }*/
    

}