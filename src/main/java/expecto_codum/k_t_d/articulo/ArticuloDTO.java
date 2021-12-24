package expecto_codum.k_t_d.articulo;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ArticuloDTO {

    private Long id;

    @Size(max = 255)
    private String titulo;

    private String descripcion;

    private Long tema;

}
