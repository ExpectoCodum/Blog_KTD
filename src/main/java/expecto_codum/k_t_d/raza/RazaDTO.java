package expecto_codum.k_t_d.raza;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RazaDTO {

    private Long id;

    @Size(max = 255)
    private String nombre;

    @Size(max = 255)
    private String descripcion;

    private Long criadero;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
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

	public Long getCriadero() {
		return criadero;
	}

	public void setCriadero(Long criadero) {
		this.criadero = criadero;
	}

	public Long getId() {
		return id;
	}

}
