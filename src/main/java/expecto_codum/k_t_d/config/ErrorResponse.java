package expecto_codum.k_t_d.config;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ErrorResponse {

    private Integer httpStatus;
    private String exception;
    private String message;
    private List<FieldError> fieldErrors;
	public void setHttpStatus(int value) {
		// TODO Auto-generated method stub
		
	}
	public void setException(String simpleName) {
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
	public void setMessage(String message2) {
		// TODO Auto-generated method stub
		
	}
	public void setFieldErrors(List<FieldError> fieldErrors2) {
		// TODO Auto-generated method stub
		
	}

}
