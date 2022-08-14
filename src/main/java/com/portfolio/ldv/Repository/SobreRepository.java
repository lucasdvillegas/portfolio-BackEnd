
package com.portfolio.ldv.Repository;


import com.portfolio.ldv.Entity.Sobre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobreRepository extends JpaRepository<Sobre, Integer>{
    public Optional<Sobre> findByDescripcionSobre(String descripcionSobre);
    public boolean existsByDescripcionSobre(String descripcionSobre);
}
