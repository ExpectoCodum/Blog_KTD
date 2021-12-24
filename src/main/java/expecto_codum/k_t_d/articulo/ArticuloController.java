package expecto_codum.k_t_d.articulo;

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
@RequestMapping(value = "/api/articulos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(final ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping
    public ResponseEntity<List<ArticuloDTO>> getAllArticulos() {
        return ResponseEntity.ok(articuloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloDTO> getArticulo(@PathVariable final Long id) {
        return ResponseEntity.ok(articuloService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createArticulo(@RequestBody @Valid final ArticuloDTO articuloDTO) {
        return new ResponseEntity<>(articuloService.create(articuloDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateArticulo(@PathVariable final Long id,
            @RequestBody @Valid final ArticuloDTO articuloDTO) {
        articuloService.update(id, articuloDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticulo(@PathVariable final Long id) {
        articuloService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
