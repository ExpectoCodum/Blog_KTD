package expecto_codum.k_t_d.perro;

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
@RequestMapping(value = "/api/perros", produces = MediaType.APPLICATION_JSON_VALUE)
public class PerroController {

    private final PerroService perroService;

    public PerroController(final PerroService perroService) {
        this.perroService = perroService;
    }

    @GetMapping
    public ResponseEntity<List<PerroDTO>> getAllPerros() {
        return ResponseEntity.ok(perroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerroDTO> getPerro(@PathVariable final Long id) {
        return ResponseEntity.ok(perroService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createPerro(@RequestBody @Valid final PerroDTO perroDTO) {
        return new ResponseEntity<>(perroService.create(perroDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerro(@PathVariable final Long id,
            @RequestBody @Valid final PerroDTO perroDTO) {
        perroService.update(id, perroDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerro(@PathVariable final Long id) {
        perroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
