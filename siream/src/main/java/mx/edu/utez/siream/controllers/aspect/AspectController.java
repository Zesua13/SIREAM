package mx.edu.utez.siream.controllers.aspect;

import mx.edu.utez.siream.controllers.aspect.dtos.AspectDto;
import mx.edu.utez.siream.services.aspect.AspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-siream/aspect")
@CrossOrigin(origins = {"*"})
public class AspectController {
    @Autowired
    private AspectService service;

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
            @RequestBody AspectDto aspect
            ) {
        return new ResponseEntity(
                this.service.insert(aspect.parseToAspect()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity update(
            @RequestBody AspectDto aspect
    ) {
        return new ResponseEntity(
                this.service.update(aspect.parseToAspect()),
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
