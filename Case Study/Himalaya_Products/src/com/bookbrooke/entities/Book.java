package com.bookbrooke.entities;

public class Book {
    public int id;
    public String title;
    public String authorName;
    public String category;
    public double price;
    public String status; // Available | Pending Approval | Sold
    public int ratingSum = 0;
    public int ratingCount = 0;

    public Book(int id, String title, String author, String category, double price, String status) {
        this.id = id;
        this.title = title;
        this.authorName = author;
        this.category = category;
        this.price = price;
        this.status = status;
    }

    public double getAverageRating() {
        if (ratingCount == 0) return 0.0;
        return Math.round(((double) ratingSum / ratingCount) * 10.0) / 10.0;
    }

    @Override
    public String toString() {
        return "📘 [" + id + "] " + title + " | Author: " + authorName +
               " | Category: " + category + " | ₹" + price +
               " | ⭐ " + getAverageRating() + " | Status: " + status;
    }

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
}