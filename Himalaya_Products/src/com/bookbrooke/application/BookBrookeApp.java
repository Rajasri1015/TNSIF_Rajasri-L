package com.bookbrooke.application;

import com.bookbrooke.entities.*;
import com.bookbrooke.services.*;
import java.util.*;

public class BookBrookeApp {
    static Scanner sc = new Scanner(System.in);
    static BookService bookService = new BookService();
    static RecommendationService recService = new RecommendationService();

    public static void main(String[] args) {
        Admin admin = new Admin(1, "Admin", "admin@bookbrooke.com");
        Author author = new Author(2, "Padma", "padma@bookbrooke.com");
        Customer customer = new Customer(3, "Nithya", "nithya@bookbrooke.com");

        bookService.addBook(new Book(100, "Atomic Habits", "James Clear", "Self-help", 500, "Available"));
        bookService.addBook(new Book(101, "Clean Code", "Robert Martin", "Programming", 900, "Available"));
        bookService.addBook(new Book(102, "Attitude is Everything", "George Williams", "Motivation", 700, "Not Available"));
        bookService.addBook(new Book(103, "Sherlock Holmes", "Arthur Conan Doyle", "Detective Fiction", 1000, "Available"));
        bookService.addBook(new Book(104, "Harry Potter", "JK Rowling", "Mystery", 5000, "Available"));

        loadingAnimation("🌊 Initializing BookBrooke");
        displayQuote();
        displayBanner();
        showSessionInfo();
        showBookOfTheWeek();

        int choice;
        do {
            System.out.println("\n🎯 MAIN MENU");
            System.out.println("1️⃣ Admin Login");
            System.out.println("2️⃣ Author Login");
            System.out.println("3️⃣ Customer Login");
            System.out.println("4️⃣ Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> adminMenu(admin);
                case 2 -> authorMenu(author);
                case 3 -> customerMenu(customer);
                case 4 -> typeEffect("👋 Thank you for visiting BookBrooke!", 25);
                default -> System.out.println("⚠ Invalid option!");
            }
        } while (choice != 4);
    }

