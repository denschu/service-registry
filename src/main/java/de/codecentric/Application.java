package de.codecentric;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
    	File pid = new File("/Users/denschu/git/service-registry/target/service-registry.pid");
    	SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new ApplicationPidListener(pid));
        springApplication.run(args);
    }
}
