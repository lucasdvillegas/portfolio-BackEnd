
package com.portfolio.ldv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Sobre {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id = 1;
    @Size(min=1, max=500)
    private String descripcionSobre;

    public Sobre() {
    }

    public Sobre(String descripcionSobre) {
        this.descripcionSobre = descripcionSobre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionSobre() {
        return descripcionSobre;
    }

    public void setDescripcionSobre(String descripcionSobre) {
        this.descripcionSobre = descripcionSobre;
    }
 
    
}
