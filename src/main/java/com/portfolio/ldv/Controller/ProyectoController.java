
package com.portfolio.ldv.Controller;

import com.portfolio.ldv.Dto.ProyectoDto;
import com.portfolio.ldv.Entity.Proyecto;
import com.portfolio.ldv.Security.Controller.Mensaje;
import com.portfolio.ldv.Service.ImpProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://argprograma-frontendldv.web.app")
public class ProyectoController {
    @Autowired
    ImpProyectoService proyectoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto){
        if(StringUtils.isBlank(proyectoDto.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(proyectoService.existsByNombreProyecto(proyectoDto.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(
                proyectoDto.getNombreProyecto(), proyectoDto.getDescripcionProyecto(),
                proyectoDto.getImagenProyecto(), proyectoDto.getLinkProyecto()
                
        );
        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    } 
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDto proyectoDto){
        
        //validaciones 
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        
        if(proyectoService.existsByNombreProyecto(proyectoDto.getNombreProyecto()) && proyectoService.getByNombreProyecto(proyectoDto.getNombreProyecto()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(proyectoDto.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        
        proyecto.setNombreProyecto(proyectoDto.getNombreProyecto());
        proyecto.setDescripcionProyecto(proyectoDto.getDescripcionProyecto());
        proyecto.setImagenProyecto(proyectoDto.getImagenProyecto());
        proyecto.setLinkProyecto(proyectoDto.getLinkProyecto());
        
        proyectoService.save(proyecto);
       
        
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
    }
}
