package expecto_codum.k_t_d.criadero;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CriaderoService {

    private final CriaderoRepository criaderoRepository;

    public CriaderoService(final CriaderoRepository criaderoRepository) {
        this.criaderoRepository = criaderoRepository;
    }

    public List<CriaderoDTO> findAll() {
        return criaderoRepository.findAll()
                .stream()
                .map(criadero -> mapToDTO(criadero, new CriaderoDTO()))
                .collect(Collectors.toList());
    }

    public CriaderoDTO get(final Long id) {
        return criaderoRepository.findById(id)
                .map(criadero -> mapToDTO(criadero, new CriaderoDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CriaderoDTO criaderoDTO) {
        final Criadero criadero = new Criadero();
        mapToEntity(criaderoDTO, criadero);
        return criaderoRepository.save(criadero).getId();
    }

    public void update(final Long id, final CriaderoDTO criaderoDTO) {
        final Criadero criadero = criaderoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(criaderoDTO, criadero);
        criaderoRepository.save(criadero);
    }

    public void delete(final Long id) {
        criaderoRepository.deleteById(id);
    }

    private CriaderoDTO mapToDTO(final Criadero criadero, final CriaderoDTO criaderoDTO) {
        criaderoDTO.setId(criadero.getId());
        criaderoDTO.setNombre(criadero.getNombre());
        criaderoDTO.setDescripcion(criadero.getDescripcion());
        criaderoDTO.setHistoria(criadero.getHistoria());
        return criaderoDTO;
    }

    private Criadero mapToEntity(final CriaderoDTO criaderoDTO, final Criadero criadero) {
        criadero.setNombre(criaderoDTO.getNombre());
        criadero.setDescripcion(criaderoDTO.getDescripcion());
        criadero.setHistoria(criaderoDTO.getHistoria());
        return criadero;
    }

}
