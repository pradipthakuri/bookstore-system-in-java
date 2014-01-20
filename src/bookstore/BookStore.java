
/*
 * CC1006N Introduction to Programming
 * Coursework 2 (Autumn Semester 2012/2013)
 * Project Title:- BookStore.java
 * Project Purpose:- University Coursework
 * version:- 1
 * @Author:- Pradip Shahi
 * Student Id:- 11069881 (SITY0E111008)
 * Group:- L1C1 (BSc(Hons.) in Computing)
 * Date:- 2012-12-17
 * Islington College(London Metropolitan University)
 */

/*
 * User Instructions:
 * i) Open the project Book using Bluej.
 * ii) Right click on the class Book.
 * iii) Click on new Book().
 * iv) Set the values according to instructions given.
 * *****************************************************************************
 *     ******** Do not change the Source Code without Permission **********
 * ******************* *********************************************************
 */



/**
 * Importing ArrayList package under java.util for creating array list.
 */
 
 package bookstore;
 
import java.util.ArrayList;

/**
 * File: BookStore.class
 * --------------------
 * This BookStore class represent a book store.
 * It simulates adding a book to the book store's list of book,
 * It also allows removing a book from the book store's list of book,
 * lending a book to a store and searching for a book that contains
 * a desirable feature in its description.
 * 
 * Books in this class BookStore will be represented by objects of the class Book.
 */

public class BookStore
{
    //array list of type Book
    private ArrayList<Book>books;
 
    
    public BookStore()
    {
        books = new ArrayList<Book>();
    }
    
    
    /**
     * This method addNewBook() is for adding a new book to the book store's list of books.
     * This method takes 3 parameters, description, downPayment and dailyRate.
     * This method creates a new book with these attributes and add it to the book store's list.
     */
    public void addNewBook( String description, int downPayment, int dailyRate)
    {
        Book book = new Book( description, downPayment, dailyRate );
        books.add(book);
        
        System.out.println("A new book, " + description + " is added to the BookStore.");
        
        
    }
    
    /**
     * This method removeBook() is for removing a book from the book store's list of books.
     * The method take index no as parameter, which is the position
     * in the array list of the book to be removed.
     * It also outputs a suitable error message when the index no is not valid. 
     */
    public void removeBook( int indexNo)
    {
        if (indexNo >= books.size()) {
            System.out.println("Sorry! Wrong index no input.");
            System.out.println("Please try again with correct index no.");
        }
        else if (indexNo < 0) {
            System.out.println("Sorry! Wrong index no input.");
            System.out.println("Please try again with correct index no.");
        }
        else {
            books.remove( indexNo );
            System.out.println("The book has been successfully removed from the store.");
            
        }
        
    }
    
    /**
     * This method issueBook() is for renting a book to a member.
     * The method take 5 parameters, the index no, the member's name, the date of borrow,
     * the date of return and the number if days.
     * It gets the book from the book store's list of books and 
     * call the method in the Book class to rent out a book with the member name,
     * the date of borrow, the date of return and the number of days.
     * It also outputs a error message if the index no is not valid.
     */
    public void issueBook(int indexNo, String memberName, String dateOfBorrow, String dateOfReturn, int numberOfDays)
    {
        if ( indexNo >= books.size()) {
            System.out.println("Sorry!");
            System.out.println("The Book you want to issue is not available currently.");
        }
        
        else if ( indexNo < 0 ) {
            System.out.println("Sorry!");
            System.out.println("The Book you want to issue is not available currently.");
        }
        
        else {
            Book book = books.get( indexNo );
            book.issueBook( memberName, dateOfBorrow, dateOfReturn, numberOfDays );
            System.out.println("The book with index no. " + indexNo +  " is now rented by" + memberName);
        }
        
    }
    
    /**
     * This method bookReturn() is for returning back a book.
     * The method takes index no as parameter.
     * It gets the book from the book store's list of books and
     * call the method in the Book class to return the book to the store.
     */
    public void bookReturn( int indexNo )
    {
        if ( indexNo >= books.size() ) {
            System.out.println("No books available to return.");
        }
        
        else if ( indexNo < 0 ) {
            System.out.println("No books available to return.");
        }
        
        else {
            Book book = books.get( indexNo );
            book.bookReturn( );
            
            System.out.println("The book has been returned now.");
        }
        
    }
    
    
    /**
     * This method booksAvailable() lists all of the books available.
     * For each book available, index no is printed.
     * The method displayDescription() in the class Book is called,
     * to print the details of the book.
     */
    public void booksAvailable( )
    {
        int indexNo = 0;
        System.out.println("All books availabe in the store are: ");
        for ( Book book:books ) {
            String memberName = book.getMemberName( );
            if ( memberName == "" ) {
                System.out.println( "Book " + indexNo );
                book.displayDescription();
            }
            
            indexNo = indexNo + 1;
        }
    }
    
    /**
     * This method searchBook() searches the list of books for a book,
     * that is currently available, that has a description containing the search term
     * and that does not exceed the maximum value for the ddaily rate.
     */
    public void searchBook( String searchkey )
    {
        int indexNo = 0;
        boolean searchFound = false;
        int totalBooks = books.size();
        
        while ( indexNo < totalBooks && !searchFound) {
            Book book = books.get( indexNo );
            String memberName = book.getMemberName();
            String description = book.getDescription();
            int dailyRate = book.getDailyrate();
            
            if ( memberName == "" && description == searchkey) {
                searchFound = true;
                System.out.println("Book" + indexNo );
                book.displayDescription();
            }
            
            else {
                indexNo = indexNo + 1;
            }
        }
        
        if ( !searchFound ) {
            System.out.println("The book you searched in not available at this time.");
        }
    }
    
    
}
