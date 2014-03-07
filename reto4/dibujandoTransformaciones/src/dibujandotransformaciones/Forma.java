/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dibujandotransformaciones;

import java.util.ArrayList;
import paqueteMatematico.Vector2D;

/**
 *
 * @author sebastian
 */
public class Forma {
      public ArrayList<Vector2D> puntos;
  public ArrayList<Integer> conexiones;
  
  public Forma()
  {
      puntos = new ArrayList<Vector2D>();
      conexiones = new ArrayList<Integer>();
  }
    
}
