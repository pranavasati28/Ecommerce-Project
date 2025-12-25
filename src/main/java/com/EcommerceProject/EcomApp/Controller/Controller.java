package com.EcommerceProject.EcomApp.Controller;

import com.EcommerceProject.EcomApp.Models.Products;
import com.EcommerceProject.EcomApp.Service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {

    private final ProductService productservice;
    Controller(ProductService productservice){
        this.productservice = productservice;
    }

    @GetMapping("/products")
    public List<Products> GetProducts(){
        return productservice.GetAllProducts();
    }

    @PostMapping("/add_product")
    public void AddProduct(@RequestBody Products product){
        productservice.AddProduct(product);
    }

    @PutMapping
    public void UpdateProduct(@RequestBody Products product){
        productservice.UpdateProduct(product);
    }

    @DeleteMapping("/{Prodid}")
    public void DeleteProductById(@RequestBody Integer Prodid){
        productservice.DeleteProduct(Prodid);
    }

    @GetMapping("/{id}")
    public Products findById(@PathVariable int id){
        return productservice.findById(id);
    }

}
