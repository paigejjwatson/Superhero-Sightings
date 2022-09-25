package paige.superherosightings.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"paige"})
@EntityScan("paige")
@EnableJpaRepositories("paige")
public class SuperheroSightingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperheroSightingsApplication.class, args);
    }

}
