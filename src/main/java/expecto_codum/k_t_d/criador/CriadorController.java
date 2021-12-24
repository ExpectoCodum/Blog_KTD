package expecto_codum.k_t_d.criador;

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
@RequestMapping(value = "/api/criadors", produces = MediaType.APPLICATION_JSON_VALUE)
public class CriadorController {

    private final CriadorService criadorService;

    public CriadorController(final CriadorService criadorService) {
        this.criadorService = criadorService;
    }

    @GetMapping
    public ResponseEntity<List<CriadorDTO>> getAllCriadors() {
        return ResponseEntity.ok(criadorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriadorDTO> getCriador(@PathVariable final Long id) {
        return ResponseEntity.ok(criadorService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createCriador(@RequestBody @Valid final CriadorDTO criadorDTO) {
        return new ResponseEntity<>(criadorService.create(criadorDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCriador(@PathVariable final Long id,
            @RequestBody @Valid final CriadorDTO criadorDTO) {
        criadorService.update(id, criadorDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCriador(@PathVariable final Long id) {
        criadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
