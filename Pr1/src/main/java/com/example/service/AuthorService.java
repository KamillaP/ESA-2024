package com.example.service;
import com.example.dao.AuthorDAO;
import com.example.entities.Author;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class AuthorService {
    @Inject
    private AuthorDAO authorDAO;

    public void createAuthor(Author author) {
        authorDAO.create(author);
    }

    public List<Author> listAuthors() {
        return authorDAO.findAll();
    }
}