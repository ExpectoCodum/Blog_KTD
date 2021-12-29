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

	public void setId(Object id2) {
		// TODO Auto-generated method stub
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getBlog() {
		return blog;
	}

	public void setBlog(Long blog) {
		this.blog = blog;
	}

}
