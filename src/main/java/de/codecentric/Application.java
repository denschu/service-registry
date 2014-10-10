package de.codecentric;

import java.io.File;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
    	Properties argguments = StringUtils.splitArrayElementsIntoProperties(args, "=");
    	File pid = new File(argguments.getProperty("--pid.file","target/pid.file"));
    	SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new ApplicationPidListener(pid));
        springApplication.run(args);
    }
}
