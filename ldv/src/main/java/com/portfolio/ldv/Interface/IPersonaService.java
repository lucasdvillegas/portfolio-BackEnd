
package com.portfolio.ldv.Interface;

import com.portfolio.ldv.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> getPersona();
    
    //Guardar persona
    public void savePersona(Persona persona);
    
    //Eliminar persona
    public void deletePersona(Long id);
    
    //Buscar persona
    public Persona findPersona(Long id);
    
}
