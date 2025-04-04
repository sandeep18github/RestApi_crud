package com.ssk.Service;

import com.ssk.Entity.Book;
import com.ssk.Repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    private BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public String upsertBook(Book book) {
        Integer bookId = book.getBookId();

        repository.save(book);

        if (bookId == null) {
            return "record inserted";
        } else {
            return "record updated";
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public String deleteBook(Integer bookId) {
        repository.deleteById(bookId);
        return "record deleted";
    }
}
