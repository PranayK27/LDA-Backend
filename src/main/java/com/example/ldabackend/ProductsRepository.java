package com.example.ldabackend;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Override
    default List<Products> findAll() {
        return null;
    }

    @Override
    default List<Products> findAll(Sort sort) {
        return null;
    }

    @Override
    default List<Products> findAllById(Iterable<Long> longs) {
        return null;
    }
}
