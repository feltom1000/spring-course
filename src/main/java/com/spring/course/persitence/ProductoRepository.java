package com.spring.course.persitence;

import com.spring.course.persitence.crud.ProductoCRUDRepository;
import com.spring.course.persitence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCRUDRepository productoCRUDRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCRUDRepository.findAll();
    }
}
