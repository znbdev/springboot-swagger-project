package com.example.demo.controller.common;

import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface CrudController<T, K, D> {

    @ApiOperation(value = "Get Entity by Primary Key")
    T get(K key);

    @ApiOperation(value = "Get All Entities")
    List<T> getAll();

    @ApiOperation(value = "Create an Entity")
    T create(D dto);

    @ApiOperation(value = "Update an Entity")
    T update(D dto);

    @ApiOperation(value = "Delete an Entity")
    void delete(T entity);
}