    // ---------- Utility / Animation ----------
    static void loadingAnimation(String msg) {
        System.out.print("\n" + msg + "\n[");
        for (int i = 0; i < 25; i++) {
            try { Thread.sleep(100); System.out.print("█"); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println("] 100%\n");
    }

    static void typeEffect(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(delay); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println();
    }

    static void displayQuote() {
        String[] quotes = {
            "📖 'A reader lives a thousand lives before he dies.' – George R.R. Martin",
            "💡 'Books are uniquely portable magic.' – Stephen King",
            "🔥 'Today a reader, tomorrow a leader.' – Margaret Fuller",
            "🌊 'Reading is the bridge between ignorance and enlightenment.'"
        };
        Random r = new Random();
        System.out.println(quotes[r.nextInt(quotes.length)]);
        System.out.println("--------------------------------------------------");
    }

    static void displayBanner() {
        System.out.println("==================================================");
        typeEffect("              🌊  WELCOME TO BOOKBROOKE  🌊", 20);
        System.out.println("==================================================");
        typeEffect("       Where Stories Flow Between Every Mind", 20);
        System.out.println("==================================================");
    }

    static void showSessionInfo() {
        System.out.println("🕒 Session started: " + new java.util.Date());
        System.out.println("==================================================");
    }

    static void showBookOfTheWeek() {
        Book best = bookService.getTopRatedBook();
        if (best != null)
            System.out.println("🏆 Book of the Week: " + best.title + " by " +
                               best.authorName + " (⭐ " + best.getAverageRating() + ")");
        else
            System.out.println("🏆 Book of the Week: To be discovered...");
        System.out.println("--------------------------------------------------");
    }

    // ---------- MENUS ----------
    static void adminMenu(Admin a) {
        int ch;
        do {
            System.out.println("\n--- 🔧 ADMIN DASHBOARD ---");
            System.out.println("1. View All Books");
            System.out.println("2. View Pending Publications");
            System.out.println("3. Approve Publication");
            System.out.println("4. View Donations");
            System.out.println("5. View Analytics");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> bookService.showBooks();
                case 2 -> bookService.showPending();
                case 3 -> {
                    bookService.showPending();
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    bookService.approveBook(id);
                }
                case 4 -> bookService.showDonations();
                case 5 -> {
                    Book top = bookService.getTopRatedBook();
                    System.out.println("\n📊 Analytics:");
                    System.out.println("📈 Total Sales: " + bookService.totalSales);
                    if (top != null)
                        System.out.println("🏆 Top Rated: " + top.title + " (⭐ " + top.getAverageRating() + ")");
                    else
                        System.out.println("🏆 No rated books yet.");
                }
                case 6 -> System.out.println("🔒 Exiting Admin Menu...");
                default -> System.out.println("⚠ Invalid!");
            }
        } while (ch != 6);
    }

    static void authorMenu(Author a) {
        int ch;
        do {
            System.out.println("\n--- ✍ AUTHOR MENU ---");
            System.out.println("1. Publish Book");
            System.out.println("2. View My Books");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Title: "); String t = sc.nextLine();
                    System.out.print("Category: "); String c = sc.nextLine();
                    System.out.print("Price: "); double p = sc.nextDouble();
                    Book b = bookService.publishBook(t, a.name, c, p);
                    a.publishedBooks.add(b);
                }
                case 2 -> {
                    if (a.publishedBooks.isEmpty()) System.out.println("No books yet.");
                    else a.publishedBooks.forEach(System.out::println);
                }
                case 3 -> System.out.println("🔒 Exiting Author Menu...");
                default -> System.out.println("⚠ Invalid!");
            }
        } while (ch != 3);
    }

    static void customerMenu(Customer c) {
        int ch;
        do {
            System.out.println("\n--- 👩‍💻 CUSTOMER MENU ---");
            System.out.println("1. View Books");
            System.out.println("2. Buy Book");
            System.out.println("3. Donate Book");
            System.out.println("4. Rate Book");
            System.out.println("5. Get Recommendations");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> bookService.showBooks();

                case 2 -> {     
                    System.out.println("\n📚 Available Books for Purchase:");
                    boolean any = false;
                    for (Book b : bookService.allBooks) {
                        if (b.status.equals("Available")) {
                            System.out.println(b);
                            any = true;
                        }
                    }

                    if (!any) {
                        System.out.println("⚠ No books to buy.");
                        break;
                    }

                    System.out.print("\nEnter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear input buffer

                    Book b = bookService.findBookById(id);
                    if (b != null && b.status.equals("Available")) {
                        if (c.wallet >= b.price) { // ✅ Correct condition
                            c.wallet -= b.price;
                            b.status = "Sold";
                            bookService.recordSale();
                            System.out.println("✅ " + c.getName() + " bought '" + b.title + "' for ₹" + b.price);
                            System.out.println("💰 Remaining balance: ₹" + c.wallet);
                            System.out.println("📦 '" + b.title + "' will be delivered to your registered address within 3 days!");
                        } else {
                            System.out.println("❌ Insufficient balance! You have ₹" + c.wallet + ", but need ₹" + b.price);
                        }
                    } else {
                        System.out.println("⚠ Invalid Book ID or Book not available.");
                    }
                }

                case 3 -> {
                    System.out.print("Book Title: "); String t = sc.nextLine();
                    System.out.print("Organization: "); String org = sc.nextLine();
                    bookService.donateBook(t, org);
                }

                case 4 -> {
                    System.out.println("\n📚 Books Available to Rate:");
                    boolean anyBook = false;
                    for (Book b : bookService.allBooks) {
                        if (!b.status.equals("Pending Approval")) {
                            System.out.println(b);
                            anyBook = true;
                        }
                    }
                    if (!anyBook) {
                        System.out.println("⚠ No books to rate.");
                        break;
                    }
                    System.out.print("\nEnter Book ID: ");
                    int id = sc.nextInt();
                    Book b = bookService.findBookById(id);
                    if (b != null && !b.status.equals("Pending Approval")) {
                        System.out.print("Rating (1–5): ");
                        int rating = sc.nextInt();
                        if (rating >= 1 && rating <= 5) {
                            b.ratingSum += rating;
                            b.ratingCount++;
                            System.out.println("⭐ You rated '" + b.title + "' " + rating + " stars!");
                        } else System.out.println("⚠ Invalid rating!");
                    } else System.out.println("❌ Invalid Book ID.");
                }

                case 5 -> {
                    System.out.print("Category: ");
                    String cat = sc.nextLine();
                    recService.recommend(bookService.allBooks, cat);
                }

                case 6 -> System.out.println("👋 Exiting Customer Menu...");
                default -> System.out.println("⚠ Invalid!");
            }
        } while (ch != 6);
    }
}