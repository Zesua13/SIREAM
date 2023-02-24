package mx.edu.utez.siream.models.aspect;

import lombok.*;
import mx.edu.utez.siream.models.report.Report;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "aspects")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Aspect{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String images;
    private String estado;
    @OneToMany(mappedBy = "aspect")
    private Set<Report> reports;
}
