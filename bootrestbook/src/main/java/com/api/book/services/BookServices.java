package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;

@Component
public class BookServices {

	private static List<Book> list = new ArrayList<>();

	/*
	 * static {
	 * 
	 * list.add(new Book(123, "Python", "cfg")); list.add(new Book(345, "java",
	 * "abc")); list.add(new Book(555, "spring boot", "spr")); list.add(new
	 * Book(333, "rest API", "API")); list.add(new Book(555, "PostMan", "pqr"));
	 * 
	 * }
	 */

// getting books
	public List<Book> getAllBooks() {
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		return book;
	}

	// adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	// delete book
	/*
	 * public void deleteBook(int bId) { list = list.stream().filter(book -> { if
	 * (book.getId() != bId) { return true; } else { return false; }
	 * }).collect(Collectors.toList()); }
	 */
	public void deleteBook(int bId) {
		list = list.stream().filter(book -> book.getId() != bId).collect(Collectors.toList());
	}

	// update book
	public void updateBook(Book book, int bookId) {

		list = list.stream().map(b -> {
			if (b.getId() == bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());

	}

}
