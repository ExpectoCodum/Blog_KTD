package expecto_codum.k_t_d.articulo;


import expecto_codum.k_t_d.tema.TemaService;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
public class ArticuloService {

    private final ArticuloRepository articuloRepository;
    //private final TemaRepository temaRepository;
    private final TemaService temaService;

    public ArticuloService(final ArticuloRepository articuloRepository,final TemaService temaService) {
        
		this.temaService = temaService;
		this.articuloRepository = articuloRepository;
    
    }

    public List<ArticuloDTO> findAll() {
        return articuloRepository.findAll()
                .stream()
                .map(articulo -> mapToDTO(articulo, new ArticuloDTO()))
                .collect(Collectors.toList());
        
    }

    public ArticuloDTO get(final Long id) {
        return articuloRepository.findById(id)
                .map(articulo -> mapToDTO(articulo, new ArticuloDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final ArticuloDTO articuloDTO) {
        final Articulo articulo = new Articulo();
        System.out.println("AriculoDTO :"+articuloDTO.toString());
        mapToEntity(articuloDTO, articulo);
      
        return (Long) articuloRepository.save(articulo).getId();
    }

    public void update(final Long id, final ArticuloDTO articuloDTO) {
        final Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(articuloDTO, articulo);
        articuloRepository.save(articulo);
    }

    public void delete(final Long id) {
        articuloRepository.deleteById(id);
    }

    public ArticuloDTO mapToDTO(final Articulo articulo, final ArticuloDTO articuloDTO) {
        articuloDTO.setId((Long)articulo.getId());
        articuloDTO.setTitulo((String)articulo.getTitulo());
        
        articuloDTO.setDescripcion(new String(articulo.getDescripcion(),StandardCharsets.UTF_8));
        articuloDTO.setContenido(new String(articulo.getContenido(),StandardCharsets.UTF_8));
        articuloDTO.setLastUpdate(articulo.getDateCreated().toLocalDateTime());
        articuloDTO.setTemaId(articulo.getTema().getId() == null ? null : (Long)articulo.getTema().getId());
        //System.out.println("------------- Mapeo en el articulo service " + articulo.getTema().getId());
        List<String>list=new ArrayList<>();
        temaService.findAll().stream().map(tema->list.add(tema.getNombre()));
        articuloDTO.setTemasNombre(list);
     
        return articuloDTO;
    }

    private Articulo mapToEntity(final ArticuloDTO articuloDTO, final Articulo articulo) {
         articulo.setTitulo(articuloDTO.getTitulo());
        
        
         articulo.setDescripcion(articuloDTO.getDescripcion().getBytes());
         articulo.setContenido(articuloDTO.getContenido().getBytes());
       // if (articuloDTO.getTema() != null && (articulo.getTema() == null || !articulo.getTema().getId().equals(articuloDTO.getTema()))) {
       //     final Tema tema = temaRepository.findById((Long) articuloDTO.getTema())
        //            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "tema not found"));
       //     articulo.setTema(tema);
      //  }
         System.out.println("Articulo ya mapeado a erntity");
        System.out.println(articulo.toString());
        return articulo;
    }
    
  
    
    public Page<Articulo> findAll(Pageable pageable) {
    	
    	return articuloRepository.findAll(pageable);
    }

    private ArticuloDTO map(String clave,List<ArticuloDTO> articuloDTO) {
    	
    	// filtro a una lista todos los nombres de los temas y los llevo a minuscula
       	List<String>nombresArticulos=articuloDTO
    			                     .stream()
    			                     .map(articulo->articulo.getNombreTema().toLowerCase())
    			                     .collect(Collectors.toList());
    	
       	//elimino preposiciones de los nombres y llevo palabras al singular y elimino mayusculas
    	
    	
    	
       	//creo un stream con las palabras del nombre del articulo por separado
    	//compruebo so alguna palabra coincide con la clave
    	//si coincide guardo articulo en lista 
    	//sino continuo
    	
    	
    			
    	
    	return null;
    	
    }
    
    public List<ArticuloDTO> filtarArticulos(List<ArticuloDTO> articulosDTO,String strBuscar) {
    	
    	List<String> listStrBuscValid=validarRequestString(strBuscar);
    	
    	//filtro todos los nombres de los articulos segun formato de comparacion
    	articulosDTO.forEach(articulo -> validarString(articulo));
    	
    	List<String>listStrTituloArt=new LinkedList<String>();
    	
    	articulosDTO.stream().map(articulo-> listStrTituloArt.add(articulo.getTitulo()));
    
    	
    	List<ArticuloDTO> listArtFiltrado = new LinkedList<ArticuloDTO>();
    	//
    	for (ArticuloDTO articulo : articulosDTO) {
    		
    		String[] arrayStr=articulo.getTitulo().toLowerCase().split(" ");
    		
    		
    		
    		
    		for (String string2 : listStrBuscValid) {
    			System.out.println("Articulo dto :" +articulo.getTitulo());
    			System.out.println("String request :" + string2);
				if(articulo.getTitulo().equals(string2)) {
					System.out.println("se agrego articulo");
			      listArtFiltrado.add(articulo);
			     }
    		   }
    		 }
    	
    	return listArtFiltrado;
    	
     }
    
    
    private List<String> validarRequestString(String strBuscar) {
    	
    	String[] arrayStr=strBuscar.split(" ");
    	
    	//creo lista de palabras filtradas
    	List<String> matchString=new LinkedList<String>();
    
    	//compruebo que cada palabra contiene solo letras y de 2 a 10 caracteres
    	Pattern soloLetras=Pattern.compile("^[A-Za-z]{4,10}$");
		
    	//para cada palabra clave hago validacion
    	for (String string : arrayStr) {
    		Matcher m=soloLetras.matcher(string);
    	    		if(m.matches()) { 
    	    			matchString.add(string);//salvo string 
    	    		}
    			}
    	
     	return matchString;
	}

	public void validarString(ArticuloDTO articulo){
		System.out.println("Tema del articulo antes: " + articulo.getTitulo());
       	String[] arrayStr=articulo.getTitulo().toLowerCase().split(" ");
    	
    	//creo lista de palabras filtradas
    	List<String> matchString=new LinkedList<>();
    	
    	//compruebo que cada palabra contiene solo letras y de 2 a 10 caracteres
    	Pattern soloLetras=Pattern.compile("^[A-Za-z]{4,10}$");
    	
    	//para cada articulo valido el nombre del tema
    	for (String string : arrayStr) {
    		Matcher m=soloLetras.matcher(string);
    	    		if(m.matches()) { 
    	    			matchString.add(string);//salvo string 
    	    		}
    			}
    	
    	//creando el string 
      	String newStr = "";
    	for (String string : matchString) {
    		newStr=newStr+" "+string;
    	}
    	    	
    	articulo.setTitulo(newStr);
    	System.out.println("Tema del articulo despues: " + articulo.getTitulo());
    }
    
    
    
    
    
}
