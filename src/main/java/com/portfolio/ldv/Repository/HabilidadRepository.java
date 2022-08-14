
package com.portfolio.ldv.Repository;

import com.portfolio.ldv.Entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer> {
    public Optional<Habilidad> findByNombreHabilidad(String nombreHabilidad);
    public boolean existsByNombreHabilidad(String nombreHabilidad);
}
