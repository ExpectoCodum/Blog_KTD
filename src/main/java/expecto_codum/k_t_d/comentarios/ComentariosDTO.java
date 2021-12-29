package expecto_codum.k_t_d.comentarios;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ComentariosDTO {

    private Long id;
    private String text;
    private LocalDate date;
    private Long coment;
	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
	public void setDate(Object date2) {
		// TODO Auto-generated method stub
		
	}
	public void setText(Object text2) {
		// TODO Auto-generated method stub
		
	}
	public void setComent(Object object) {
		// TODO Auto-generated method stub
		
	}
	public Object getText() {
		// TODO Auto-generated method stub
		return null;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Long getComent() {
		return coment;
	}
	public void setComent(Long coment) {
		this.coment = coment;
	}
	public Long getId() {
		return id;
	}
	public void setText(String text) {
		this.text = text;
	}

}
