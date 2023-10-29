package com.voron.repositories.oldDAO;

import com.voron.repositories.ReaderRepository;
import com.voron.models.Reader;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ReaderDAOImpl implements GenericDAO<Reader> {
    private ReaderRepository readerRepository;

    public void save(Reader entity) {
       readerRepository.save(entity);
    }

    public Reader getById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    public void delete(Long id) {
        readerRepository.deleteById(id);
    }

    @Override
    public void update(Reader entity) {
        readerRepository.save(entity);
    }
}
