package com.senacre.ecommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   @GetMapping("/bem-vindo")
    public String index() {
        return "index";
    }    

}
