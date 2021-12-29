package expecto_codum.k_t_d.criadero;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CriaderoDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    @Size(max = 255)
    private String descripcion;

    @Size(max = 255)
    private String historia;

	public void setId(Object id2) {
		// TODO Auto-generated method stub
		
	}

	public void setNombre(String nombre2) {
		// TODO Auto-generated method stub
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getNombre() {
		return nombre;
	}

}
