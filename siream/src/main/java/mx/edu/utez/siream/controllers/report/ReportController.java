package mx.edu.utez.siream.controllers.report;

import mx.edu.utez.siream.controllers.report.dtos.ReportDto;
import mx.edu.utez.siream.services.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-siream/report")
@CrossOrigin(origins = {"*"})
public class ReportController {
    @Autowired
    private ReportService service;

    @GetMapping("/")
    public ResponseEntity getAll() {
        return new ResponseEntity(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/aspect/{id}")
    public ResponseEntity getAllByAspect(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(
                this.service.getAllByAspect(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity save(
            @RequestBody ReportDto report
    ) {
        return new ResponseEntity(
                this.service.insert(report.parseToReport()),
                HttpStatus.CREATED
        );
    }
}
