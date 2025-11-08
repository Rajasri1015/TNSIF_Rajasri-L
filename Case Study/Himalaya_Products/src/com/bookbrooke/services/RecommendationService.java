package com.bookbrooke.services;

import com.bookbrooke.entities.Book;
import java.util.*;

public class RecommendationService {
    public void recommend(List<Book> books, String category) {
        System.out.println("\n💡 Recommendations for '" + category + "':");
        boolean found = false;
        for (Book b : books)
            if (b.category.equalsIgnoreCase(category) && b.status.equals("Available")) {
                System.out.println("🔹 " + b.title + " by " + b.authorName + " (₹" + b.price + ")");
                found = true;
            }
        if (!found) System.out.println("😕 No books found in that category.");
    }
}
