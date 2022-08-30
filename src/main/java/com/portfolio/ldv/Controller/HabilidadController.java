
package com.portfolio.ldv.Controller;

import com.portfolio.ldv.Dto.HabilidadDto;
import com.portfolio.ldv.Entity.Habilidad;
import com.portfolio.ldv.Security.Controller.Mensaje;
import com.portfolio.ldv.Service.ImpHabilidadService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidad")
@CrossOrigin(origins = "https://argprograma-frontendldv.web.app")
public class HabilidadController {
    @Autowired
    ImpHabilidadService habilidadService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list(){
        List<Habilidad> list = habilidadService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id){
        if(!habilidadService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        
        Habilidad habilidad = habilidadService.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!habilidadService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        habilidadService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HabilidadDto habilidadDto){
        if(StringUtils.isBlank(habilidadDto.getNombreHabilidad())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(habilidadService.existsByNombreHabilidad(habilidadDto.getNombreHabilidad())){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        Habilidad habilidad = new Habilidad(
                habilidadDto.getNombreHabilidad(), habilidadDto.getProgresoHabilidad(), habilidadDto.getTypeHabilidad()
        );
        habilidadService.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }  
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabilidadDto habilidadDto){
        
        //validaciones 
        if(!habilidadService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        
        if(habilidadService.existsByNombreHabilidad(habilidadDto.getNombreHabilidad()) && habilidadService.getByNombreHabilidad(habilidadDto.getNombreHabilidad()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(habilidadDto.getNombreHabilidad())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        
        Habilidad habilidad = habilidadService.getOne(id).get();
        
        habilidad.setNombreHabilidad(habilidadDto.getNombreHabilidad());
        habilidad.setProgresoHabilidad(habilidadDto.getProgresoHabilidad());
        habilidad.setTypeHabilidad(habilidadDto.getTypeHabilidad());

        
        habilidadService.save(habilidad);
        
        
        
        return new ResponseEntity(new Mensaje("habilidad actualizada"), HttpStatus.OK);
    }
}
