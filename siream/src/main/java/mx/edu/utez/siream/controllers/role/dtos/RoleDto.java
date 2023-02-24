package mx.edu.utez.siream.controllers.role.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.siream.models.account.Account;
import mx.edu.utez.siream.models.role.Role;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoleDto {
    private Long id;
    private String nombre;
    private Account account;

    public Role parseToRole(){
        return new Role(
                getId(),
                getNombre(),
                getAccount()
        );
    }
}
