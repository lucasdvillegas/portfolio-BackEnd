
package com.portfolio.ldv.Controller;

import com.portfolio.ldv.Entity.Persona;
import com.portfolio.ldv.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://argprograma-frontendldv.web.app")
public class PersonaController {
    
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/create")
    public String findPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada";
    }
    
    @DeleteMapping("/personas/delete/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue borrada";
    }
    
    //Trae los datos de la persona y los cambia
    @PutMapping("/personas/update/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestBody Persona person){
        
        
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(person.getNombre());
        persona.setApellido(person.getApellido());
        persona.setImg(person.getImg());
        persona.setImgBack(person.getImgBack());
        persona.setTitulo(person.getTitulo());
        persona.setUbicacion(person.getUbicacion());
        persona.setGitLink(person.getGitLink());
        persona.setLinLink(person.getLinLink());
   
        
        ipersonaService.savePersona(persona);
        return persona;
 
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    
}
