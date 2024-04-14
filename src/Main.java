import librarymanagement.model.*;
import librarymanagement.service.BookService;
import librarymanagement.service.InvoiceService;
import librarymanagement.service.LibraryService;
import librarymanagement.service.UserService;
import librarymanagement.ui.LibraryConsoleApp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users=new ArrayList<>();
        User librarian=new Librarian(1,"Ali");
        User user1=new User(1,"Ahmet");
        users.add(librarian);
        Map<Integer,Book> books= new HashMap<>();
        Book book1=new Book(1,"asffasfas","asfasfafssf","asfafafsafafs",true);
        books.put(1,book1);
        Library library=new Library(books,users);

        Invoice invoice=new Invoice(1,2,new Date(),new Date(System.currentTimeMillis()+100000),0);
        List<Invoice> invoices=new ArrayList<>();
        invoices.add(invoice);

        BookService bookService=new BookService(library);
        InvoiceService invoiceService=new InvoiceService(invoices,library);
        LibraryService libraryService=new LibraryService(library);
        UserService userService=new UserService(library);

        LibraryConsoleApp console=new LibraryConsoleApp(bookService,userService,libraryService,invoiceService);

        console.start(user1);


    }
}