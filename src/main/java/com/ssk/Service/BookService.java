package com.ssk.Service;

import com.ssk.Entity.Book;

import java.util.List;

public interface BookService {

    public String upsertBook(Book book);

    public List<Book> getAllBooks();

    public String deleteBook(Integer bookId);
}
