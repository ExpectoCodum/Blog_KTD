package expecto_codum.k_t_d.articulo;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import expecto_codum.k_t_d.contacto.ContactoService;
import expecto_codum.k_t_d.tema.Tema;
import expecto_codum.k_t_d.tema.TemaDTO;
import expecto_codum.k_t_d.tema.TemaService;





@Controller
//@RequestMapping(value = "/api/articulos", produces = MediaType.APPLICATION_JSON_VALUE)
//@RequestMapping("/")//RIKIIIIIIIII AHORA SIIIIIIIII COJONEE
public class ArticuloController {

	private final ArticuloService articuloService;
    private final TemaService temaService;
    private final ContactoService contactoService;
   
    
    public ArticuloController(ArticuloService articuloService, TemaService temaService,
			ContactoService contactoService) {
		
		this.articuloService = articuloService;
		this.temaService = temaService;
		this.contactoService = contactoService;
	}
    
    
    @RequestMapping(value="/blog",method = RequestMethod.GET )
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
    	List<ArticuloDTO> articulosDTO=new ArrayList<ArticuloDTO>();
    	for(Articulo articulo: pageArticulo.getContent()) {
    		articulosDTO.add(articuloService.mapToDTO(articulo, new ArticuloDTO()));
    	}
    	
    	model.addAttribute("articulos", articulosDTO);
    	model.addAttribute("temas", temaService.findAll());
    	model.addAttribute("contacto", contactoService.get((long)10000));
         	
    	return "blog";
      
    	
    }
    
   	@RequestMapping(value="/admin",method = RequestMethod.GET )
    public ModelAndView admin() {
    	ModelAndView model=new ModelAndView("admin");
        
    	  	  	
    	ArticuloDTO newArticulo= new ArticuloDTO();
    	List<String> list=new ArrayList<>();
		for(TemaDTO tema: temaService.findAll()) {
			list.add(tema.getNombre());
		}
    	
    	newArticulo.setTemasNombre(list);
		model.addObject("articulo",newArticulo);
        model.addObject("temas", temaService.findAll());
    	System.out.println("newarticuloDTO enviado :"+newArticulo.toString());
    	return model;
    	
    }
    
    //salvar articulo en base de datos
    @RequestMapping(value="/save",method = RequestMethod.POST )
    public String salvarArticulo(@Valid @ModelAttribute("articulo") ArticuloDTO articuloDTO,
    		@ModelAttribute TemaDTO temaDTO,Model model ,BindingResult resultValidacion) {
    	System.out.println("entroo a save");
    	
    	if(!resultValidacion.hasErrors()) {
    		System.out.println("HUbo error");
    		return "blog";
    		
    	}
    	
    	
    	articuloService.create(articuloDTO);
    	System.out.println("------------ DATOS RECUPERADOS -------");
    	for(ArticuloDTO articulo : articuloService.findAll()) {
    	  		System.out.println(articulo.getDescripcion());
    	   	}
        model.addAttribute("articulos", articuloService.findAll());
    	return "blog";
    	
    }
    
    
    @RequestMapping(value="/blog/{id}",method = RequestMethod.GET )
    public String articulo(@PathVariable("id") Long id,Model model) {
    
    	
    	model.addAttribute("articulo",articuloService.get(id));
    	model.addAttribute("temas", temaService.findAll());       
    	return "singleblog";
    	
    }
    
    @RequestMapping(value="/blog/buscar",method = RequestMethod.GET )
    public String busquedaArticulo(@RequestParam("strBusqueda") String strBusqueda,Model model) {
    	System.out.println("entrooo");
    	
    	
    	for (ArticuloDTO articulo : articuloService.findAll()) {
			System.out.println( "Controllador : "+articulo.getTitulo());
		}
    	
    	List<ArticuloDTO> articuloFiltrados=articuloService.filtarArticulos(articuloService.findAll(), strBusqueda);
    	
    	for (ArticuloDTO articuloDTO : articuloFiltrados) {
			System.out.println("Nombre del articulo :" + articuloDTO.getTitulo());
		}
    	
    
    	
    	
    	
    	return "hola";
    }
    
    
    
    
    
    
    

}
