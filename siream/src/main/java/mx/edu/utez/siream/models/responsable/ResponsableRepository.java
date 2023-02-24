package mx.edu.utez.siream.models.responsable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long> {
    boolean existsByNombre(String nombre);
}
