package mx.edu.utez.siream.services.responsable;

import mx.edu.utez.siream.models.account.Account;
import mx.edu.utez.siream.models.responsable.Responsable;
import mx.edu.utez.siream.models.responsable.ResponsableRepository;
import mx.edu.utez.siream.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResponsableService {
    @Autowired
    private ResponsableRepository repository;

    public Response getAll() {
        return new Response<List<Responsable>>(
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

    public Response insert(Responsable responsable) {
        if (this.repository.existsByNombre(responsable.getNombre()))
            return new Response(
                    null,
                    true,
                    200,
                    "Ya existe este responsable"
            );
        return new Response(
                this.repository.saveAndFlush(responsable),
                false,
                200,
                "Responsable registrado correctamente"
        );
    }

    public Response update(Responsable responsable) {
        if (this.repository.existsByNombre(responsable.getNombre()))
            return new Response(
                    this.repository.saveAndFlush(responsable),
                    false,
                    200,
                    "Responsable actualizado correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe el responsable indicada"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "Responsable eliminado correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe el responsable indicada"
        );
    }
}
