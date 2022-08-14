
package com.portfolio.ldv.Dto;

import javax.validation.constraints.NotBlank;


public class SobreDto {
    @NotBlank
    private String sobreDescripcion;
    
    //constructores
    public SobreDto() {
    }

    public SobreDto(String sobreDescripcion) {
        this.sobreDescripcion = sobreDescripcion;
    }
    
    //metodos
    public String getSobreDescripcion() {
        return sobreDescripcion;
    }

    public void setSobreDescripcion(String sobreDescripcion) {
        this.sobreDescripcion = sobreDescripcion;
    }
    
    
}
