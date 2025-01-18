package com.library.controller;

import com.library.model.Author;
import com.library.model.Book;
import com.library.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public String viewBooks(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        return "books";
    }

    @GetMapping("/authors")
    public String viewAuthors(Model model) {
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "authors";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam String title, @RequestParam String genre, @RequestParam int authorId) {
        Author author = libraryService.getAllAuthors().stream()
                .filter(a -> a.getId() == authorId)
                .findFirst()
                .orElse(null);

        if (author != null) {
            Book book = new Book();
            book.setTitle(title);
            book.setGenre(genre);
            book.setAuthor(author);
            libraryService.addBook(book);
        }

        return "redirect:/books";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestParam String name, @RequestParam String country) {
        Author author = new Author();
        author.setName(name);
        author.setCountry(country);
        libraryService.addAuthor(author);

        return "redirect:/authors";
    }
}
