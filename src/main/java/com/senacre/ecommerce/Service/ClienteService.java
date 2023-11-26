package com.senacre.ecommerce.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senacre.ecommerce.Model.Repositories.ClienteRepository;
import com.senacre.ecommerce.client.Cliente;
import com.senacre.ecommerce.exceptions.CriptoExistException;
import com.senacre.ecommerce.exceptions.EmailExistsException;
import com.senacre.ecommerce.util.Util;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Long id){
      Optional<Cliente> obj = repository.findById(id);
      return obj.get();
    }

    public Cliente insert(Cliente obj) {
      return repository.save(obj);
    }
    
    public void salvarCliente(Cliente cliente) throws Exception {
      try {
        if (repository.findByEmail(cliente.getEmail()) != null) {
          throw new EmailExistsException("Já existe um email cadastradao para: " + cliente.getEmail());
        }
        cliente.setSenha(Util.md5(cliente.getSenha()));

      } catch (NoSuchAlgorithmException e) {
        throw new CriptoExistException("Erro na criptografia da senha");
      }

      repository.save(cliente);
    }
}
