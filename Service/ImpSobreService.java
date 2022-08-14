
package com.portfolio.ldv.Service;

import com.portfolio.ldv.Entity.Sobre;
import com.portfolio.ldv.Repository.SobreRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpSobreService {
    @Autowired
    SobreRepository sobreRepository;
    
    public List<Sobre> list(){
        return sobreRepository.findAll();
    }
    
    public Sobre getOne(int id){
        return sobreRepository.findById(id).orElse(null);
    }
    
    public Optional<Sobre> getByDescripcionsobre(String descripcionSobre){
        return sobreRepository.findByDescripcionSobre(descripcionSobre);
    }
    
    public void save(Sobre sobre){
        sobreRepository.save(sobre);
    }
    
    public void delete(int id){
        sobreRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return sobreRepository.existsById(id);
    }
    
    public boolean existsByDescripcionSobre(String descripcionSobre){
        return sobreRepository.existsByDescripcionSobre(descripcionSobre);
    }
}
