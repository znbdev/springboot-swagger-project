package com.example.demo.service;

import java.util.List;
import java.util.Optional;

/**
 * @param <T>
 * @param <ID>
 */
public interface CrudService<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T entity);

    T update(T entity);

    void deleteById(ID id);
}
