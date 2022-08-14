
package com.portfolio.ldv.Service;

import com.portfolio.ldv.Entity.Educacion;
import com.portfolio.ldv.Repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService {
    @Autowired
    EducacionRepository educacionRepository;
    
    public List<Educacion> list(){
        return educacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return educacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombreEducacion(String nombreEducacion){
        return educacionRepository.findByNombreEducacion(nombreEducacion);
    }
    
    public void save(Educacion educacion){
        educacionRepository.save(educacion);
    }
    
    public void delete(int id){
        educacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    }
    
    public boolean existsByNombreEducacion(String nombreEducacion){
        return educacionRepository.existsByNombreEducacion(nombreEducacion);
    }
    
    
    
}
