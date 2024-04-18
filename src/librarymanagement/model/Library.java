package librarymanagement.model;

import java.util.List;
import java.util.Map;

public class Library {
    private Map<Integer,Book> books;

    private List<User> users;

    public Library(Map<Integer, Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.set(user.getId(),user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }


}