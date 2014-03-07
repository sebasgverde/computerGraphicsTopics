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
   public float x;
   public float y;
   public float z;
   public float w;
         
    public Vector3D(float x, float y,float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }
    
    public Vector3D normalizar()
    {
        float mag = magnitud();
        return new Vector3D(x/mag, y/mag, z/mag);
    }
    
    public float magnitud()
    {
        return((float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2)));
    }
}
