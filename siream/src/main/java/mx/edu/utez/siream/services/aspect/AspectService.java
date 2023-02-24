package mx.edu.utez.siream.services.aspect;

import mx.edu.utez.siream.models.aspect.Aspect;
import mx.edu.utez.siream.models.aspect.AspectRepository;
import mx.edu.utez.siream.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class AspectService {
    @Autowired
    private AspectRepository repository;

    @Transactional(readOnly = true)
    public Response getAll() {
        return new Response<List<Aspect>>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response getOne(long id) {
        return new Response<Object>(
                this.repository.findById(id),
                false,
                200,
                "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response insert(Aspect aspect) {
        if (this.repository.existsByNombre(aspect.getNombre()))
            return new Response(
                    null,
                    true,
                    200,
                    "Ya existe este aspecto"
            );
        return new Response(
                this.repository.saveAndFlush(aspect),
                false,
                200,
                "Aspecto registrado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response update(Aspect aspect) {
        if (this.repository.existsById(aspect.getId()))
            return new Response(
                    this.repository.saveAndFlush(aspect),
                    false,
                    200,
                    "Aspecto actualizado correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este aspecto"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "Aspecto eliminado correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe este aspecto"
        );
    }
}
