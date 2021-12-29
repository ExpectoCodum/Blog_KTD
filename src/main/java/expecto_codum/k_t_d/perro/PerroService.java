package expecto_codum.k_t_d.perro;

import expecto_codum.k_t_d.raza.Raza;
import expecto_codum.k_t_d.raza.RazaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class PerroService {

    private final PerroRepository perroRepository;
    private final RazaRepository razaRepository;

    public PerroService(final PerroRepository perroRepository,
            final RazaRepository razaRepository) {
        this.perroRepository = perroRepository;
        this.razaRepository = razaRepository;
    }

    public List<PerroDTO> findAll() {
        return perroRepository.findAll()
                .stream()
                .map(perro -> mapToDTO(perro, new PerroDTO()))
                .collect(Collectors.toList());
    }

    public PerroDTO get(final Long id) {
        return perroRepository.findById(id)
                .map(perro -> mapToDTO(perro, new PerroDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final PerroDTO perroDTO) {
        final Perro perro = new Perro();
        mapToEntity(perroDTO, perro);
        return (Long) perroRepository.save(perro).getId();
    }

    public void update(final Long id, final PerroDTO perroDTO) {
        final Perro perro = perroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(perroDTO, perro);
        perroRepository.save(perro);
    }

    public void delete(final Long id) {
        perroRepository.deleteById(id);
    }

    private PerroDTO mapToDTO(final Perro perro, final PerroDTO perroDTO) {
        perroDTO.setId(perro.getId());
        perroDTO.setNombre(perro.getNombre());
        perroDTO.setDescripcion(perro.getDescripcion());
        perroDTO.setFechaNac(perro.getFechaNac());
        perroDTO.setColor(perro.getColor());
        perroDTO.setSexo(perro.getSexo());
        perroDTO.setLoe(perro.getLoe());
        perroDTO.setRegistro(perro.getRegistro());
        perroDTO.setFechaMuerte(perro.getFechaMuerte());
        perroDTO.setPaisOrigen(perro.getPaisOrigen());
        perroDTO.setMicrochipNo(perro.getMicrochipNo());
        perroDTO.setRazasPerro(perro.getRazasPerro() == null ? null : perro.getRazasPerro().getId());
        return perroDTO;
    }

    private Perro mapToEntity(final PerroDTO perroDTO, final Perro perro) {
        perro.setNombre(perroDTO.getNombre());
        perro.setDescripcion(perroDTO.getDescripcion());
        perro.setFechaNac(perroDTO.getFechaNac());
        perro.setColor(perroDTO.getColor());
        perro.setSexo(perroDTO.getSexo());
        perro.setLoe(perroDTO.getLoe());
        perro.setRegistro(perroDTO.getRegistro());
        perro.setFechaMuerte(perroDTO.getFechaMuerte());
        perro.setPaisOrigen(perroDTO.getPaisOrigen());
        perro.setMicrochipNo(perroDTO.getMicrochipNo());
        if (perroDTO.getRazasPerro() != null && (perro.getRazasPerro() == null || !perro.getRazasPerro().getId().equals(perroDTO.getRazasPerro()))) {
            final Raza razasPerro = razaRepository.findById(perroDTO.getRazasPerro())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "razasPerro not found"));
            perro.setRazasPerro(razasPerro);
        }
        return perro;
    }

}
