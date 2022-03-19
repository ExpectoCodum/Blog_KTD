package expecto_codum.k_t_d.drive;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DriveController {

	
	@RequestMapping("/drive")
	public String drive(Model model) {
		
		return "drive";
	}
}
