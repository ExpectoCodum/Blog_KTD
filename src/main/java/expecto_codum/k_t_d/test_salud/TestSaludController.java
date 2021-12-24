package expecto_codum.k_t_d.test_salud;

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
@RequestMapping(value = "/api/testSaluds", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestSaludController {

    private final TestSaludService testSaludService;

    public TestSaludController(final TestSaludService testSaludService) {
        this.testSaludService = testSaludService;
    }

    @GetMapping
    public ResponseEntity<List<TestSaludDTO>> getAllTestSaluds() {
        return ResponseEntity.ok(testSaludService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestSaludDTO> getTestSalud(@PathVariable final Long id) {
        return ResponseEntity.ok(testSaludService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createTestSalud(
            @RequestBody @Valid final TestSaludDTO testSaludDTO) {
        return new ResponseEntity<>(testSaludService.create(testSaludDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTestSalud(@PathVariable final Long id,
            @RequestBody @Valid final TestSaludDTO testSaludDTO) {
        testSaludService.update(id, testSaludDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestSalud(@PathVariable final Long id) {
        testSaludService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
