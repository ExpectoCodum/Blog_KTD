package expecto_codum.k_t_d.comentarios;

import expecto_codum.k_t_d.articulo.Articulo;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Comentarios {

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

    @Column(columnDefinition = "text")
    private String text;

    @Column
    private LocalDate date;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coment_id")
    private Articulo coment;

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

	public Object getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public void setText(Object text2) {
		// TODO Auto-generated method stub
		
	}

	public void setDate(LocalDate date2) {
		// TODO Auto-generated method stub
		
	}

	public void setComent(Articulo coment2) {
		// TODO Auto-generated method stub
		
	}

	public Articulo getComent() {
		// TODO Auto-generated method stub
		return null;
	}


}
