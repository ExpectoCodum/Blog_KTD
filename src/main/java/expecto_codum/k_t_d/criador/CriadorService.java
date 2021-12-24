package expecto_codum.k_t_d.criador;

import expecto_codum.k_t_d.criadero.Criadero;
import expecto_codum.k_t_d.criadero.CriaderoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CriadorService {

    private final CriadorRepository criadorRepository;
    private final CriaderoRepository criaderoRepository;

    public CriadorService(final CriadorRepository criadorRepository,
            final CriaderoRepository criaderoRepository) {
        this.criadorRepository = criadorRepository;
        this.criaderoRepository = criaderoRepository;
    }

    public List<CriadorDTO> findAll() {
        return criadorRepository.findAll()
                .stream()
                .map(criador -> mapToDTO(criador, new CriadorDTO()))
                .collect(Collectors.toList());
    }

    public CriadorDTO get(final Long id) {
        return criadorRepository.findById(id)
                .map(criador -> mapToDTO(criador, new CriadorDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CriadorDTO criadorDTO) {
        final Criador criador = new Criador();
        mapToEntity(criadorDTO, criador);
        return criadorRepository.save(criador).getId();
    }

    public void update(final Long id, final CriadorDTO criadorDTO) {
        final Criador criador = criadorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(criadorDTO, criador);
        criadorRepository.save(criador);
    }

    public void delete(final Long id) {
        criadorRepository.deleteById(id);
    }

    private CriadorDTO mapToDTO(final Criador criador, final CriadorDTO criadorDTO) {
        criadorDTO.setId(criador.getId());
        criadorDTO.setNombre(criador.getNombre());
        criadorDTO.setCriaderoCriador(criador.getCriaderoCriador() == null ? null : criador.getCriaderoCriador().getId());
        return criadorDTO;
    }

    private Criador mapToEntity(final CriadorDTO criadorDTO, final Criador criador) {
        criador.setNombre(criadorDTO.getNombre());
        if (criadorDTO.getCriaderoCriador() != null && (criador.getCriaderoCriador() == null || !criador.getCriaderoCriador().getId().equals(criadorDTO.getCriaderoCriador()))) {
            final Criadero criaderoCriador = criaderoRepository.findById(criadorDTO.getCriaderoCriador())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "criaderoCriador not found"));
            criador.setCriaderoCriador(criaderoCriador);
        }
        return criador;
    }

}
