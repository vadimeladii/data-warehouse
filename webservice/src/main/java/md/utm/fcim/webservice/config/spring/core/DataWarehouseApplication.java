package md.utm.fcim.webservice.config.spring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "md.utm.fcim")
@EntityScan("md.utm.fcim")
@EnableJpaRepositories("md.utm.fcim")
public class DataWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataWarehouseApplication.class, args);
	}
}
