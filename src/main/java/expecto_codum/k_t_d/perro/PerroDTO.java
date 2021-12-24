package expecto_codum.k_t_d.perro;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PerroDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    @Size(max = 255)
    private String descripcion;

    private LocalDate fechaNac;

    @Size(max = 255)
    private String color;

    @NotNull
    private Boolean sexo;

    private Integer loe;

    private String registro;

    private LocalDate fechaMuerte;

    @Size(max = 255)
    private String paisOrigen;

    private Integer microchipNo;

    private Long razasPerro;

}
