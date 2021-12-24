package expecto_codum.k_t_d.contacto;

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
@RequestMapping(value = "/api/contactos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactoController {

    private final ContactoService contactoService;

    public ContactoController(final ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public ResponseEntity<List<ContactoDTO>> getAllContactos() {
        return ResponseEntity.ok(contactoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoDTO> getContacto(@PathVariable final Long id) {
        return ResponseEntity.ok(contactoService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createContacto(@RequestBody @Valid final ContactoDTO contactoDTO) {
        return new ResponseEntity<>(contactoService.create(contactoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateContacto(@PathVariable final Long id,
            @RequestBody @Valid final ContactoDTO contactoDTO) {
        contactoService.update(id, contactoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContacto(@PathVariable final Long id) {
        contactoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
