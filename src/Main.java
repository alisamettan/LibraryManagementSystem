import librarymanagement.database.Books;
import librarymanagement.database.Users;
import librarymanagement.model.*;
import librarymanagement.service.BookService;
import librarymanagement.service.InvoiceService;
import librarymanagement.service.LibraryService;
import librarymanagement.service.UserService;
import librarymanagement.ui.LibraryConsoleApp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Users data
        Users users=new Users();

        //----------
        User librarian=new Librarian(1,"Alara Karacabey");

        //Books data
        Books books=new Books();
        Library library=new Library(books.getBooks(),users.getUsers());

        Invoice invoice=new Invoice(1,2,new Date(),new Date(System.currentTimeMillis()+100000),0);
        List<Invoice> invoices=new ArrayList<>();
        invoices.add(invoice);

        BookService bookService=new BookService(library);
        InvoiceService invoiceService=new InvoiceService(invoices,library);
        LibraryService libraryService=new LibraryService(library);
        UserService userService=new UserService(library);

        LibraryConsoleApp console=new LibraryConsoleApp(bookService,userService,libraryService,invoiceService);

        console.start(librarian);


    }
}