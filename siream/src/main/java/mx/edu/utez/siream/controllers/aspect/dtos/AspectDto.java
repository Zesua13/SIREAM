package mx.edu.utez.siream.controllers.aspect.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.siream.models.aspect.Aspect;
import mx.edu.utez.siream.models.report.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AspectDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String image;
    private String estado;
    private Set<Report> report;

    public Aspect parseToAspect() {
        return new Aspect(
                getId(),
                getNombre(),
                getDescripcion(),
                getImage(),
                getEstado(),
                getReport()
        );
    }
}
