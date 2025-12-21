package com.EcommerceProject.EcomApp.Service;

import com.EcommerceProject.EcomApp.Models.Products;
import com.EcommerceProject.EcomApp.Repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductsRepo Repo;

    @Autowired
    private Products Products;

    public List<Products> GetAllProducts(){
        return Repo.findAll();
    }
    public Products findById(Integer id){
        return Repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public void AddProduct(Products product){
        Repo.save(product);
    }

    public void UpdateProduct(Products product){
        Repo.save(product);
    }

    public void DeleteProduct(Integer Id){
        Repo.deleteById(Id);
    }

}
