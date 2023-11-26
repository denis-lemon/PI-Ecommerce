package com.senacre.ecommerce.Model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.senacre.ecommerce.client.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("select i from Cliente i where i.email = :email")
    public Cliente findByEmail(String email);
}
