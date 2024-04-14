package librarymanagement.service;

import librarymanagement.model.Book;
import librarymanagement.model.Library;

public class BookService {
    private Library library;

    public BookService(Library library) {
        this.library = library;
    }

    public void addBook(Book book){
        library.getBooks().put(book.getId(),book);
    }

    public void updateBook(int bookId,Book updatedBook){
        if(library.getBooks().containsKey(bookId)){
            library.getBooks().put(bookId,updatedBook);
            System.out.println("Book updated successfully.");
        }else {
            System.out.println("Book not found");
        }
    }

    public void deleteBook(int bookId){
        if(library.getBooks().containsKey(bookId)){
            library.getBooks().remove(bookId);
            System.out.println("Book deleted successfully.");
        }else{
            System.out.println("Book not found.");
        }
    }
}
