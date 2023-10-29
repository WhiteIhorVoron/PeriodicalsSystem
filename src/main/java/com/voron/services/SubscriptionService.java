package com.voron.services;


import com.voron.repositories.SubscriptionRepository;
import com.voron.models.Subscription;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class SubscriptionService implements GenericService<Subscription>{
private final SubscriptionRepository subscriptionRepository;


    public void save(Subscription entity) {
        log.info("Saving new {}",entity);
        subscriptionRepository.save(entity);
    }

    public Subscription getById(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    public void delete(Long id) {
        log.info("Deleting {}",subscriptionRepository.findById(id));
        subscriptionRepository.deleteById(id);
    }
}
