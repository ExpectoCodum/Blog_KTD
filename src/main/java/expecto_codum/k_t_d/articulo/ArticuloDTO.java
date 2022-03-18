package expecto_codum.k_t_d.articulo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import expecto_codum.k_t_d.tema.Tema;
import expecto_codum.k_t_d.tema.TemaDTO;
import expecto_codum.k_t_d.tema.TemaService;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ArticuloDTO {

	private TemaService temaService;
	
	@NotNull(message = "El campo id no puede ser nulo")
    private Long id;

    @Size(max = 255)
    @NotNull(message = "Este campo no puede ser nulo")
    @Size(min=5,message=" El titulo debe contener mas de 5 caracteres")
    private String titulo;

    @NotNull(message = "Este campo no puede ser nulo")
    private String descripcion;
   
    @NotNull(message = "Este campo no puede ser nulo")
    private String nombreTema;
    
    @NotNull(message = "Este campo no puede ser nulo")
    private Long temaId;
    
    private List<String> temasNombre;
    
    private List<TemaDTO> temasDTO;
    
  
	private LocalDateTime lastUpdate;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String mes;
	
	@Min(value = 1, message = "Los dias del mes van del 1 al 31")
	@Max(value = 31, message = "Los dias del mes van del 1 al 31")
	@Positive(message = "El campo dia solo puede ser positivo")
	private String dia;
	
	@NotEmpty(message = "El campo contenido no puede estar vacio")
	private String contenido;
	
	private String imagen;// de momento se queda asi
		
	 public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getMes() {
		return this.lastUpdate.getMonth().getDisplayName(TextStyle.SHORT, Locale.CANADA).toUpperCase();
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getDia() {
		return String.valueOf(this.lastUpdate.getDayOfMonth());
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public TemaService getTemaService() {
		return temaService;
	}

	public void setTemaService(TemaService temaService) {
		this.temaService = temaService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMitema() {
		return nombreTema;
	}

	public void setMitema(String nombreTema) {
		this.nombreTema = nombreTema;
	}

	public Long getTemaId() {
		return temaId;
	}

	public void setTemaId(Long temaId) {
		this.temaId = temaId;
	}
    
	public List<String> getTemasNombre() {
		return temasNombre;
	}

	public void setTemasNombre(List<String> temasNombre) {
		this.temasNombre = temasNombre;
	}

	public List<TemaDTO> getTemasDTO() {
		return temasDTO;
	}

	public void setTemasDTO(List<TemaDTO> temasDTO) {
		this.temasDTO = temasDTO;
	}

	public ArticuloDTO() {
		
	}


	public String getNombreTema() {
		return nombreTema;
	}

	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}



	@Override
	public String toString() {
		return "ArticuloDTO [temaService=" + temaService + ", id=" + id + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", nombreTema=" + nombreTema + ", temaId=" + temaId + ", temasNombre=" + temasNombre
				+ ", temasDTO=" + temasDTO + ", lastUpdate=" + lastUpdate + ", mes=" + mes + ", dia=" + dia
				+ ", contenido=" + contenido + "]";
	}

	public List<String> mapTemaDTOtoTemaNombre(List<TemaDTO> temasDTO) {
		
		List<String> list=new ArrayList<>();
		while(temasDTO.iterator().hasNext()) {
			
			list.add(temasDTO.iterator().getClass().getName());
		}
		
		return list;
	}
    
}
