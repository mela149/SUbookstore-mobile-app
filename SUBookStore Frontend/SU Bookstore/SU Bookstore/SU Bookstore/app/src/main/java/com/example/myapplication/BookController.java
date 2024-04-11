package com.example.myapplication;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class BookController {

    private static List<Book> books = new ArrayList<>();
    private static List<Book> shoppingCart = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void addMultipleBook(List<Book> book) {
        books.addAll(book);
    }

    public static List<Book> getAllBooks() {
        return books;
    }

    public static List<Book> getBooksByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<>();
        Log.d("size", String.valueOf(books.size()));
        for (Book book : books) {
            if (Objects.equals(book.getCategory().toLowerCase(Locale.ROOT), category.toLowerCase(Locale.ROOT))) {
                booksByCategory.add(book);
            }
        }
        return booksByCategory;
    }

    public static List<Book> searchBooksFromPremadeList(List<Book> booksToSearch, String query) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : booksToSearch) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public static double getTotalPrice(List<Book> bookList){
        double totalPrice = 0.0;

        for (Book book : bookList) {
            try {
                double price = Double.parseDouble(book.getPrice());
                totalPrice += price;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return totalPrice;
       }


    public static String selectRandomImage(){
        Random random = new Random();
        int randomIndex = random.nextInt(books.size());
        return books.get(randomIndex).getImage();
    }

    public static List<Book> searchBooksFromAll(String query) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public static void addToCart(Book book) {
        shoppingCart.add(book);
    }

    public static List<Book> getShoppingCart() {
        return shoppingCart;
    }
}
