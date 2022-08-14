
package com.portfolio.ldv.Dto;

import javax.validation.constraints.NotBlank;


public class ProyectoDto {
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descripcionProyecto;
    @NotBlank
    private String imagenProyecto;
    @NotBlank
    private String linkProyecto;

    public ProyectoDto() {
    }

    public ProyectoDto(String nombreProyecto, String descripcionProyecto, String imagenProyecto, String linkProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.imagenProyecto = imagenProyecto;
        this.linkProyecto = linkProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getImagenProyecto() {
        return imagenProyecto;
    }

    public void setImagenProyecto(String imagenProyecto) {
        this.imagenProyecto = imagenProyecto;
    }

    public String getLinkProyecto() {
        return linkProyecto;
    }

    public void setLinkProyecto(String linkProyecto) {
        this.linkProyecto = linkProyecto;
    }
    
    
}
