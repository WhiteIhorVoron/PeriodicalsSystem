package com.voron.repositories.oldDAO;

import com.voron.models.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscriptionDAOImpl implements GenericDAO<Subscription> {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Subscription entity) {
        entityManager.persist(entity);
    }

    public Subscription getById(Long id) {
        return entityManager.find(Subscription.class,id);
    }

    public List<Subscription> getAll() {
        return entityManager.createQuery("SELECT s FROM Subscription s",Subscription.class)
                .getResultList();
    }

    public void delete(Long id) {
        String jpql = "DELETE FROM subscriptions e WHERE e.id = :id";
        entityManager.createQuery(jpql)
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    public void update(Subscription entity) {
        entityManager.merge(entity);
    }
}
