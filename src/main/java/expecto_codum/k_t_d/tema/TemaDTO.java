package expecto_codum.k_t_d.tema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TemaDTO {

    @NotNull(message = "El campo id no puede ser nulo")
	private Long id;

    @Size(min=5, max = 100, message=" El nombre del tema solo admite 100 caracteres")
    @NotNull(message = "Este campo no puede ser nulo")
    private String nombre;
    
    @Size(min=10, max = 700,message=" La descripcion debe contener mas de 700 caracteres")
    @NotNull(message = "Este campo no puede ser nulo")
    private String descripcion;
    
    @NotNull(message = "El campo id no puede ser nulo")
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

	@Override
	public String toString() {
		return "TemaDTO [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", blog=" + blog + "]";
	}
    
	
}
