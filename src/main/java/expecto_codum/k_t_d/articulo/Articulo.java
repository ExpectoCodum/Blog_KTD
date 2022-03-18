package expecto_codum.k_t_d.articulo;

import expecto_codum.k_t_d.comentarios.Comentarios;
import expecto_codum.k_t_d.tema.Tema;
import java.time.OffsetDateTime;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Articulo {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String titulo;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private byte[] descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tema_id")
    //@Column(nullable = false)
    private Tema tema;

  	@OneToMany(mappedBy = "coment")
    private Set<Comentarios> comentComentarioss;

  	@Lob
  	@Column(name="Contenido",nullable = false)
  	@NotNull(message = "Este campo no puede ser nulo")
  	private byte[]contenido;
  	
    @Column
   	private String imagen;//de momento se queda asi
    
	@Column(nullable = false, updatable = false)
	@NotNull(message = "Este campo no puede ser nulo")
    private OffsetDateTime dateCreated;

    @Column(nullable = false)
    @NotNull(message = "Este campo no puede ser nulo")
    private OffsetDateTime lastUpdated;

    @PrePersist
    public void prePersist() {
        dateCreated = OffsetDateTime.now();
        lastUpdated = dateCreated;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = OffsetDateTime.now();
    }
    public byte[] getContenido() {
		return contenido;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}

    public byte[] getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(byte[] descripcion) {
		this.descripcion = descripcion;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Object getTitulo() {
		// TODO Auto-generated method stub
		return titulo;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Set<Comentarios> getComentComentarioss() {
		return comentComentarioss;
	}

	public void setComentComentarioss(Set<Comentarios> comentComentarioss) {
		this.comentComentarioss = comentComentarioss;
	}

	public OffsetDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(OffsetDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public OffsetDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(OffsetDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

   
	public Articulo() {
		super();
		
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", tema=" + tema
				+ ", comentComentarioss=" + comentComentarioss + ", dateCreated=" + dateCreated + ", lastUpdated="
				+ lastUpdated + "]";
	}
    


}
