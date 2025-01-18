package com.example.dao;
import com.example.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class BookDAO {
    @PersistenceContext
    private EntityManager em;

    public void create(Book book) {
        em.persist(book);
    }

    public Book find(Long id) {
        return em.find(Book.class, id);
    }

    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }
}
