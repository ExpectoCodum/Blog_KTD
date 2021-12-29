package expecto_codum.k_t_d.perro;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PerroDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    @Size(max = 255)
    private String descripcion;

    private LocalDate fechaNac;

    @Size(max = 255)
    private String color;

    @NotNull
    private Boolean sexo;

    private Integer loe;

    private String registro;

    private LocalDate fechaMuerte;

    @Size(max = 255)
    private String paisOrigen;

    private Integer microchipNo;

    private Long razasPerro;

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

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public Integer getLoe() {
		return loe;
	}

	public void setLoe(Integer loe) {
		this.loe = loe;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public LocalDate getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(LocalDate fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public Integer getMicrochipNo() {
		return microchipNo;
	}

	public void setMicrochipNo(Integer microchipNo) {
		this.microchipNo = microchipNo;
	}

	public Long getRazasPerro() {
		return razasPerro;
	}

	public void setRazasPerro(Long razasPerro) {
		this.razasPerro = razasPerro;
	}

}
