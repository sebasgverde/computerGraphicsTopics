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
   public float x;
   public float y;
   public float w;
         
    public Vector2D(float x, float y)
    {
        this.x = x;
        this.y = y;
        this.w = 1;
    }
    
    public Vector2D normalizar()
    {
        float mag = magnitud();
        return new Vector2D(x/mag, y/mag);
    }
    
    public float magnitud()
    {
        return((float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
    }
    
        public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getW() {
        return w;
    }
}
