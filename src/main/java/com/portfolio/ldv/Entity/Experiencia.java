
package com.portfolio.ldv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    
    //Fechas de ingreso y egreso
    private String fechaIngreso;
    private String fechaEgreso;
    
    //Constructores

    public Experiencia() {
    }

    //public Experiencia(String nombreE, String descripcionE) {
    //    this.nombreE = nombreE;
    //    this.descripcionE = descripcionE;
    //}

    public Experiencia(String nombreE, String descripcionE, String fechaIngreso, String fechaEgreso) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
    }

    

    
    
    
    
    //Setters and Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    //Getters a Setters de ingreso y egreso
    
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
    
    
    
}
