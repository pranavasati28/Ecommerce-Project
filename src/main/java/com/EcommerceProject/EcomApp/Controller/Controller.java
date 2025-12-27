package com.EcommerceProject.EcomApp.Controller;

import com.EcommerceProject.EcomApp.Models.Products;
import com.EcommerceProject.EcomApp.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ResponseEntity<List<Products>> GetProducts(){
        return new ResponseEntity<>(productservice.GetAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/add_product")
    public ResponseEntity<?> AddProduct(@RequestPart Products product,
                                        @RequestPart MultipartFile imageFile){
        try {
            return new ResponseEntity<>(productservice.AddProduct(product, imageFile) , HttpStatus.CREATED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> UpdateProduct(@RequestPart Products product, @RequestPart MultipartFile imageFile) throws IOException {
        return new ResponseEntity<>(productservice.UpdateProduct(product, imageFile), HttpStatus.UPGRADE_REQUIRED);
    }

    @DeleteMapping("/{Prodid}")
    public void DeleteProductById(@RequestBody Integer Prodid){
        productservice.DeleteProduct(Prodid);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Products> findById(@PathVariable int id){
        return new ResponseEntity<>(productservice.findById(id), HttpStatus.OK);
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable Integer productId){
        Products product = productservice.findById(productId);
        byte[] imageFile = product.getImageData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

}
