package expecto_codum.k_t_d.raza;

import expecto_codum.k_t_d.criadero.Criadero;
import expecto_codum.k_t_d.criadero.CriaderoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class RazaService {

    private final RazaRepository razaRepository;
    private final CriaderoRepository criaderoRepository;

    public RazaService(final RazaRepository razaRepository,
            final CriaderoRepository criaderoRepository) {
        this.razaRepository = razaRepository;
        this.criaderoRepository = criaderoRepository;
    }

    public List<RazaDTO> findAll() {
        return razaRepository.findAll()
                .stream()
                .map(raza -> mapToDTO(raza, new RazaDTO()))
                .collect(Collectors.toList());
    }

    public RazaDTO get(final Long id) {
        return razaRepository.findById(id)
                .map(raza -> mapToDTO(raza, new RazaDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final RazaDTO razaDTO) {
        final Raza raza = new Raza();
        mapToEntity(razaDTO, raza);
        return razaRepository.save(raza).getId();
    }

    public void update(final Long id, final RazaDTO razaDTO) {
        final Raza raza = razaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(razaDTO, raza);
        razaRepository.save(raza);
    }

    public void delete(final Long id) {
        razaRepository.deleteById(id);
    }

    private RazaDTO mapToDTO(final Raza raza, final RazaDTO razaDTO) {
        razaDTO.setId(raza.getId());
        razaDTO.setNombre(raza.getNombre());
        razaDTO.setDescripcion(raza.getDescripcion());
        razaDTO.setCriadero(raza.getCriadero() == null ? null : raza.getCriadero().getId());
        return razaDTO;
    }

    private Raza mapToEntity(final RazaDTO razaDTO, final Raza raza) {
        raza.setNombre(razaDTO.getNombre());
        raza.setDescripcion(razaDTO.getDescripcion());
        if (razaDTO.getCriadero() != null && (raza.getCriadero() == null || !raza.getCriadero().getId().equals(razaDTO.getCriadero()))) {
            final Criadero criadero = criaderoRepository.findById(razaDTO.getCriadero())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "criadero not found"));
            raza.setCriadero(criadero);
        }
        return raza;
    }

}
