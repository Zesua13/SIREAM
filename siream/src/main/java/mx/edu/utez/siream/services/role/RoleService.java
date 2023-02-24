package mx.edu.utez.siream.services.role;

import mx.edu.utez.siream.models.role.Role;
import mx.edu.utez.siream.models.role.RoleRepository;
import mx.edu.utez.siream.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public Response getAll() {
        return new Response<List<Role>>(
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

    public Response insert(Role role) {
        if (this.repository.existsByNombre(role.getNombre()))
            return new Response(
                    null,
                    true,
                    200,
                    "Ya existe esa rol"
            );
        return new Response(
                this.repository.saveAndFlush(role),
                false,
                200,
                "Rol registrado correctamente"
        );
    }

    public Response update(Role role) {
        if (this.repository.existsByNombre(role.getNombre()))
            return new Response(
                    this.repository.saveAndFlush(role),
                    false,
                    200,
                    "Rol actualizado correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe el rol indicado"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "Rol eliminado correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe el role indicado"
        );
    }
}
