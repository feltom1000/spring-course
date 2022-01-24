package com.spring.course.persitence.crud;

import com.spring.course.persitence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCRUDRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
