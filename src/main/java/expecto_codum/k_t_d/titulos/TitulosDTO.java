package expecto_codum.k_t_d.titulos;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TitulosDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    private LocalDateTime fecha;

    private String descripcion;

    private Long detallePerroTitulo;

}
