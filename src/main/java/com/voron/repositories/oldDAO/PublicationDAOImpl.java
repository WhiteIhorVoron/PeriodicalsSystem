package com.voron.repositories.oldDAO;

import com.voron.models.Publication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class PublicationDAOImpl implements GenericDAO<Publication>{

    @PersistenceContext
    private EntityManager entityManager;
    public void save(Publication entity) {
        entityManager.persist(entity);
    }

    public Publication getById(Long id) {
        return entityManager.find(Publication.class, id);
    }

    public List<Publication> getAll() {
        return entityManager.createQuery("SELECT p FROM Publication p",Publication.class)
                .getResultList();
    }

    public void delete(Long id) {
        String jpql = "DELETE FROM Publication e WHERE e.id = :id";
        entityManager.createQuery(jpql)
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    public void update(Publication entity) {
        entityManager.merge(entity);
    }
}
