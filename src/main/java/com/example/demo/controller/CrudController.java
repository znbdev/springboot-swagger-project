package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

public interface CrudController<T> {

    @ApiOperation(value = "Get Entity by ID")
    Optional<T> get(Long id);

    @ApiOperation(value = "Get All Entities")
    List<T> getAll();

    @ApiOperation(value = "Create an Entity")
    T create(T entity);

    @ApiOperation(value = "Update an Entity")
    T update(Long id, T entity);

    @ApiOperation(value = "Delete an Entity")
    void delete(Long id);
}

