/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteMatematico;


public class Rayo {
    Vector3D comienzo;
    Vector3D fin;

    public Rayo(Vector3D comienzo, Vector3D fin) {
        this.comienzo = comienzo;
        this.fin = fin;
    }


    public Vector3D retornarPunto(float s) {
        double x = comienzo.x + s * (fin.x - comienzo.x);
        double y = comienzo.y + s * (fin.y - comienzo.y);
        double z = comienzo.z + s * (fin.z - comienzo.z);
        return new Vector3D(x, y, z,1);
    }

    /**
     * 
     * @return
     */
    public Vector3D getComienzo() {
        return comienzo;
    }

    /**
     * 
     * @return
     */
    public Vector3D getFin() {
        return fin;
    }
    

}
