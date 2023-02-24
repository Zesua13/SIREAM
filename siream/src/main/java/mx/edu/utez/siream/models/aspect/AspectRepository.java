package mx.edu.utez.siream.models.aspect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspectRepository extends JpaRepository<Aspect, Long> {
    boolean existsByNombre(String nombre);
}
