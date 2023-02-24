package mx.edu.utez.siream.controllers.responsable.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.siream.models.account.Account;
import mx.edu.utez.siream.models.aspect.Aspect;
import mx.edu.utez.siream.models.responsable.Responsable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResponsableDto {
    private Long id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Account account;
    private Aspect aspect;

    public Responsable parseToResponpaseble() {
        return new Responsable(
                getId(),
                getNombre(),
                getApellidoP(),
                getApellidoM(),
                getAccount(),
                getAspect()
        );
    }
}
