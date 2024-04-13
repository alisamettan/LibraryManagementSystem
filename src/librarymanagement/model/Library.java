package librarymanagement.model;

import java.util.Map;

public class Library {
    private Map<String,Book> books;

    private Map<String,User> users;

    public Library(Map<String, Book> books, Map<String, User> users) {
        this.books = books;
        this.users = users;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public Map<String, User> getUsers() {
        return users;
    }
}