package com.spring.course.persitence;

import com.spring.course.domain.Product;
import com.spring.course.domain.respository.ProductRepository;
import com.spring.course.persitence.crud.ProductoCRUDRepository;
import com.spring.course.persitence.entity.Producto;
import com.spring.course.persitence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Esta clase se encarga de interactuar con la DB, porque contiene las operaciones que queremos
            // aplicar sobre nuestras tablas. Tambien existe @Component, que es una anotation general que
            // significa que la clase es un componente de Spring, @Repository, es especificar que clase de
            // component es.
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCRUDRepository productoCRUDRepository;
    @Autowired
    private ProductMapper mapper;
    //Interactuo con la DB y me devuelve los objetos que yo necesito a travez de toProduct();


//    public List<Producto> getAll(){
//        return (List<Producto>) productoCRUDRepository.findAll();
//    }
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCRUDRepository.findAll();
        return mapper.toProducts(productos);
    }


    //    public List<Producto> getProductosByCategoria(int idCategoria){
    //        return productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    //    }
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }


//    public Optional<List<Producto>> getEscasos(int cantidad){
//        return productoCRUDRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
//    }
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCRUDRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }


    //    public Optional<Producto> getProducto(int idProducto){
    //        return productoCRUDRepository.findById(idProducto);
    //    }
    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<Producto> productos = productoCRUDRepository.findById(productId);
        return productos.map(producto -> mapper.toProduct(producto));
    }


    //    public Producto save(Producto producto){
    //        return productoCRUDRepository.save(producto);
    //    }
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCRUDRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCRUDRepository.deleteById(productId);
    }
}
