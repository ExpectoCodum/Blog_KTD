package expecto_codum.k_t_d.criador;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CriadorDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    private Long criaderoCriador;

}
