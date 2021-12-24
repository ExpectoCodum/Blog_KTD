package expecto_codum.k_t_d.articulo;

import expecto_codum.k_t_d.tema.Tema;
import expecto_codum.k_t_d.tema.TemaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ArticuloService {

    private final ArticuloRepository articuloRepository;
    private final TemaRepository temaRepository;

    public ArticuloService(final ArticuloRepository articuloRepository,
            final TemaRepository temaRepository) {
        this.articuloRepository = articuloRepository;
        this.temaRepository = temaRepository;
    }

    public List<ArticuloDTO> findAll() {
        return articuloRepository.findAll()
                .stream()
                .map(articulo -> mapToDTO(articulo, new ArticuloDTO()))
                .collect(Collectors.toList());
    }

    public ArticuloDTO get(final Long id) {
        return articuloRepository.findById(id)
                .map(articulo -> mapToDTO(articulo, new ArticuloDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final ArticuloDTO articuloDTO) {
        final Articulo articulo = new Articulo();
        mapToEntity(articuloDTO, articulo);
        return articuloRepository.save(articulo).getId();
    }

    public void update(final Long id, final ArticuloDTO articuloDTO) {
        final Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(articuloDTO, articulo);
        articuloRepository.save(articulo);
    }

    public void delete(final Long id) {
        articuloRepository.deleteById(id);
    }

    private ArticuloDTO mapToDTO(final Articulo articulo, final ArticuloDTO articuloDTO) {
        articuloDTO.setId(articulo.getId());
        articuloDTO.setTitulo(articulo.getTitulo());
        articuloDTO.setDescripcion(articulo.getDescripcion());
        articuloDTO.setTema(articulo.getTema() == null ? null : articulo.getTema().getId());
        return articuloDTO;
    }

    private Articulo mapToEntity(final ArticuloDTO articuloDTO, final Articulo articulo) {
        articulo.setTitulo(articuloDTO.getTitulo());
        articulo.setDescripcion(articuloDTO.getDescripcion());
        if (articuloDTO.getTema() != null && (articulo.getTema() == null || !articulo.getTema().getId().equals(articuloDTO.getTema()))) {
            final Tema tema = temaRepository.findById(articuloDTO.getTema())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "tema not found"));
            articulo.setTema(tema);
        }
        return articulo;
    }

}
