package expecto_codum.k_t_d.utils;


import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import expecto_codum.k_t_d.articulo.Articulo;
import expecto_codum.k_t_d.articulo.ArticuloService;


public class Paginacion {
	
	private ArticuloService articuloService;
	
	
	Model Paginar(Model model,int page) {
		
		//ModelAndView model=new ModelAndView(pagina);
    	System.out.println(page);
    	
    	Page<Articulo>pageArticulo=articuloService.findAll(PageRequest.of(page, 3));
    	
    	int totalPage=pageArticulo.getTotalPages();
    	System.out.println("Paginas totales :"+totalPage);
    	if(totalPage>0) {
    		List<Integer> pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
    		model.addAttribute("pages", pages);
    	}
        	
    	model.addAttribute("current", page+1);
    	model.addAttribute("next", page+2);
    	model.addAttribute("prev", page);
    	model.addAttribute("last", totalPage);
    	
    	return model;
    	
	}

}
