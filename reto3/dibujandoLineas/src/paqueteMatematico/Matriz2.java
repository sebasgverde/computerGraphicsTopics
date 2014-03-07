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
public class Matriz2 {
    float m11, m12,m21, m22;
    public float [][] matriz;
    
    public Matriz2(float m11, float m12, float m21, float m22) {
        this.m11 = m11;
        this.m12 = m12;
        this.m21 = m21;
        this.m22 = m22;
        matriz = new float [2][2];
        float [][] mat = {{m11, m12},{m21, m22}};
        matriz = mat;
    }
    
        public Matriz2(float [][] mat)
    {
        this.matriz = mat;
        this.m11 = matriz[0][0];
        this.m12 = matriz[0][1];
        this.m21 = matriz[1][0];
        this.m22 = matriz[1][1];
    }
    
        public Matriz2 mulMatMat2(Matriz2 m)
        {
            float [][] a = this.matriz;
            float [][] b = m.matriz;
           int aRows = 2,
               aColumns = 2,
               bRows = 2,
               bColumns = 2;

           float[][] resultant = new float[aRows][bColumns];

           for(int i = 0; i < aRows; i++) { // aRow
             for(int j = 0; j < bColumns; j++) { // bColumn
               for(int k = 0; k < aColumns; k++) { // aColumn
                 resultant[i][j] += a[i][k] * b[k][j];
               }
             }  
           }

           return new Matriz2(resultant); 
        }
    
        public Vector2D multVector(Vector2D v) {
        float compX = m11 * v.x + m12 * v.y;
        float compY = m21 * v.x + m22 * v.y ;
        return new Vector2D(compX, compY);
    }
        
        
    public Matriz2 multEscalar(float s) {
        float n11 = m11 * s;
        float n12 = m12 * s;
        float n21 = m21 * s;
        float n22 = m22 * s;
        return new Matriz2(n11, n12, n21, n22);
    }
    
    
         
}

