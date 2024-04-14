package librarymanagement.model;

public class Book {
    private int id;
    private String name;
    private String author;
    private String category;
    private boolean isAvailable;

    public Book(int id, String name, String author, String category, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
