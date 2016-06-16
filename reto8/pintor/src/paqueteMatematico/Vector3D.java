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
    
    public Vector3f cambiarA3F()
    {
        return new Vector3f((float)x, (float)y, (float)z);
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
        return(Math.sqrt(x*x+y*y+z*z));
    }
    
    public int mapearX(int w)
    {
        return ((int)x+w/2);
    }

    public int mapearY(int h)
    {
        return (h/2-(int)y);
    }
    
    public double prodEscalar(Vector3D v)
    {
        return (x * v.x + y * v.y + z * v.z);
    }
    
    public Vector3D prodCruz(Vector3D v) {
        double xComp = this.y * v.z - this.z * v.y;
        double yComp = -(this.x * v.z - this.z * v.x);
        double zComp = this.x * v.y - this.y * v.x;
        return new Vector3D(xComp, yComp, zComp,1);
    }
}
