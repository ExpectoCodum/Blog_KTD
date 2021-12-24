package expecto_codum.k_t_d.tema;

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
@RequestMapping(value = "/api/temas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TemaController {

    private final TemaService temaService;

    public TemaController(final TemaService temaService) {
        this.temaService = temaService;
    }

    @GetMapping
    public ResponseEntity<List<TemaDTO>> getAllTemas() {
        return ResponseEntity.ok(temaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemaDTO> getTema(@PathVariable final Long id) {
        return ResponseEntity.ok(temaService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createTema(@RequestBody @Valid final TemaDTO temaDTO) {
        return new ResponseEntity<>(temaService.create(temaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTema(@PathVariable final Long id,
            @RequestBody @Valid final TemaDTO temaDTO) {
        temaService.update(id, temaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTema(@PathVariable final Long id) {
        temaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
