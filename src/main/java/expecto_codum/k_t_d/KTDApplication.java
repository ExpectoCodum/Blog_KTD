package expecto_codum.k_t_d;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

public class KTDApplication {

    public static void main(String[] args) {
        SpringApplication.run(KTDApplication.class, args);
    }

}
