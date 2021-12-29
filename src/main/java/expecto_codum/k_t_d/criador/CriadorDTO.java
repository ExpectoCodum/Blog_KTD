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

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

	public void setNombre(String nombre2) {
		// TODO Auto-generated method stub
		
	}

	public void setCriaderoCriador(Object object) {
		// TODO Auto-generated method stub
		
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCriaderoCriador() {
		// TODO Auto-generated method stub
		return null;
	}

}
