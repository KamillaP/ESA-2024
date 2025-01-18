package com.example.dao;
import com.example.entities.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class AuthorDAO {
    @PersistenceContext
    private EntityManager em;

    public void create(Author author) {
        em.persist(author);
    }

    public Author find(Long id) {
        return em.find(Author.class, id);
    }

    public List<Author> findAll() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }
}