package com.voron.repositories.oldDAO;
import java.util.List;

public interface GenericDAO<T> {
    void save(T entity);
    T getById(Long id);
    List<T> getAll();
    void delete(Long id);
     void update(T entity);
}
