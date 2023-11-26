package com.senacre.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senacre.ecommerce.Service.ClienteService;
import com.senacre.ecommerce.client.Cliente;

@Controller
public class ClienteController {

   /* @Autowired
    private ClienteRepository repository; */

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Login");
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cliente", new Cliente());
        mv.setViewName("/login/cadastrar");
        return mv;
    }

    @PostMapping("salvarCliente")
    public ModelAndView cadastrar(Cliente cliente) throws Exception {
        ModelAndView mv = new ModelAndView();
        clienteService.salvarCliente(cliente);
        mv.setViewName("redirect:/");
        return mv;
    }
}
