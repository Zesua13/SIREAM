package mx.edu.utez.siream.controllers.report.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.siream.models.aspect.Aspect;
import mx.edu.utez.siream.models.report.Report;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReportDto {
    private Long id;
    private String descripcion;
    private String lugar;
    private String ubicacion;
    private String image;
    @NotEmpty
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    private String correo;
    private Timestamp fecha;
    private Boolean estado;
    private Aspect aspect;

    public Report parseToReport() {
        return new Report(
                getId(),
                getDescripcion(),
                getLugar(),
                getUbicacion(),
                getImage(),
                getCorreo(),
                getFecha(),
                getEstado(),
                getAspect()
        );
    }
}
