package mx.edu.utez.siream.models.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    boolean existsById(Long id);
    @Query(value = "SELECT * FROM reports WHERE aspect_id = :aspect_id ;", nativeQuery = true)
    List<Report> findAllByAspect(long aspect_id);
    @Query(value = "UPDATE reports SET estado = :estado WHERE id = :id ;", nativeQuery = true)
    boolean updateEstadoById(@Param("estado") Boolean status, @Param("id") Long id);
}
