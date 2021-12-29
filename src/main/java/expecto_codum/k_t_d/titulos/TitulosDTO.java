package expecto_codum.k_t_d.titulos;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TitulosDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    private LocalDateTime fecha;

    private String descripcion;

    private Long detallePerroTitulo;

	public void setNombre(String nombre2) {
		// TODO Auto-generated method stub
		
	}

	public void setId(Object id2) {
		// TODO Auto-generated method stub
		
	}

	public void setFecha(LocalDateTime fecha2) {
		// TODO Auto-generated method stub
		
	}

	public void setDescripcion(String descripcion2) {
		// TODO Auto-generated method stub
		
	}

	public void setDetallePerroTitulo(Object object) {
		// TODO Auto-generated method stub
		
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDetallePerroTitulo() {
		return detallePerroTitulo;
	}

	public void setDetallePerroTitulo(Long detallePerroTitulo) {
		this.detallePerroTitulo = detallePerroTitulo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
