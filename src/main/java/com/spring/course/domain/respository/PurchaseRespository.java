package com.spring.course.domain.respository;

import com.spring.course.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRespository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clienteId);
    Purchase save(Purchase purchase);
}
