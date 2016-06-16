package escena;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author htrefftz
 */

import java.util.ArrayList;

public class Escena {

    private ArrayList<Entidad> arrayEntidades;
    private ArrayList<Color> arrayColores;
    private ArrayList<Material> arrayMateriales;
    private boolean DEBUG = true;
    private Color colorBackground = new Color(0.1, 0.1, 0.9);

    public Escena() {
        arrayEntidades = new ArrayList<Entidad>();
        arrayColores = new ArrayList<Color>();
        arrayMateriales = new ArrayList<Material>();
    }

    public void addEntidad(Entidad entidad) {
        arrayEntidades.add(entidad);
        if (DEBUG) System.out.println("Escena: addEntidad " + entidad);
    }

    public void addColor(Color color) {
        arrayColores.add(color);
        if (DEBUG) System.out.println("Escena: addColor " + color);
    }
    
    public void addMaterial(Material material) {
        arrayMateriales.add(material);
        if (DEBUG) System.out.println("Escena: addMaterial " + material);
    }

    public Color getColor(int i) {
        return arrayColores.get(i);
    }

    public Material getMaterial(int i) {
        return arrayMateriales.get(i);
    }

    public Color intersectarRayo(Rayo rayo) {
        double t = Double.MAX_VALUE;
        Color color = colorBackground;
        for(Entidad entidad: arrayEntidades) {
            if(entidad instanceof Esfera) {
                Solucion solucion = rayo.interseccionEsfera((Esfera)entidad);
                //if (DEBUG) System.out.println(solucion);
                if(solucion.getNumRespuestas() == Solucion.NO_HAY_SOLUCION) {

                } else if (solucion.getNumRespuestas() == Solucion.UNA_SOLUCION) {
                    if(solucion.getT0() < t) {
                        t = solucion.getT0();
                        color = ((Esfera)entidad).colorRayTracing(this, rayo.evaluar(t));
                        //color = ((Esfera)entidad).color;
                    }
                } else if (solucion.getNumRespuestas() == Solucion.DOS_SOLUCIONES) {
                    if(solucion.getT0() < t) {
                        t = solucion.getT0();
                        color = ((Esfera)entidad).colorRayTracing(this, rayo.evaluar(t));
                        //color = ((Esfera)entidad).color;
                    }
                }
            } else if (entidad instanceof Plano) {
                Solucion solucion = rayo.interseccionPlano((Plano)entidad);
            }
        }
        return color;
    }
}
