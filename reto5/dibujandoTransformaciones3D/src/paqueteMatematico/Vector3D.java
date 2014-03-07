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
public class Vector3D {
   public double x;
   public double y;
   public double z;
   public double w;
         
    public Vector3D(double x, double y,double z,double w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    public Vector3D normalizar()
    {
        double mag = magnitud();
        return new Vector3D(x/mag, y/mag, z/mag,1);
    }
    
    public Vector3D normalizarW()
    {
        return new Vector3D(x/w, y/w, z/w,1);
    }
    
    public double magnitud()
    {
        return(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2)));
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
