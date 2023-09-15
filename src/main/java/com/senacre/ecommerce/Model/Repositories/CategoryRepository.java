package com.senacre.ecommerce.Model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senacre.ecommerce.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
