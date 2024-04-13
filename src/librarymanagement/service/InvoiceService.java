package librarymanagement.service;

import librarymanagement.model.Invoice;
import librarymanagement.model.Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceService {

    private List<Invoice> invoices;

    public InvoiceService() {
        this.invoices=new ArrayList<>();
    }

    public boolean canUserBorrowBooks(int userId){
        int borrowedBooksCount=0;

        for(Invoice invoice:invoices){
            if(invoice.getUserId()==userId && invoice.getReturnDate()==null){
                borrowedBooksCount++;
                System.out.println("User borrowed a book.");
            }
        }
        return borrowedBooksCount<5;
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
}
