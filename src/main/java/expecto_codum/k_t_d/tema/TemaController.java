package expecto_codum.k_t_d.tema;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import expecto_codum.k_t_d.articulo.Articulo;
import expecto_codum.k_t_d.articulo.ArticuloDTO;
import expecto_codum.k_t_d.articulo.ArticuloRepository;
import expecto_codum.k_t_d.articulo.ArticuloService;
import expecto_codum.k_t_d.utils.Paginacion;


@Controller
public class TemaController {

   
	private final TemaService temaService;
	private final ArticuloService articuloService;
	@Autowired
	private ArticuloRepository articuloRepository;
    
    public TemaController(TemaService temaService, ArticuloService articuloService
			) {
		
		this.temaService = temaService;
		this.articuloService = articuloService;
		
	}


	@RequestMapping("/blog/tema/{id}")
    public String ArticulosTemaId(@PathVariable("id") long id,@RequestParam Map<String,Object> params,Model model) {
        
		    
       	//filtro temas por id
		List<ArticuloDTO>articulos=articuloService.findAll()
									  .stream()
									  .filter((articulo) -> articulo.getTemaId()==id)
									  .collect(Collectors.toList());
			
		System.out.println("------------------- PAGINACION ----------------------------------------------");
		int page=params.get("page") != null ? (Integer.valueOf(params.get("page").toString())-1):0;
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
    	model.addAttribute("temas", temaService.findAll());
    	
    	model.addAttribute("articulos", articulos);
       
    	return "blog"; //view
    }
}
