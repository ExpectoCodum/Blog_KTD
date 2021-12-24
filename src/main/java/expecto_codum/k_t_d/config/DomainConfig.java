package expecto_codum.k_t_d.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("expecto_codum.k_t_d")
@EnableJpaRepositories("expecto_codum.k_t_d")
@EnableTransactionManagement
public class DomainConfig {
}
