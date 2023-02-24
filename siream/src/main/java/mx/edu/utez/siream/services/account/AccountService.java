package mx.edu.utez.siream.services.account;

import mx.edu.utez.siream.models.account.Account;
import mx.edu.utez.siream.models.account.AccountRepository;
import mx.edu.utez.siream.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Response getAll() {
        return new Response<List<Account>>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }

    public Response getOne(long id) {
        return new Response<Object>(
                this.repository.findById(id),
                false,
                200,
                "Ok"
        );
    }

    public Response insert(Account account) {
        if (this.repository.existsByCorreo(account.getCorreo()))
            return new Response(
                    null,
                    true,
                    200,
                    "Ya existe esa cuenta"
            );
        return new Response(
                this.repository.saveAndFlush(account),
                false,
                200,
                "Cuenta registrada correctamente"
        );
    }

    public Response update(Account account) {
        if (this.repository.existsByCorreo(account.getCorreo()))
            return new Response(
                    this.repository.saveAndFlush(account),
                    false,
                    200,
                    "Cuenta actualizada correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe la cuenta indicada"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "Cuenta eliminada correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe la cuenta indicada"
        );
    }
}
