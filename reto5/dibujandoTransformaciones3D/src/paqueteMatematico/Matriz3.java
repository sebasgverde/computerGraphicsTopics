/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteMatematico;


public class Matriz3 {
    public double [][] matriz;
    
    public Matriz3(double [][] mat)
    {
        this.matriz = mat;
    }
    
    public Matriz3(double m11, double m12, double m13, double m21, double m22, double m23, double m31, double m32, double m33) {
        matriz = new double [4][4];
        double [][] mat = {{m11, m12, m13,0},{m21, m22, m23,0},{m31, m32, m33,0},{0,0,0,1}};
        matriz = mat;
    }
    
    
        public Vector3D multVector(Vector3D v) {
        double compX = matriz[0][0] * v.x + matriz[0][1] * v.y + matriz[0][2]*v.z + matriz[0][3]*v.w;
        double compY = matriz[1][0] * v.x + matriz[1][1] * v.y + matriz[1][2]*v.z + matriz[1][3]*v.w;
        double compZ = matriz[2][0] * v.x + matriz[2][1] * v.y + matriz[2][2]*v.z + matriz[2][3]*v.w;
        double compW = matriz[3][0] * v.x + matriz[3][1] * v.y + matriz[3][2]*v.z + matriz[3][3]*v.w;
        
        return new Vector3D(compX, compY, compZ, compW);
    }
        
        public Matriz3 mulMatMat3(Matriz3 m)
        {
            double [][] a = this.matriz;
            double [][] b = m.matriz;
           int aRows = 4,
               aColumns = 4,
               bRows = 4,
               bColumns = 4;

           double[][] resultant = new double[aRows][bColumns];

           for(int i = 0; i < aRows; i++) { // aRow
             for(int j = 0; j < bColumns; j++) { // bColumn
               for(int k = 0; k < aColumns; k++) { // aColumn
                 resultant[i][j] += a[i][k] * b[k][j];
               }
             }  
           }

           return new Matriz3(resultant); 
        } 
        
        public Matriz3 perspectiva(double d)
        {
            double [][] matPers = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,1/d,0}};
            return (new Matriz3(matPers));
        }
        
        public Matriz3 rotationX(double theta)
        {
            double cosT = Math.cos(theta);
            double senT = Math.sin(theta);
            
            double [][] matRot = {{1,0,0,0},{0,cosT,-1*senT,0},{0,senT,cosT,0},{0,0,0,1}};
            
            return (new Matriz3(matRot));
        }
        
        public Matriz3 rotationY(double theta)
        {
            double cosT = Math.cos(theta);
            double senT = Math.sin(theta);
            
            double [][] matRot = {{cosT,0,senT,0},{0,1,0,0},{-1*senT,0,cosT,0},{0,0,0,1}};
            
            return (new Matriz3(matRot));
        }
                
        public Matriz3 rotationZ(double theta)
        {
            double cosT = Math.cos(theta);
            double senT = Math.sin(theta);
            
            double [][] matRot = {{cosT,-1*senT,0,0},{senT,cosT,0,0},{0,0,1,0},{0,0,0,1}};
            
            return (new Matriz3(matRot));
        }
        
        public Matriz3 translate(int x,int y,int z)
        {
            double [][] matTrans = {{1,0,0,x},{0,1,0,y},{0,0,1,z},{0,0,0,1}};
            
            return (new Matriz3(matTrans));

        }
        
        public Matriz3 scale(double x, double y, double z)
        {
            double [][] matTrans = {{x,0,0,0},{0,y,0,0},{0,0,z,0},{0,0,0,1}};
            
            return (new Matriz3(matTrans));
        }
}

