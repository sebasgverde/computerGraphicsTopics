/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paqueteMatematico;

/**
 *
 * @author sebastian
 */
public class Vector2D 
{
   public double x;
   public double y;
   public double w;
         
    public Vector2D(double x, double y,double w)
    {
        this.x = x;
        this.y = y;
        this.w = w;
    }
    
    public Vector2D normalizar()
    {
        double mag = magnitud();
        return new Vector2D(x/mag, y/mag,1);
    }
    
    public double magnitud()
    {
        return(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
    }
    
      public int mapearX(int w)
  {
      return ((int)x+w/2);
  }
  
  public int mapearY(int h)
  {
      return (h/2-(int)y);
  }
    
}
