package mx.edu.utez.siream.models.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.siream.models.aspect.Aspect;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reports")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String descripcion;
    @Column(nullable = false, length = 200)
    private String lugar;
    @Column(nullable = false, length = 200)
    private String ubicacion;
    private String image;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private Timestamp fecha;
    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "aspect_id", nullable = false)
    private Aspect aspect;
}