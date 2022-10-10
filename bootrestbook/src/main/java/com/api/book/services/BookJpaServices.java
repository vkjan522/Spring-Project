package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookJpaServices {
	@Autowired
	private BookRepository bookRepositary;

	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepositary.findAll();
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepositary.findById(id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return book;
	}

	// adding the book
	public Book addBook(Book b) {
		Book result = bookRepositary.save(b);
		return result;
	}

	// delete book
	/*
	 * public void deleteBook(int bId) { list = list.stream().filter(book -> { if
	 * (book.getId() != bId) { return true; } else { return false; }
	 * }).collect(Collectors.toList()); }
	 */
	public void deleteBook(int bId) {
		bookRepositary.deleteById(bId);
	}

	// update book
	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
		bookRepositary.save(book);
	}
}
