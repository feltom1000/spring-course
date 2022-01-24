package com.spring.course.web.controller;

import com.spring.course.domain.Product;
import com.spring.course.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Indica que va a ser un controlador de una API Rest
@RequestMapping("/products") //path, ruta para el url de pagina de este controlador.
public class ProductController {
    @Autowired
    private ProductService productService; //inyecto el servicio

    //implemento todos los metodos del service.

    @GetMapping("/all") //Para obtener informacion, como parametro va el path.
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){ //Anotation para pasar variable x path
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId")int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save") //porque es para enviar informacion, o guardar en este caso
                    //@RequestBody xq el producto no va a viajar dentro del path, si no que va a ser parte
                    // del cuerpo de la peticion
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
