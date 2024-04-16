package librarymanagement.ui;

import librarymanagement.model.Book;
import librarymanagement.model.Librarian;
import librarymanagement.model.User;
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

    public LibraryConsoleApp(BookService bookService, UserService userService, LibraryService libraryService, InvoiceService invoiceService) {
        this.bookService = bookService;
        this.userService = userService;
        this.libraryService = libraryService;
        this.invoiceService = invoiceService;
        this.scanner = new Scanner(System.in);
    }

    public void start(User user){
        int choice;

        do{
            System.out.println("Library Management System");
            System.out.println("1.Add Book");
            System.out.println("2.Update Book");
            System.out.println("3.Delete Book");
            System.out.println("4.Borrow Book");
            System.out.println("5.Return Book");
            System.out.println("6.List Books");
            System.out.println("7.Exit");
            System.out.println("Enter your choice: ");
            choice=scanner.nextInt();
            scanner.nextLine();


            switch (choice){
                case 1:
                    addBook(user);
                    break;
                case 2:
                    updateBook(user);
                    break;
                case 3:
                    deleteBook(user);
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    listBooks();
                    break;
                case 7:
                    System.out.println("Exiting..Thank you!!");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");

            }

        }while (choice!=7);
    }

    public void listBooks() {
        System.out.println("------ List of Books ------");
        for(Book book:libraryService.getBooks().values()){
            System.out.println("Id: "+book.getId());
            System.out.println("Name: "+book.getName());
            System.out.println("Author: "+book.getAuthor());
            System.out.println("Category: "+book.getCategory());
            System.out.println("Available: "+(book.isAvailable()?"Yes":"No"));
            System.out.println("-----------------------------");
        }
    }

    private void returnBook() {
        System.out.println("Enter book Id to return: ");
        int bookId=scanner.nextInt();
        if(libraryService.getBooks().containsKey(bookId)){
            System.out.println("Book with id "+bookId+" returned successfully.");
            System.out.println("Fine amount: "+invoiceService.calculateFineForAllInvoices()+" Tl");
        }else {
            System.out.println("Book with id "+bookId+" is not borrowed.");
        }
    }

    private void borrowBook() {
        System.out.println("Enter book id to borrow: ");
        int bookId=scanner.nextInt();
        if(libraryService.getBooks().containsKey(bookId)){
            System.out.println(invoiceService.canUserBorrowBooks());
        }else {
            System.out.println("Book that has this id not found");
        }
    }

    public void deleteBook(User user) {
        if(user instanceof Librarian){
            System.out.println("Enter book Id to delete: ");
            int id=scanner.nextInt();
            bookService.deleteBook(id);
        }else {
            System.out.println("Only librarians can delete books.");
        }

    }

    public void updateBook(User user) {
        if(user instanceof Librarian){
            System.out.println("Enter book Id to update: ");
            int bookId=scanner.nextInt();
            System.out.println("Enter new book details: ");
            System.out.println("Name: ");
            String name=scanner.nextLine();
            System.out.println("Author: ");
            String author=scanner.nextLine();
            System.out.println("Category: ");
            String category=scanner.nextLine();

            Book updatedBook=new Book(bookId,name,author,category,true);

            bookService.updateBook(bookId,updatedBook);
        }else {
            System.out.println("Only librarians can update books.");
        }

    }

    public void addBook(User user) {
        if(user instanceof Librarian){
            System.out.println("Enter book details:");
            System.out.println("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Önceki int girişinden sonra bir satır atlayın

            // Eğer girilen ID'ye sahip bir kitap zaten varsa, eklemeyi reddedin
            if (libraryService.getBooks().containsKey(id)) {
                System.out.println("A book with this ID already exists. Book cannot be added.");
                return;
            }
            System.out.println("Name: ");
            String name=scanner.nextLine();
            System.out.println("Author: ");
            String author=scanner.nextLine();
            System.out.println("Category: ");
            String category=scanner.nextLine();

            Book book=new Book(id,name,author,category,true);
            bookService.addBook(book);
            System.out.println("Book added successfully");
        }else {
            System.out.println("Only librarians can add books.");
        }
    }
}
