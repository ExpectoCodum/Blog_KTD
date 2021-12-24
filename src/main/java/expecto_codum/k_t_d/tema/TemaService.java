package expecto_codum.k_t_d.tema;

import expecto_codum.k_t_d.criadero.Criadero;
import expecto_codum.k_t_d.criadero.CriaderoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class TemaService {

    private final TemaRepository temaRepository;
    private final CriaderoRepository criaderoRepository;

    public TemaService(final TemaRepository temaRepository,
            final CriaderoRepository criaderoRepository) {
        this.temaRepository = temaRepository;
        this.criaderoRepository = criaderoRepository;
    }

    public List<TemaDTO> findAll() {
        return temaRepository.findAll()
                .stream()
                .map(tema -> mapToDTO(tema, new TemaDTO()))
                .collect(Collectors.toList());
    }

    public TemaDTO get(final Long id) {
        return temaRepository.findById(id)
                .map(tema -> mapToDTO(tema, new TemaDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final TemaDTO temaDTO) {
        final Tema tema = new Tema();
        mapToEntity(temaDTO, tema);
        return temaRepository.save(tema).getId();
    }

    public void update(final Long id, final TemaDTO temaDTO) {
        final Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(temaDTO, tema);
        temaRepository.save(tema);
    }

    public void delete(final Long id) {
        temaRepository.deleteById(id);
    }

    private TemaDTO mapToDTO(final Tema tema, final TemaDTO temaDTO) {
        temaDTO.setId(tema.getId());
        temaDTO.setNombre(tema.getNombre());
        temaDTO.setDescripcion(tema.getDescripcion());
        temaDTO.setBlog(tema.getBlog() == null ? null : tema.getBlog().getId());
        return temaDTO;
    }

    private Tema mapToEntity(final TemaDTO temaDTO, final Tema tema) {
        tema.setNombre(temaDTO.getNombre());
        tema.setDescripcion(temaDTO.getDescripcion());
        if (temaDTO.getBlog() != null && (tema.getBlog() == null || !tema.getBlog().getId().equals(temaDTO.getBlog()))) {
            final Criadero blog = criaderoRepository.findById(temaDTO.getBlog())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "blog not found"));
            tema.setBlog(blog);
        }
        return tema;
    }

}
