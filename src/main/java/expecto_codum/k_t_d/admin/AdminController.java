package expecto_codum.k_t_d.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin1", method = RequestMethod.GET)
	public String admin(Model model) {
		
		
		
		
		
		// HOLA MUNDOLEEEEEEEEEEE
		
		return "/admin/admin2";
	}

}
