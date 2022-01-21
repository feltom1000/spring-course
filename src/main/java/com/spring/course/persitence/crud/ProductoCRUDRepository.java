package com.spring.course.persitence.crud;

import com.spring.course.persitence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

                                        //Recibe como parametros la Tabla y el tipo de de su PK
public interface ProductoCRUDRepository extends CrudRepository<Producto, Integer> {
}
