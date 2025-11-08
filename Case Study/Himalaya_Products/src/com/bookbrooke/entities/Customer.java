package com.bookbrooke.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    public double wallet = 1000;
    public List<Book> ownedBooks = new ArrayList<>();

    public Customer(int id, String name, String email) {
        super(id, name, email);
    }

	public Book[] getOwnedBooks() {
		// TODO Auto-generated method stub
		return null;
	}
}
