package com.bookbrooke.services;

import java.util.*;
import com.bookbrooke.entities.*;

public class RequestService {
    private List<BookRequest> requests = new ArrayList<>();

    // Add a new request
    public void addRequest(String title, String requesterName) {
        requests.add(new BookRequest(title, requesterName));
        System.out.println("✅ Request added for book: " + title); 
    }

    // Find owner who has this book
    public void findOwner(String title, List<Book> books, List<Author> authors, List<Customer> customers) {
        boolean found = false;

        for (Author a : authors) {
            for (Book b : a.getPublishedBooks()) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    System.out.println("📗 " + a.getName() + " (Author) owns this book: " + b.getTitle());
                    found = true;
                }
            }
        }

        for (Customer c : customers) {
            for (Book b : c.getOwnedBooks()) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    System.out.println("📘 " + c.getName() + " (Customer) owns this book: " + b.getTitle());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("❌ No owner currently has this book.");
        }
    }

    // View all pending requests (for admin or owners)
    public void showAllRequests() {
        if (requests.isEmpty()) {
            System.out.println("📭 No book requests yet.");
        } else {
            System.out.println("\n📚 Pending Book Requests:");
            requests.forEach(System.out::println);
        }
    }
}