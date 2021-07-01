package Entity;

import Exceptions.ErrorException;
import Utils.ErrorMessage;

public class Book {

    private String title;
    private String isbn;
    private String author;
    private boolean isLend;

    public Book() {
    }

    public Book(String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public Book(Book book) throws ErrorException {
        if(book == null) {
            throw new ErrorException(ErrorMessage.NULL_BOOK.getMessage(), ErrorMessage.NULL_BOOK.getCode());
        }

        this.title = book.getTitle();
        this.isbn = book.getIsbn();
        this.author = book.getAuthor();
    }

    /**
     *
     * @return true if the operation was successful
     * and false if the operation was not successful
     */
    public boolean lend() {
        if(this.isLend) {
            return false;
        }

        this.isLend = true;
        return true;
    }

    /**
     *
     * @return true if the operation was successful
     * and false if the operation was not successful
     */
    public boolean giveBack() {
        if(!this.isLend) {
            return false;
        }

        this.isLend = false;
        return true;
    }

    @Override
    public String toString() {
        return title + ", " + isbn + ", " + author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
