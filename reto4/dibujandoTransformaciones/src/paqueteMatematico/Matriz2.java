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
    public double [][] matriz;
       
        public Matriz2(double [][] mat)
    {
        this.matriz = mat;
    }
    
            
    public Matriz2(double m11, double m12, double m21, double m22) {
 
        matriz = new double [3][3];
        double [][] mat = {{m11, m12,0},{m21, m22,0},{0,0,1}};
        matriz = mat;
    }
    
        public Matriz2 mulMatMat2(Matriz2 m)
        {
            double [][] a = this.matriz;
            double [][] b = m.matriz;
           int aRows = 3,
               aColumns = 3,
               bRows = 3,
               bColumns = 3;

           double [][] resultant = new double[aRows][bColumns];

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
        double compX = matriz[0][0] * v.x + matriz[0][1] * v.y + matriz[0][2]*v.w;
        double compY = matriz[1][0] * v.x + matriz[1][1] * v.y + matriz[1][2]*v.w;
        double compW = matriz[2][0] * v.x + matriz[2][1] * v.y + matriz[2][2]*v.w;
    
        return new Vector2D(compX, compY,compW);
    }
        
        public Matriz2 rotation(double theta)
        {
            double cosT = Math.cos(theta);
            double senT = Math.sin(theta);
            
            double [][] matRot = {{cosT,-1*senT,0},{senT,cosT,0},{0,0,1}};
            
            return (new Matriz2(matRot));
        }
        
        public Matriz2 translate(int x,int y)
        {
            double [][] matTrans = {{1,0,x},{0,1,y},{0,0,1}};
            
            return (new Matriz2(matTrans));

        }
        
        public Matriz2 scale(double x, double y)
        {
            double [][] matTrans = {{x,0,0},{0,y,0},{0,0,1}};
            
            return (new Matriz2(matTrans));
        }
        
    
    
         
}

