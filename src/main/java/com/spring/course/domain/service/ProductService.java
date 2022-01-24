package com.spring.course.domain.service;

import com.spring.course.domain.Product;
import com.spring.course.domain.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Esta clase sirve como un negociador o intermediario entre el controlador y la capa del repositorio.
//Tiene la implementacion de los mismos metodos de la interface ProductRepository.

@Service //Tmb reemplazable por @Component, @Service es mas especifico.
public class ProductService {
    @Autowired //Declaro una variable que apunta a la interface, y pongo @Autowired para que instancié
                // la clase que la implementa.
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        if (getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }
//        return getProduct(productId).map(poduct -> {
//            productRepository.delete(productId);
//            return true;
//        }).orElse(false);
    }
}
