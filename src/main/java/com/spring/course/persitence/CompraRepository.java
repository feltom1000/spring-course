package com.spring.course.persitence;

import com.spring.course.domain.Purchase;
import com.spring.course.domain.respository.PurchaseRespository;
import com.spring.course.persitence.crud.CompraCRUDRepository;
import com.spring.course.persitence.entity.Compra;
import com.spring.course.persitence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRespository {
    @Autowired
    private CompraCRUDRepository compraCRUDRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCRUDRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clienteId) {
        return compraCRUDRepository.findByIdCliente(clienteId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(compraCRUDRepository.save(compra));
    }
}
