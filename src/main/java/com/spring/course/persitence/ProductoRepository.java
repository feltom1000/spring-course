package com.spring.course.persitence;

import com.spring.course.persitence.crud.ProductoCRUDRepository;
import com.spring.course.persitence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCRUDRepository productoCRUDRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCRUDRepository.findAll();
    }

    public List<Producto> getProductosByCategoria(int idCategoria){
        return productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCRUDRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
