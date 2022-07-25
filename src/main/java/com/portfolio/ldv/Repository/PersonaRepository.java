
package com.portfolio.ldv.Repository;

import com.portfolio.ldv.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    
    
}
