package expecto_codum.k_t_d.comentarios;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ComentariosDTO {

    private Long id;
    private String text;
    private LocalDate date;
    private Long coment;

}
