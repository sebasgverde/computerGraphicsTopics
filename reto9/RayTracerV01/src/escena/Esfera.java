package escena;

import java.util.Vector;

/**
 *
 * @author LABREDES
 */
public class Esfera extends Entidad{
    Punto centro;
    double radio;

    public Esfera(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }
    
    public Color colorRayTracing(Escena esc, Punto inters)
    {
        MiVector normal = new MiVector(centro, inters).normalizar();
        MiVector l = new MiVector(inters,new Punto(10d, 10d, 10d)).normalizar();
        MiVector V = new MiVector(inters,new Punto(0d,0d,0d)).normalizar();
        MiVector R = l.resta(normal.multEscalar(2*(l.productoPunto(normal)))).normalizar();
        
        double rojo = esc.getColor(2).r *esc.getMaterial(0).ka * this.color.r +
                esc.getColor(1).r *(esc.getMaterial(0).kd * this.color.r * (normal.productoPunto(l)) +
                                  esc.getMaterial(0).ks * Math.pow((R.productoPunto(V)),esc.getMaterial(0).n));
        double verde = esc.getColor(2).g *esc.getMaterial(0).ka * this.color.g +
                esc.getColor(1).g *(esc.getMaterial(0).kd * this.color.g * (normal.productoPunto(l)) +
                                  esc.getMaterial(0).ks * Math.pow((R.productoPunto(V)),esc.getMaterial(0).n));
        double azul = esc.getColor(2).b *esc.getMaterial(0).ka * this.color.b +
                esc.getColor(1).b *(esc.getMaterial(0).kd * this.color.b * (normal.productoPunto(l)) +
                                  esc.getMaterial(0).ks * Math.pow((R.productoPunto(V)),esc.getMaterial(0).n));
        return new Color(rojo, verde, azul);
    }

    @Override
    public String toString() {
        return "Esfera{" + "centro=" + centro + "radio=" + radio + '}';
    }


}

