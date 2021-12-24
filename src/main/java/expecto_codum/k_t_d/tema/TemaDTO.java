package expecto_codum.k_t_d.tema;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TemaDTO {

    private Long id;

    @Size(max = 255)
    private String nombre;

    private String descripcion;

    private Long blog;

}
