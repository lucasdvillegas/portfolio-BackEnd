package com.portfolio.ldv.Service;

import com.portfolio.ldv.Entity.Habilidad;
import com.portfolio.ldv.Repository.HabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpHabilidadService {

    @Autowired
    HabilidadRepository habilidadRepository;

    public List<Habilidad> list() {
        return habilidadRepository.findAll();
    }

    public Optional<Habilidad> getOne(int id) {
        return habilidadRepository.findById(id);
    }

    public Optional<Habilidad> getByNombreHabilidad(String nombreHabilidad) {
        return habilidadRepository.findByNombreHabilidad(nombreHabilidad);
    }

    public void save(Habilidad habilidad) {
        habilidadRepository.save(habilidad);
    }

    public void delete(int id) {
        habilidadRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return habilidadRepository.existsById(id);
    }

    public boolean existsByNombreHabilidad(String nombreHabilidad) {
        return habilidadRepository.existsByNombreHabilidad(nombreHabilidad);
    }
}
