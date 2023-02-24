package mx.edu.utez.siream.controllers.role;

import mx.edu.utez.siream.controllers.account.dtos.AccountDto;
import mx.edu.utez.siream.controllers.role.dtos.RoleDto;
import mx.edu.utez.siream.services.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-siream/role")
@CrossOrigin(origins = {"*"})
public class RoleController {
    @Autowired
    private RoleService service;

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
            @RequestBody RoleDto role
            ) {
        return new ResponseEntity(
                this.service.insert(role.parseToRole()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity update(
            @RequestBody RoleDto role
    ) {
        return new ResponseEntity(
                this.service.update(role.parseToRole()),
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
