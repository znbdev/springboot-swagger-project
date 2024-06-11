package com.example.demo.service.common;

import java.util.List;
import java.util.Optional;

public interface RecordOperations<T, K> {

    List<T> findAll();

    Optional<T> findByPk(K key);

    T save(T entity);

    void delete(T entity);
}
