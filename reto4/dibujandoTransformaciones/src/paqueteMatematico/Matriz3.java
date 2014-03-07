/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteMatematico;


public class Matriz3 {
   public  float m11, m12, m13,m21, m22, m23,m31, m32, m33;
    public float [][] matriz;
    
    public Matriz3(float m11, float m12, float m13, float m21, float m22, float m23, float m31, float m32, float m33) {
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        matriz = new float [3][3];
        float [][] mat = {{m11, m12, m13},{m21, m22, m23},{m31, m32, m33}};
        matriz = mat;
    }
    
    public Matriz3(float [][] mat)
    {
        this.matriz = mat;
        this.m11 = matriz[0][0];
        this.m12 = matriz[0][1];
        this.m13 = matriz[0][2];
        this.m21 = matriz[1][0];
        this.m22 = matriz[1][1];
        this.m23 = matriz[1][2];
        this.m31 = matriz[2][0];
        this.m32 = matriz[2][1];
        this.m33 = matriz[2][2];
    }
    
    
        public Vector3D multVector(Vector3D v) {
        float compX = m11 * v.x + m12 * v.y + m13 * v.z;
        float compY = m21 * v.x + m22 * v.y + m23 * v.z;
        float compZ = m31 * v.x + m32 * v.y + m33 * v.z;
        return new Vector3D(compX, compY, compZ);
    }
        
        public Matriz3 mulMatMat3(Matriz3 m)
        {
            float [][] a = this.matriz;
            float [][] b = m.matriz;
           int aRows = 3,
               aColumns = 3,
               bRows = 3,
               bColumns = 3;

           float[][] resultant = new float[aRows][bColumns];

           for(int i = 0; i < aRows; i++) { // aRow
             for(int j = 0; j < bColumns; j++) { // bColumn
               for(int k = 0; k < aColumns; k++) { // aColumn
                 resultant[i][j] += a[i][k] * b[k][j];
               }
             }  
           }

           return new Matriz3(resultant); 
        }
        
    public Matriz3 multEscalar(float s) {
        float n11 = m11 * s;
        float n12 = m12 * s;
        float n13 = m13 * s;
        float n21 = m21 * s;
        float n22 = m22 * s;
        float n23 = m23 * s;
        float n31 = m31 * s;
        float n32 = m32 * s;
        float n33 = m33 * s;
        return new Matriz3(n11, n12, n13, n21, n22, n23, n31, n32, n33);
    }
    
    
         
}

