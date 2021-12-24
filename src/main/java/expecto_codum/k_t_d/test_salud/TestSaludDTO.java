package expecto_codum.k_t_d.test_salud;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TestSaludDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    private LocalDateTime fecha;

    private Long perroTest;

}
