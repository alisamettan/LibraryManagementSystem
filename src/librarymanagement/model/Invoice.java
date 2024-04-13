package librarymanagement.model;

import java.util.Date;

public class Invoice {
    private String userId;
    private String bookId;
    private Date borrowDate;
    private Date returnDate;
    private double fineAmount;

    public Invoice(String userId, String bookId, Date borrowDate, Date returnDate, double fineAmount) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookId() {
        return bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }
}