package de.codecentric;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceRegistryController {

	@RequestMapping("/services")
    public @ResponseBody String services(
            @RequestParam(value="serviceName", required=false, defaultValue="World") String serviceName) {
        return "localhost:8082/service1";
    }
	
}
