package com.voron.services;


import com.voron.repositories.PublicationRepository;
import com.voron.models.Publication;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PublicationService implements GenericService<Publication> {
    private final PublicationRepository publicationRepository;


    public void save(Publication entity) {
        log.info("Saving new {}",entity);
        publicationRepository.save(entity);
    }

    public Publication getById(Long id) {
        return publicationRepository.findById(id).orElse(null);

    }

    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    public void delete(Long id) {
        log.info("Deleting {}",publicationRepository.findById(id));
        publicationRepository.deleteById(id);
    }


}
