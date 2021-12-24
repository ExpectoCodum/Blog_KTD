package expecto_codum.k_t_d.contacto;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ContactoDTO {

    private Long id;

    @Size(max = 255)
    private String nombre;

    private String direccion;

    private Integer telefono1;

    private Integer telefono2;

    @Size(max = 255)
    private String correo;

    private Long ubicacion;

    private Long contactos;

}
