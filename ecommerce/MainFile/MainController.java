package com.ecommerce.MainFile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    
    @GetMapping("/")
    public String Main() {
        System.out.println("Monu.....................katyiyart");
        return "index";
    }

}
