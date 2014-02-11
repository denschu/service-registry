package de.codecentric;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceRegistryController {

	@RequestMapping("/services")
    public @ResponseBody List<Service> showServices() {
		List<Service> services = new ArrayList<Service>();
		services.add(new Service("service1","1","localhost:8082/service1"));
		services.add(new Service("service2","1","localhost:8082/service2"));
		return services;
        
    }

	@RequestMapping("/services/{name}/versions/{version}")
    public @ResponseBody String showServiceUrl(
            @PathVariable(value="name") String name, @PathVariable(value="version") String version) {
		if(name.equals("service1")){
			return "localhost:8082/service1";
		}else if(name.equals("service2")){
			return "localhost:8082/service2";
		}
		return "localhost:8082/service1";
        
    }
	
}
