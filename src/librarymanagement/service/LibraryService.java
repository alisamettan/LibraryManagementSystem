package librarymanagement.service;

import librarymanagement.model.Book;
import librarymanagement.model.Library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public Map<Integer,Book> getBooks(){
       return library.getBooks();
    }



    public Map<Integer,Book> getBooksByCategory(String category){
        Map<Integer,Book> booksByCategory=new HashMap<>();

        for(int bookId:library.getBooks().keySet()){
            Book book=library.getBooks().get(bookId);
            if(book.getCategory().equals(category)){
                booksByCategory.put(bookId,book);
            }

        }
        return booksByCategory;
    }

    public Map<Integer,Book> getBooksByAuthor(String author){
        Map<Integer,Book> booksByAuthor=new HashMap<>();

        for(int bookId:library.getBooks().keySet()){
            Book book=library.getBooks().get(bookId);
            if(book.getAuthor().equals(author)){
                booksByAuthor.put(bookId,book);
            }
        }
        return booksByAuthor;
    }

}
