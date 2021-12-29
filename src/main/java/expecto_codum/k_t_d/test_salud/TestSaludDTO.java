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

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

	public void setNombre(String nombre2) {
		// TODO Auto-generated method stub
		
	}

	public void setFecha(LocalDateTime fecha2) {
		// TODO Auto-generated method stub
		
	}

	public void setPerroTest(Object object) {
		// TODO Auto-generated method stub
		
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getPerroTest() {
		return perroTest;
	}

	public void setPerroTest(Long perroTest) {
		this.perroTest = perroTest;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

}
