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

}
