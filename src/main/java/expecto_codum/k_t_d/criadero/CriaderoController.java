package expecto_codum.k_t_d.criadero;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/criaderos", produces = MediaType.APPLICATION_JSON_VALUE)
public class CriaderoController {

    private final CriaderoService criaderoService;

    public CriaderoController(final CriaderoService criaderoService) {
        this.criaderoService = criaderoService;
    }

    @GetMapping
    public ResponseEntity<List<CriaderoDTO>> getAllCriaderos() {
        return ResponseEntity.ok(criaderoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriaderoDTO> getCriadero(@PathVariable final Long id) {
        return ResponseEntity.ok(criaderoService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createCriadero(@RequestBody @Valid final CriaderoDTO criaderoDTO) {
        return new ResponseEntity<>(criaderoService.create(criaderoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCriadero(@PathVariable final Long id,
            @RequestBody @Valid final CriaderoDTO criaderoDTO) {
        criaderoService.update(id, criaderoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCriadero(@PathVariable final Long id) {
        criaderoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
