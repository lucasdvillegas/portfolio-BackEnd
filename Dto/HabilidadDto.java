
package com.portfolio.ldv.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class HabilidadDto {
    @NotBlank
    private String nombreHabilidad;
    @NotBlank
    private int progresoHabilidad;
    @NotBlank
    @Size(min=1, max=100)
    private String typeHabilidad;

    public HabilidadDto() {
    }

    public HabilidadDto(String nombreHabilidad, int progresoHabilidad, String typeHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
        this.progresoHabilidad = progresoHabilidad;
        this.typeHabilidad = typeHabilidad;
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
