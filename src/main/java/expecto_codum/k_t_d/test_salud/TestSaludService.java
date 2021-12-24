package expecto_codum.k_t_d.test_salud;

import expecto_codum.k_t_d.perro.Perro;
import expecto_codum.k_t_d.perro.PerroRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class TestSaludService {

    private final TestSaludRepository testSaludRepository;
    private final PerroRepository perroRepository;

    public TestSaludService(final TestSaludRepository testSaludRepository,
            final PerroRepository perroRepository) {
        this.testSaludRepository = testSaludRepository;
        this.perroRepository = perroRepository;
    }

    public List<TestSaludDTO> findAll() {
        return testSaludRepository.findAll()
                .stream()
                .map(testSalud -> mapToDTO(testSalud, new TestSaludDTO()))
                .collect(Collectors.toList());
    }

    public TestSaludDTO get(final Long id) {
        return testSaludRepository.findById(id)
                .map(testSalud -> mapToDTO(testSalud, new TestSaludDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final TestSaludDTO testSaludDTO) {
        final TestSalud testSalud = new TestSalud();
        mapToEntity(testSaludDTO, testSalud);
        return testSaludRepository.save(testSalud).getId();
    }

    public void update(final Long id, final TestSaludDTO testSaludDTO) {
        final TestSalud testSalud = testSaludRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(testSaludDTO, testSalud);
        testSaludRepository.save(testSalud);
    }

    public void delete(final Long id) {
        testSaludRepository.deleteById(id);
    }

    private TestSaludDTO mapToDTO(final TestSalud testSalud, final TestSaludDTO testSaludDTO) {
        testSaludDTO.setId(testSalud.getId());
        testSaludDTO.setNombre(testSalud.getNombre());
        testSaludDTO.setFecha(testSalud.getFecha());
        testSaludDTO.setPerroTest(testSalud.getPerroTest() == null ? null : testSalud.getPerroTest().getId());
        return testSaludDTO;
    }

    private TestSalud mapToEntity(final TestSaludDTO testSaludDTO, final TestSalud testSalud) {
        testSalud.setNombre(testSaludDTO.getNombre());
        testSalud.setFecha(testSaludDTO.getFecha());
        if (testSaludDTO.getPerroTest() != null && (testSalud.getPerroTest() == null || !testSalud.getPerroTest().getId().equals(testSaludDTO.getPerroTest()))) {
            final Perro perroTest = perroRepository.findById(testSaludDTO.getPerroTest())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "perroTest not found"));
            testSalud.setPerroTest(perroTest);
        }
        return testSalud;
    }

}
