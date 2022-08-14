
package com.portfolio.ldv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHabilidad;
    private int progresoHabilidad;
    
    @Size(min=1, max=100)
    private String typeHabilidad;

    public Habilidad() {
    }

    public Habilidad(String nombreHabilidad, int progresoHabilidad, String typeHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
        this.progresoHabilidad = progresoHabilidad;
        this.typeHabilidad = typeHabilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public int getProgresoHabilidad() {
        return progresoHabilidad;
    }

    public void setProgresoHabilidad(int progresoHabilidad) {
        this.progresoHabilidad = progresoHabilidad;
    }

    public String getTypeHabilidad() {
        return typeHabilidad;
    }

    public void setTypeHabilidad(String typeHabilidad) {
        this.typeHabilidad = typeHabilidad;
    }
    
    

}
