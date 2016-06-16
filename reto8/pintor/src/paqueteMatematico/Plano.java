/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteMatematico;

public class Plano {
    float a;
    float b;
    float c;
    float d;
    
    Vector3f p0;
    Vector3f p1;
    Vector3f p2;

    /**
     * 
     * @param p0
     * @param p1
     * @param p2
     */
    public Plano(Vector3f p0, Vector3f p1, Vector3f p2) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        
        Vector3f v1 = p1.restar(p0);
        Vector3f v2 = p2.restar(p0);
        
        Vector3f n = v1.prodCruz(v2);
        a = n.x;
        b = n.y;
        c = n.z;
        
        d = - (a * p0.x + b * p0.y + c * p0.z);
    }
    
    /**
     * 
     * @param punto
     * @return
     */
    public float evaluarPunto(Vector3f punto) {
        float ret = a * punto.x + b * punto.y + c * punto.z + d;
        return ret;
    }
    
    /**
     * 
     * @return
     */
    public String toString() {
        String s = "a, b, c, d: " + a + "," + b + "," + c + "," + d;
        return s;
    }
   

    /**
     * 
     * @return
     */
    public float getA() {
        return a;
    }

    /**
     * 
     * @return
     */
    public float getB() {
        return b;
    }

    /**
     * 
     * @return
     */
    public float getC() {
        return c;
    }

    /**
     * 
     * @return
     */
    public float getD() {
        return d;
    }
    
    /**
     * 
     * @return
     */
    public Vector3f getNormal() {
        return new Vector3f(a, b, c);
    }

}
