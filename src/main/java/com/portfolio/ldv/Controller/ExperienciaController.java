
package com.portfolio.ldv.Controller;

import com.portfolio.ldv.Dto.ExperienciaDto;
import com.portfolio.ldv.Entity.Experiencia;
import com.portfolio.ldv.Security.Controller.Mensaje;
import com.portfolio.ldv.Service.ImpExperienciaService;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "https://argprograma-frontendldv.web.app")
public class ExperienciaController {
    @Autowired
    ImpExperienciaService experienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto expDto){
        if(StringUtils.isBlank(expDto.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(experienciaService.existsByNombreE(expDto.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        //Se le agregaron las fechas de ingreso y egreso
        Experiencia experiencia = new Experiencia(expDto.getNombreE(), expDto.getDescripcionE(), expDto.getFechaIngreso(), expDto.getFechaEgreso());
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto expDto){
        
        //Se valida si el ID existe o no
        if(!experienciaService.existsById(id))
             return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara las experiencias agregadas con la ya existentes
        if(experienciaService.existsByNombreE(expDto.getNombreE()) && experienciaService.getByNombreE(expDto.getNombreE()).get().getId()!= id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //El nombre no puede estar vacío
        if(StringUtils.isBlank(expDto.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreE(expDto.getNombreE());
        experiencia.setDescripcionE(expDto.getDescripcionE());
        experiencia.setFechaIngreso(expDto.getFechaIngreso());
        experiencia.setFechaEgreso(expDto.getFechaEgreso());
        
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
             return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        experienciaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    
}
