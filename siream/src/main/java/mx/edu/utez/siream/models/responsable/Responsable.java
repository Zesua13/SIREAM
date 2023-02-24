package mx.edu.utez.siream.models.responsable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.siream.models.account.Account;
import mx.edu.utez.siream.models.aspect.Aspect;

import javax.persistence.*;

@Entity
@Table(name = "responsables")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidoP;
    private String apelldioM;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Aspect aspect;
}
