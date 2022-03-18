package expecto_codum.k_t_d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import expecto_codum.k_t_d.articulo.Articulo;
import expecto_codum.k_t_d.articulo.ArticuloDTO;
import expecto_codum.k_t_d.articulo.ArticuloService;
import expecto_codum.k_t_d.tema.TemaDTO;
import expecto_codum.k_t_d.tema.TemaService;


/* aqui falta hacer que cargue el home.html*/
@Controller
@RequestMapping(value="/")
public class HomeController {

	private final ArticuloService articuloService;
  	private final TemaService temaService;
	
	public HomeController(ArticuloService articuloService, TemaService temaService) {
	
		this.articuloService = articuloService;
		this.temaService = temaService;
	}


   /* @RequestMapping(value="/blog",method = RequestMethod.GET)
    public String Blog(@RequestParam Map<String,Object> params,Model model) {
    	
      	//paginacion
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
    	// fin de paginacion
    	
    	//creo listado de articulosDTO a enviar a la vista
    	List<ArticuloDTO> articulosDTO=new ArrayList<ArticuloDTO>();//cambiar este desastre
    	for(Articulo articulo: pageArticulo.getContent()) {
    		articulosDTO.add(articuloService.mapToDTO(articulo, new ArticuloDTO()));
    	}
    
    	//cargar los articulos mas recientes
    	model.addAttribute("articulos", articulosDTO);
    	model.addAttribute("temas", temaService.findAll());
    	
    	return "blog";
        
    }
   
    @RequestMapping("/Galeria")
    public String Galeria(Model model) {


        return "Index"; //view
    }*/
}


