package mx.edu.utez.siream.services.report;

import mx.edu.utez.siream.models.report.Report;
import mx.edu.utez.siream.models.report.ReportRepository;
import mx.edu.utez.siream.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ReportService {
    @Autowired
    private ReportRepository repository;

    @Transactional(readOnly = true)
    public Response getAll() {
        return new Response<List<Report>>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(readOnly = true)
    public Response getOne(long id) {
        return new Response<Object>(
                this.repository.findById(id),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(readOnly = true)
    public Response getAllByAspect(long aspect) {
        return new Response<List<Report>>(
                this.repository.findAllByAspect(aspect),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response insert(Report report) {
        return new Response(
                this.repository.saveAndFlush(report),
                false,
                200,
                "Resporte enviado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> update(Report report) {
        if (!this.repository.existsById(report.getId()))
            return new Response<>(
                    null,
                    true,
                    400,
                    "NO se encontro el reporte"
            );
        return new Response<>(
                this.repository.updateEstadoById(report.getEstado(), report.getId()),
                false,
                200,
                "Reporte actualizado correctamente"
        );
    }
}
