/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dibujandotransformaciones;

import java.awt.Polygon;
import java.util.ArrayList;
import paqueteMatematico.Vector3D;

/**
 *
 * @author sebastian
 */
public class Forma {
      public ArrayList<Vector3D> puntos;
  public ArrayList<Integer> conexiones;
      public int [] tempX;
    public int [] tempY ;
    public int [] tempZ;
    public Polygon poligono;
    int w;
    int h;
    double minZ;
    double maxZ;
  
  public Forma()
  {
      puntos = new ArrayList<Vector3D>();
      conexiones = new ArrayList<Integer>();
  }
  
  public void calcPuntosExtremos()
  {
      minZ = puntos.get(0).z;
      maxZ = puntos.get(0).z;
      for(int i = 0; i < puntos.size(); i++)
      {
          if(puntos.get(i).z < minZ)
              minZ = puntos.get(i).z;
          if(puntos.get(i).z > maxZ)
              maxZ = puntos.get(i).z;
      }
  }
    public void crearPoligono()
  {
      tempX = new int[puntos.size()];
      tempY = new int[puntos.size()];
      
      for(int i = 0; i < puntos.size(); i++)
      {
          tempX[i] = (int)puntos.get(i).mapearX(w);
          tempY[i] = (int)puntos.get(i).mapearY(h);
      }
      
      poligono = new Polygon(tempX,tempY,puntos.size());
      calcPuntosExtremos();
  }
    
}
