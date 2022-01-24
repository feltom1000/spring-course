package com.spring.course.web.controller;

import com.spring.course.domain.Product;
import com.spring.course.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController //Indica que va a ser un controlador de una API Rest
@RequestMapping("/products") //path, ruta para el url de pagina de este controlador.
public class ProductController {
    @Autowired
    private ProductService productService; //inyecto el servicio

    //implemento todos los metodos del service.

    public List<Product> getAll(){
        return productService.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productService.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productService.save(product);
    }

    public boolean delete(int productId){
        return productService.delete(productId);
    }
}
