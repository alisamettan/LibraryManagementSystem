package librarymanagement.service;

import librarymanagement.model.Invoice;
import librarymanagement.model.Library;
import librarymanagement.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceService {

    private List<Invoice> invoices;
    private Library library;

    public InvoiceService(List<Invoice> invoices, Library library) {
        this.invoices = invoices;
        this.library = library;
    }

    public boolean canUserBorrowBooks() {
        for (User user : library.getUsers()) {
            int userId = user.getId();
            int borrowedBooksCount = 0;

            for (Invoice invoice : invoices) {
                if (invoice.getUserId() == userId && invoice.getReturnDate() == null) {
                    borrowedBooksCount++;
                }
            }

            if (borrowedBooksCount >= 5) {
                return false; // Kullanıcı 5'ten fazla kitap ödünç almış
            }
        }

        return true; // Tüm kullanıcılar 5'ten az kitap ödünç almış
    }

    //Eğer kullanıcı kitabı ödünç alıp 30 gün içinde geri getirmez ise 50 Tl fatura ödemektedir.
    public double calculateFine(Invoice invoice){
        Date borrowDate=invoice.getBorrowDate();
        Date returnDate=invoice.getReturnDate();

        if(borrowDate!=null && returnDate!=null){
            long borrowTimeMillis=returnDate.getTime()-borrowDate.getTime();
            long borrowedTimeDays=borrowTimeMillis/(1000*60*60*24);
            if(borrowedTimeDays>30){
                return 50.0;
            }
        }
        return 0.0;
    }
    public double calculateFineForAllInvoices() {
        double totalFine = 0.0;

        for (Invoice invoice : invoices) {
            double fineAmount = calculateFine(invoice);
            totalFine += fineAmount;
        }

        return totalFine;
    }
}
