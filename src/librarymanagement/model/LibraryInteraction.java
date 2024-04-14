package librarymanagement.model;

public interface LibraryInteraction {
    void addBook(Book book);
    void deleteBook(int bookId);
    void updateBook(int bookId,Book updatedBook);
}
