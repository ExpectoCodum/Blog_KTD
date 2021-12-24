package expecto_codum.k_t_d.comentarios;

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
@RequestMapping(value = "/api/comentarioss", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComentariosController {

    private final ComentariosService comentariosService;

    public ComentariosController(final ComentariosService comentariosService) {
        this.comentariosService = comentariosService;
    }

    @GetMapping
    public ResponseEntity<List<ComentariosDTO>> getAllComentarioss() {
        return ResponseEntity.ok(comentariosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentariosDTO> getComentarios(@PathVariable final Long id) {
        return ResponseEntity.ok(comentariosService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createComentarios(
            @RequestBody @Valid final ComentariosDTO comentariosDTO) {
        return new ResponseEntity<>(comentariosService.create(comentariosDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateComentarios(@PathVariable final Long id,
            @RequestBody @Valid final ComentariosDTO comentariosDTO) {
        comentariosService.update(id, comentariosDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComentarios(@PathVariable final Long id) {
        comentariosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
