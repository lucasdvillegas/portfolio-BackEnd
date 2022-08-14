
package com.portfolio.ldv.Dto;

import javax.validation.constraints.NotBlank;


public class EducacionDto {
    @NotBlank
    private String nombreEducacion;
    @NotBlank
    private String descripcionEducacion;
    @NotBlank
    private String fechaIngreso;
    @NotBlank
    private String fechaEgreso;

    public EducacionDto() {
    }

    public EducacionDto(String nombreEducacion, String descripcionEducacion, String fechaIngreso, String fechaEgreso) {
        this.nombreEducacion = nombreEducacion;
        this.descripcionEducacion = descripcionEducacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
    }

    public String getNombreEducacion() {
        return nombreEducacion;
    }

    public void setNombreEducacion(String nombreEducacion) {
        this.nombreEducacion = nombreEducacion;
    }

    public String getDescripcionEducacion() {
        return descripcionEducacion;
    }

    public void setDescripcionEducacion(String descripcionEducacion) {
        this.descripcionEducacion = descripcionEducacion;
    }

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
