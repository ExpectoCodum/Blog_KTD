package expecto_codum.k_t_d.contacto;

import expecto_codum.k_t_d.criadero.Criadero;
import expecto_codum.k_t_d.criadero.CriaderoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ContactoService {

    private final ContactoRepository contactoRepository;
    private final CriaderoRepository criaderoRepository;

    public ContactoService(final ContactoRepository contactoRepository,
            final CriaderoRepository criaderoRepository) {
        this.contactoRepository = contactoRepository;
        this.criaderoRepository = criaderoRepository;
    }

    public List<ContactoDTO> findAll() {
        return contactoRepository.findAll()
                .stream()
                .map(contacto -> mapToDTO(contacto, new ContactoDTO()))
                .collect(Collectors.toList());
    }

    public ContactoDTO get(final Long id) {
        return contactoRepository.findById(id)
                .map(contacto -> mapToDTO(contacto, new ContactoDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final ContactoDTO contactoDTO) {
        final Contacto contacto = new Contacto();
        mapToEntity(contactoDTO, contacto);
        return contactoRepository.save(contacto).getId();
    }

    public void update(final Long id, final ContactoDTO contactoDTO) {
        final Contacto contacto = contactoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(contactoDTO, contacto);
        contactoRepository.save(contacto);
    }

    public void delete(final Long id) {
        contactoRepository.deleteById(id);
    }

    private ContactoDTO mapToDTO(final Contacto contacto, final ContactoDTO contactoDTO) {
        contactoDTO.setId(contacto.getId());
        contactoDTO.setNombre(contacto.getNombre());
        contactoDTO.setDireccion(contacto.getDireccion());
        contactoDTO.setTelefono1(contacto.getTelefono1());
        contactoDTO.setTelefono2(contacto.getTelefono2());
        contactoDTO.setCorreo(contacto.getCorreo());
        contactoDTO.setUbicacion(contacto.getUbicacion());
        contactoDTO.setContactos(contacto.getContactos() == null ? null : contacto.getContactos().getId());
        return contactoDTO;
    }

    private Contacto mapToEntity(final ContactoDTO contactoDTO, final Contacto contacto) {
        contacto.setNombre(contactoDTO.getNombre());
        contacto.setDireccion(contactoDTO.getDireccion());
        contacto.setTelefono1(contactoDTO.getTelefono1());
        contacto.setTelefono2(contactoDTO.getTelefono2());
        contacto.setCorreo(contactoDTO.getCorreo());
        contacto.setUbicacion(contactoDTO.getUbicacion());
        if (contactoDTO.getContactos() != null && (contacto.getContactos() == null || !contacto.getContactos().getId().equals(contactoDTO.getContactos()))) {
            final Criadero contactos = criaderoRepository.findById(contactoDTO.getContactos())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "contactos not found"));
            contacto.setContactos(contactos);
        }
        return contacto;
    }

}
