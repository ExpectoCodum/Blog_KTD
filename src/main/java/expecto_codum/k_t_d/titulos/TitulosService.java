package expecto_codum.k_t_d.titulos;

import expecto_codum.k_t_d.perro.Perro;
import expecto_codum.k_t_d.perro.PerroRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class TitulosService {

    private final TitulosRepository titulosRepository;
    private final PerroRepository perroRepository;

    public TitulosService(final TitulosRepository titulosRepository,
            final PerroRepository perroRepository) {
        this.titulosRepository = titulosRepository;
        this.perroRepository = perroRepository;
    }

    public List<TitulosDTO> findAll() {
        return titulosRepository.findAll()
                .stream()
                .map(titulos -> mapToDTO(titulos, new TitulosDTO()))
                .collect(Collectors.toList());
    }

    public TitulosDTO get(final Long id) {
        return titulosRepository.findById(id)
                .map(titulos -> mapToDTO(titulos, new TitulosDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final TitulosDTO titulosDTO) {
        final Titulos titulos = new Titulos();
        mapToEntity(titulosDTO, titulos);
        return (Long) titulosRepository.save(titulos).getId();
    }

    public void update(final Long id, final TitulosDTO titulosDTO) {
        final Titulos titulos = titulosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(titulosDTO, titulos);
        titulosRepository.save(titulos);
    }

    public void delete(final Long id) {
        titulosRepository.deleteById(id);
    }

    private TitulosDTO mapToDTO(final Titulos titulos, final TitulosDTO titulosDTO) {
        titulosDTO.setId(titulos.getId());
        titulosDTO.setNombre(titulos.getNombre());
        titulosDTO.setFecha(titulos.getFecha());
        titulosDTO.setDescripcion(titulos.getDescripcion());
        titulosDTO.setDetallePerroTitulo(titulos.getDetallePerroTitulo() == null ? null : titulos.getDetallePerroTitulo().getId());
        return titulosDTO;
    }

    private Titulos mapToEntity(final TitulosDTO titulosDTO, final Titulos titulos) {
        titulos.setNombre(titulosDTO.getNombre());
        titulos.setFecha(titulosDTO.getFecha());
        titulos.setDescripcion(titulosDTO.getDescripcion());
        if (titulosDTO.getDetallePerroTitulo() != null && (titulos.getDetallePerroTitulo() == null || !titulos.getDetallePerroTitulo().getId().equals(titulosDTO.getDetallePerroTitulo()))) {
            final Perro detallePerroTitulo = perroRepository.findById(titulosDTO.getDetallePerroTitulo())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "detallePerroTitulo not found"));
            titulos.setDetallePerroTitulo(detallePerroTitulo);
        }
        return titulos;
    }

}
