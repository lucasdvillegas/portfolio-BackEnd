
package com.portfolio.ldv.Service;

import com.portfolio.ldv.Entity.Proyecto;
import com.portfolio.ldv.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService {
    @Autowired
    ProyectoRepository proyectoRepository;
    
    public List<Proyecto> list() {
        return proyectoRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(int id) {
        return proyectoRepository.findById(id);
    }

    public Optional<Proyecto> getByNombreProyecto(String nombreProyecto) {
        return proyectoRepository.findByNombreProyecto(nombreProyecto);
    }

    public void save(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    public void delete(int id) {
        proyectoRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return proyectoRepository.existsById(id);
    }

    public boolean existsByNombreProyecto(String nombreProyecto) {
        return proyectoRepository.existsByNombreProyecto(nombreProyecto);
    }
}
