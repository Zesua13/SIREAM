package mx.edu.utez.siream.controllers.responsable;

import mx.edu.utez.siream.controllers.responsable.dtos.ResponsableDto;
import mx.edu.utez.siream.services.responsable.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-siream/responsable")
@CrossOrigin(origins = {"*"})
public class ResponsableController {
    @Autowired
    private ResponsableService service;

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

    @PostMapping("/")
    public ResponseEntity save(
            @RequestBody ResponsableDto responsable
            ) {
        return new ResponseEntity(
                this.service.insert(responsable.parseToResponpaseble()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity update(
            @RequestBody ResponsableDto responsable
    ) {
        return new ResponseEntity(
                this.service.update(responsable.parseToResponpaseble()),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
