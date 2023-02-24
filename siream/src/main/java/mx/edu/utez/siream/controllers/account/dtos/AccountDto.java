package mx.edu.utez.siream.controllers.account.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.siream.models.account.Account;
import mx.edu.utez.siream.models.responsable.Responsable;
import mx.edu.utez.siream.models.role.Role;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AccountDto {
    private Long id;
    private String correo;
    private String password;
    private Role role;
    private Responsable responsable;

    public Account pasrseToAccount() {
        return new Account(
                getId(),
                getCorreo(),
                getPassword(),
                getRole(),
                getResponsable()
        );
    }
}
