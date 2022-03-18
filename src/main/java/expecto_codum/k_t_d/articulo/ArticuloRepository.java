package expecto_codum.k_t_d.articulo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
	
	 Page<Articulo> findAll(Pageable pageable);
}
