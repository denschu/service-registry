package de.codecentric;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceRegistryController {

	@RequestMapping("/services")
    public @ResponseBody String services(
            @RequestParam(value="serviceName", required=true) String serviceName, @RequestParam(value="serviceVersion", required=false) String serviceVersion) {
		if(serviceName.equals("service1")){
			return "localhost:8082/service1";
		}else if(serviceName.equals("service2")){
			return "localhost:8082/service2";
		}
		return "localhost:8082/service1";
        
    }
	
}
