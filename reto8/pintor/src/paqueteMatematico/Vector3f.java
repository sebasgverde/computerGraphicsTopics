/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteMatematico;

public class Vector3f {
    /**
     * Coordenada X
     */
    public float x;
    /**
     * Coordenada Y
     */
    public float y;
    /**
     * Coordenada X
     */
    public float z;
    
    /**
     * Constructor
     * @param x Coordenada X
     * @param y Coordenada Y
     * @param z Coordenada X
     */
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Constructor por defecto. Las coordenadas quedan en 0.
     */
    public Vector3f() {
        x = y = z = 0f;
    }
    
    /**
     * Retarna un nuevo vector, la suma de éste más el que se recibe como 
     * parámetro
     * @param v Nuevo vector para sumarle a éste.
     * @return Nuevo vector con la suma de éste más el que se recibe
     */
    public Vector3f sumar(Vector3f v) {
        return new Vector3f(x + v.x, y + v.y, z + v.z);
    }
    
    /**
     * Retorna un nuevo vector, la resta de éste menos el que se recibe
     * como parámetro
     * @param v Vector para restarle a éste
     * @return Nuevo vector con la resta de éste menos el que se recibe
     */
    public Vector3f restar(Vector3f v) {
        return new Vector3f(x - v.x, y - v.y, z - v.z);
    }
    

    /**
     * Retorna un nuevo vector que es la multiplicación escalar de éste por
     * un valor que se recibe como parámetro
     * @param s Valor escalar para multiplicar por este vector
     * @return Nuevo vector, éste por el valor escalar
     */
    public Vector3f multEscalar(float s) {
        float compX = x * s;
        float compY = y * s;
        float compZ = z * s;
        return new Vector3f(compX, compY, compZ);
    }
    
    /**
     * Retorna un nuevo vector que es el producto de este por otro que se
     * recibe como parámetro
     * @param v Vector para multiplicar por éste
     * @return Nuevo vector: este producto punto el que se recibe como parámetro
     */
    public float prodPunto(Vector3f v) {
        return x * v.x + y * v.y + z * v.z;
    }
    
    /**
     * Retorna un nuevo vector que es la multiplicación por componentes 
     * de éste con otro que se recibe como parámetro
     * @param v Vector para multiplicar por componentes
     * @return Nuevo vector: éste multiplicado por componentes con le que 
     * se recibe como parámetro
     */
    public Vector3f prodPorComponentes(Vector3f v) {
        return new Vector3f(x * v.x, y * v.y, z * v.z);
    }
    
    /**
     * Retorna un nuevo vector que es el producto cruz entre este y otro que
     * se recibe como parámetro
     * @param v Vector para multiplicar en producto cruz con éste
     * @return Nuevo vector: éste multiplicado en producto cruz con el que se
     * recibe como parámetro
     */
    public Vector3f prodCruz(Vector3f v) {
        float xComp = this.y * v.z - this.z * v.y;
        float yComp = -(this.x * v.z - this.z * v.x);
        float zComp = this.x * v.y - this.y * v.x;
        return new Vector3f(xComp, yComp, zComp);
    }
    
    /**
     * Retorna la magnitud del vector
     * @return Magnitud del vector
     */
    public float magnitud() {
        float ret = (float)Math.sqrt(x * x + y * y + z * z);
        return ret;
    }
    
    /**
     * Crea un nuevo vector normalizado
     * @return vector normalizado
     */
    public Vector3f normalizar() {
        float factor = 1f/this.magnitud();
        Vector3f ret = this.multEscalar(factor);
        return ret;
    }

    /**
     * Modifica los valores del vector para que estén entre 0 y 1
     * @return Vector modificado
     */
    public Vector3f trim() {
        float x1, y1, z1;
        if (x < 0) x1 = 0f; else x1 = x;
        if (y < 0) y1 = 0f; else y1 = y;
        if (z < 0) z1 = 0f; else z1 = z;
        if (x > 1) x1 = 1f; else x1 = x;
        if (y > 1) y1 = 1f; else y1 = y;
        if (z > 1) z1 = 1f; else z1 = z;
        return new Vector3f(x1, y1, z1);
    }
        
    
    /**
     * Método para imprimir el Vector3f
     * @return String con el valor a imprimir
     */
    @Override
    public String toString() {
        String s = "<" + x + "," + y + "," + z + ">";
        return s;
     }
    
    /**
     * Programa principal para probar
     * @param s parámetros
     */
    public static void main(String [] s) {
        Vector3f v1 = new Vector3f(1, 1, 1);
        Vector3f v2 = new Vector3f(1, 1, -1);
        Vector3f v3 = v1.prodCruz(v2);
        System.out.println(v3);
    }
}
