package librarymanagement.ui;

import librarymanagement.service.BookService;
import librarymanagement.service.InvoiceService;
import librarymanagement.service.LibraryService;
import librarymanagement.service.UserService;

import java.util.Scanner;

public class LibraryConsoleApp {
    private BookService bookService;
    private UserService userService;
    private LibraryService libraryService;
    private InvoiceService invoiceService;
    private Scanner scanner;

    public LibraryConsoleApp(BookService bookService, UserService userService, LibraryService libraryService, InvoiceService invoiceService, Scanner scanner) {
        this.bookService = bookService;
        this.userService = userService;
        this.libraryService = libraryService;
        this.invoiceService = invoiceService;
        this.scanner = scanner;
    }
}
