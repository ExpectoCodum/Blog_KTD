package expecto_codum.k_t_d.comentarios;

import expecto_codum.k_t_d.articulo.Articulo;
import expecto_codum.k_t_d.articulo.ArticuloRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ComentariosService {

    private final ComentariosRepository comentariosRepository;
    private final ArticuloRepository articuloRepository;

    public ComentariosService(final ComentariosRepository comentariosRepository,
            final ArticuloRepository articuloRepository) {
        this.comentariosRepository = comentariosRepository;
        this.articuloRepository = articuloRepository;
    }

    public List<ComentariosDTO> findAll() {
        return comentariosRepository.findAll()
                .stream()
                .map(comentarios -> mapToDTO(comentarios, new ComentariosDTO()))
                .collect(Collectors.toList());
    }

    public ComentariosDTO get(final Long id) {
        return comentariosRepository.findById(id)
                .map(comentarios -> mapToDTO(comentarios, new ComentariosDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final ComentariosDTO comentariosDTO) {
        final Comentarios comentarios = new Comentarios();
        mapToEntity(comentariosDTO, comentarios);
        return comentariosRepository.save(comentarios).getId();
    }

    public void update(final Long id, final ComentariosDTO comentariosDTO) {
        final Comentarios comentarios = comentariosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(comentariosDTO, comentarios);
        comentariosRepository.save(comentarios);
    }

    public void delete(final Long id) {
        comentariosRepository.deleteById(id);
    }

    private ComentariosDTO mapToDTO(final Comentarios comentarios,
            final ComentariosDTO comentariosDTO) {
        comentariosDTO.setId(comentarios.getId());
        comentariosDTO.setText(comentarios.getText());
        comentariosDTO.setDate(comentarios.getDate());
        comentariosDTO.setComent(comentarios.getComent() == null ? null : ((Articulo) comentarios.getComent()).getId());
        return comentariosDTO;
    }

    private Comentarios mapToEntity(final ComentariosDTO comentariosDTO,
            final Comentarios comentarios) {
        comentarios.setText(comentariosDTO.getText());
        comentarios.setDate(comentariosDTO.getDate());
        if (comentariosDTO.getComent() != null && (comentarios.getComent() == null || !((Articulo) comentarios.getComent()).getId().equals(comentariosDTO.getComent()))) {
            final Articulo coment = articuloRepository.findById(comentariosDTO.getComent())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "coment not found"));
            comentarios.setComent(coment);
        }
        return comentarios;
    }

}
