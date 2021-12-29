package expecto_codum.k_t_d.criadero;

import expecto_codum.k_t_d.contacto.Contacto;
import expecto_codum.k_t_d.criador.Criador;
import expecto_codum.k_t_d.raza.Raza;
import expecto_codum.k_t_d.tema.Tema;
import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Criadero {

    @Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

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

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private String historia;

    @OneToMany(mappedBy = "criaderoCriador")
    private Set<Criador> criaderoCriadorCriadors;

    @OneToMany(mappedBy = "criadero")
    private Set<Raza> criaderoRazas;

    @OneToMany(mappedBy = "contactos")
    private Set<Contacto> contactosContactos;

    @OneToMany(mappedBy = "blog")
    private Set<Tema> blogTemas;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @Column(nullable = false)
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

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
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

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public Set<Criador> getCriaderoCriadorCriadors() {
		return criaderoCriadorCriadors;
	}

	public void setCriaderoCriadorCriadors(Set<Criador> criaderoCriadorCriadors) {
		this.criaderoCriadorCriadors = criaderoCriadorCriadors;
	}

	public Set<Raza> getCriaderoRazas() {
		return criaderoRazas;
	}

	public void setCriaderoRazas(Set<Raza> criaderoRazas) {
		this.criaderoRazas = criaderoRazas;
	}

	public Set<Contacto> getContactosContactos() {
		return contactosContactos;
	}

	public void setContactosContactos(Set<Contacto> contactosContactos) {
		this.contactosContactos = contactosContactos;
	}

	public Set<Tema> getBlogTemas() {
		return blogTemas;
	}

	public void setBlogTemas(Set<Tema> blogTemas) {
		this.blogTemas = blogTemas;
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

}
