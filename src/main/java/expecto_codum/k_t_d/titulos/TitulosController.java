package expecto_codum.k_t_d.titulos;

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
@RequestMapping(value = "/api/tituloss", produces = MediaType.APPLICATION_JSON_VALUE)
public class TitulosController {

    private final TitulosService titulosService;

    public TitulosController(final TitulosService titulosService) {
        this.titulosService = titulosService;
    }

    @GetMapping
    public ResponseEntity<List<TitulosDTO>> getAllTituloss() {
        return ResponseEntity.ok(titulosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitulosDTO> getTitulos(@PathVariable final Long id) {
        return ResponseEntity.ok(titulosService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createTitulos(@RequestBody @Valid final TitulosDTO titulosDTO) {
        return new ResponseEntity<>(titulosService.create(titulosDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTitulos(@PathVariable final Long id,
            @RequestBody @Valid final TitulosDTO titulosDTO) {
        titulosService.update(id, titulosDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTitulos(@PathVariable final Long id) {
        titulosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
