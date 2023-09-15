package com.senacre.ecommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

/*  @Autowired
    private UserRepository userRepository;

    @GetMapping("/cadastro")
    public String cadastrar(Model model) {
        return "Cadastro";
    }

    @PostMapping("novo/cadastrar")
    public String novoUser(@Validated Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/cadastro";
        }

        userRepository.save(usuario);

        return "redirect:/index";
    } */  

    @GetMapping("/home")
    public String home() {
        return "index";
    }


    @GetMapping("novo/cadastrar")
    public String cadastraUsuario() {
        return "cadastro";
    }
    
}
