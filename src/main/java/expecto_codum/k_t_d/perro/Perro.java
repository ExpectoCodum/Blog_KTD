package expecto_codum.k_t_d.perro;

import expecto_codum.k_t_d.raza.Raza;
import expecto_codum.k_t_d.test_salud.TestSalud;
import expecto_codum.k_t_d.titulos.Titulos;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Perro {

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
    private LocalDate fechaNac;

    @Column
    private String color;

    @Column(nullable = false)
    private Boolean sexo;

    @Column
    private Integer loe;

    @Column(columnDefinition = "text")
    private String registro;

    @Column
    private LocalDate fechaMuerte;

    @Column
    private String paisOrigen;

    @Column
    private Integer microchipNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "razas_perro_id")
    private Raza razasPerro;

    @OneToMany(mappedBy = "detallePerroTitulo")
    private Set<Titulos> detallePerroTituloTituloss;

    @OneToMany(mappedBy = "perroTest")
    private Set<TestSalud> perroTestTestSaluds;

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

	public Object getId() {
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

	public Raza getRazasPerro() {
		return razasPerro;
	}

	public void setRazasPerro(Raza razasPerro) {
		this.razasPerro = razasPerro;
	}

	public Set<Titulos> getDetallePerroTituloTituloss() {
		return detallePerroTituloTituloss;
	}

	public void setDetallePerroTituloTituloss(Set<Titulos> detallePerroTituloTituloss) {
		this.detallePerroTituloTituloss = detallePerroTituloTituloss;
	}

	public Set<TestSalud> getPerroTestTestSaluds() {
		return perroTestTestSaluds;
	}

	public void setPerroTestTestSaluds(Set<TestSalud> perroTestTestSaluds) {
		this.perroTestTestSaluds = perroTestTestSaluds;
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
