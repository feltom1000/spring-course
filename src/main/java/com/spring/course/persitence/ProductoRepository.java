package com.spring.course.persitence;

import com.spring.course.persitence.crud.ProductoCRUDRepository;
import com.spring.course.persitence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Esta clase se encarga de interactuar con la DB, porque contiene las operaciones que queremos
            // aplicar sobre nuestras tablas. Tambien existe @Component, que es una anotation general que
            // significa que la clase es un componente de Spring, @Repository, es especificar que clase de
            // component es.
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

    public Optional<Producto> getProducto(int idProducto){
        return productoCRUDRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCRUDRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCRUDRepository.deleteById(idProducto);
    }
}
