package md.utm.fcim.webservice.config.spring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"md.utm.fcim.repository", "md.utm.fcim.service", "md.utm.fcim.webservice"})
@EntityScan({"md.utm.fcim.repository", "md.utm.fcim.service", "md.utm.fcim.webservice"})
@EnableJpaRepositories({"md.utm.fcim.repository", "md.utm.fcim.service", "md.utm.fcim.webservice"})
public class DataWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataWarehouseApplication.class, args);
	}
}
