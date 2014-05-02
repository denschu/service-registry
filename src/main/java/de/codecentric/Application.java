package de.codecentric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import de.codecentric.domain.Service;
import de.codecentric.repository.ServiceRepository;

@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:environment.properties")

public class Application {

    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    	
    	ServiceRepository repository = context.getBean(ServiceRepository.class);
    	
        // fetch all services
        Iterable<Service> services = repository.findAll();
        System.out.println("Services loaded:");
        System.out.println("-------------------------------");
        for (Service service : services) {
            System.out.println(service);
        }
        System.out.println();
    }
}
