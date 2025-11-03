package com.bookbrooke.entities;

import java.util.ArrayList;
import java.util.List;

public class Author extends Customer {
    public List<Book> publishedBooks = new ArrayList<>();

    public Author(int id, String name, String email) {
        super(id, name, email);
    }

	public Book[] getPublishedBooks() {
		// TODO Auto-generated method stub
		return null;
	}
}