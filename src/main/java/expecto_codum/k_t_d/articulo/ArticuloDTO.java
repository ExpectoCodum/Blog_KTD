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

	public void setId(Object id2) {
		// TODO Auto-generated method stub
		
	}

	public void setTitulo(Object titulo2) {
		// TODO Auto-generated method stub
		
	}

	public void setDescripcion(Object descripcion2) {
		// TODO Auto-generated method stub
		
	}

	public void setTema(Object object) {
		// TODO Auto-generated method stub
		
	}

	public String getTitulo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getTema() {
		// TODO Auto-generated method stub
		return null;
	}

}
