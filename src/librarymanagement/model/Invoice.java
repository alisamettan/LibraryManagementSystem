package librarymanagement.model;

import java.util.Date;

public class Invoice {
    private int userId;
    private int bookId;
    private Date borrowDate;
    private Date returnDate;
    private double fineAmount;

    public Invoice(int userId, int bookId, Date borrowDate, Date returnDate, double fineAmount) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
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