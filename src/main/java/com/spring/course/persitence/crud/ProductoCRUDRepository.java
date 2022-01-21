package com.spring.course.persitence.crud;

import com.spring.course.persitence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Recibe como parametros la Tabla y el tipo de de su PK
public interface ProductoCRUDRepository extends CrudRepository<Producto, Integer> {

    //Manera nativa de Consulta SQL:
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getByCategoria(int idCategoria);

    //O una mejor practica es utilizar los QueryMethods, que por una convencion de sintaxis ya entienden que hacer:
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
