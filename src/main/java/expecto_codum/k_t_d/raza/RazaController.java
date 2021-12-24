package expecto_codum.k_t_d.raza;

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
@RequestMapping(value = "/api/razas", produces = MediaType.APPLICATION_JSON_VALUE)
public class RazaController {

    private final RazaService razaService;

    public RazaController(final RazaService razaService) {
        this.razaService = razaService;
    }

    @GetMapping
    public ResponseEntity<List<RazaDTO>> getAllRazas() {
        return ResponseEntity.ok(razaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RazaDTO> getRaza(@PathVariable final Long id) {
        return ResponseEntity.ok(razaService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createRaza(@RequestBody @Valid final RazaDTO razaDTO) {
        return new ResponseEntity<>(razaService.create(razaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRaza(@PathVariable final Long id,
            @RequestBody @Valid final RazaDTO razaDTO) {
        razaService.update(id, razaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaza(@PathVariable final Long id) {
        razaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
