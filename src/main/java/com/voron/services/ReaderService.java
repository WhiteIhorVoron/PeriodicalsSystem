package com.voron.services;


import com.voron.repositories.ReaderRepository;
import com.voron.models.Reader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ReaderService implements GenericService<Reader> {
 private final ReaderRepository readerRepository;

    public void save(Reader entity) {
        log.info("Saving new {}",entity);
        readerRepository.save(entity);
    }

    public Reader getById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    public void delete(Long id) {
        log.info("Deleting {}",readerRepository.findById(id));
        readerRepository.deleteById(id);
    }
}
