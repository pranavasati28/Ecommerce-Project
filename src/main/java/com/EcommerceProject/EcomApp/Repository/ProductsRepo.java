package com.EcommerceProject.EcomApp.Repository;

import com.EcommerceProject.EcomApp.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository <Products,Integer> {

}
