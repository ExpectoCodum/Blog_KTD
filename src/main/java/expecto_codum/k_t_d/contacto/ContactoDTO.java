package expecto_codum.k_t_d.contacto;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ContactoDTO {

    private Long id;

    @Size(max = 255)
    private String nombre;

    private String direccion;

    private Integer telefono1;

    private Integer telefono2;

    @Size(max = 255)
    private String correo;

    private Long ubicacion;

    private Long contactos;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

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

	public void setNombre(String nombre2) {
		// TODO Auto-generated method stub
		
	}

	public void setDireccion(String direccion2) {
		// TODO Auto-generated method stub
		this.direccion=direccion2;
	}

	public void setTelefono1(Integer telefono12) {
		// TODO Auto-generated method stub
		
	}

	public Integer getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(Integer telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Long ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Long getContactos() {
		return contactos;
	}

	public void setContactos(Long contactos) {
		this.contactos = contactos;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public Integer getTelefono1() {
		return telefono1;
	}

	public void setContactos(Object contactos2) {
		// TODO Auto-generated method stub
		
	}

}
