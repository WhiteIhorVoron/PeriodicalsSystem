package com.voron.services;

import java.util.List;

public interface GenericService<T> {
    void save(T entity);
    T getById(Long id);
    List<T> getAll();
    void delete(Long id);
}
