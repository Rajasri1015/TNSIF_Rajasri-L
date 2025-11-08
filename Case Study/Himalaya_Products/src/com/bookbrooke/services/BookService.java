package com.bookbrooke.services;

import com.bookbrooke.entities.*;
import java.util.*;

public class BookService {
    public List<Book> allBooks = new ArrayList<>();
    public List<Book> pending = new ArrayList<>();
    public Map<String, Integer> donations = new HashMap<>();
    public int totalSales = 0, nextBookId = 200;

    public void addBook(Book b) { allBooks.add(b); }

    public Book publishBook(String title, String author, String cat, double price) {
        Book b = new Book(nextBookId++, title, author, cat, price, "Pending Approval");
        pending.add(b);
        System.out.println("🕒 '" + title + "' submitted for admin approval.");
        return b;
    }

    public boolean approveBook(int id) {
        for (Book b : pending) {
            if (b.id == id) {
                b.status = "Available";
                allBooks.add(b);
                pending.remove(b);
                System.out.println("✅ '" + b.title + "' is now available to readers!");
                return true;
            }
        }
        System.out.println("⚠ Invalid Book ID.");
        return false;
    }

    public Book findBookById(int id) {
        for (Book b : allBooks) if (b.id == id) return b;
        for (Book b : pending) if (b.id == id) return b;
        return null;
    }

    public void recordSale() { totalSales++; }

    public void donateBook(String title, String org) {
        donations.put(org, donations.getOrDefault(org, 0) + 1);
        System.out.println("🎁 Donated '" + title + "' to " + org);
    }

    public void showBooks() {
        if (allBooks.isEmpty()) System.out.println("No books available!");
        else allBooks.forEach(System.out::println);
    }

    public void showPending() {
        if (pending.isEmpty()) System.out.println("No pending publications.");
        else pending.forEach(System.out::println);
    }

    public void showDonations() {
        if (donations.isEmpty()) System.out.println("No donations yet.");
        else {
            System.out.println("\n🎁 Donation Impact:");
            donations.forEach((k, v) -> System.out.println("📦 " + k + " - " + v + " books"));
        }
    }

    public Book getTopRatedBook() {
        return allBooks.stream()
                .filter(b -> b.ratingCount > 0)
                .max(Comparator.comparingDouble(Book::getAverageRating))
                .orElse(null);
    }
}