package com.example.service;
import com.example.dao.BookDAO;
import com.example.entities.Book;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class BookService {
    @Inject
    private BookDAO bookDAO;

    public void createBook(Book book) {
        bookDAO.create(book);
    }

    public List<Book> listBooks() {
        return bookDAO.findAll();
    }
}
