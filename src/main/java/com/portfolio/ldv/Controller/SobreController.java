
package com.portfolio.ldv.Controller;

import com.portfolio.ldv.Dto.SobreDto;
import com.portfolio.ldv.Entity.Sobre;
import com.portfolio.ldv.Security.Controller.Mensaje;
import com.portfolio.ldv.Service.ImpSobreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sobre")
@CrossOrigin(origins = "https://argprograma-frontendldv.web.app")
public class SobreController {
    @Autowired
    ImpSobreService sobreService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Sobre>> list(){
        List<Sobre> list = sobreService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/traer/{id}")
    public ResponseEntity<Sobre> traerId(@PathVariable int id){
        Sobre sobre = sobreService.getOne(id);
        return new ResponseEntity(sobre, HttpStatus.OK);
    } 
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SobreDto sobreDto){
        Sobre sobre = new Sobre(
                sobreDto.getSobreDescripcion()        
        );
        
        System.out.println("qué está pasando acá " + sobre.getDescripcionSobre());
        sobreService.save(sobre);
        
        return new ResponseEntity(new Mensaje("descripcion creada"), HttpStatus.OK);
    } 
    
   
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Sobre sobreUpdate){
        
        Sobre sobre = sobreService.getOne(id);
        
        sobre = sobreUpdate;
        
        
        sobreService.save(sobre);
        
        
        return new ResponseEntity(new Mensaje("descripcion actualizada"), HttpStatus.OK);
    }
}
