
/*
 * CC1006N Introduction to Programming
 * Coursework 1 (Autumn Semester 2012/2013)
 * Project Title:- Book.java
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
 * File: Book.java
 * ----------------
 * This Book class represents a book for rent to a member.
 * The Book class will store the borrow date of book, the member name, the date of return,
 * the number of days borrowed, the daily fine and whether is book is available or not.
 * The class will be able to display the description of the book and 
 * total amount of fine money from the book.
 * The class will simulate the daily fine rate and the deposited amount, borrowing out 
 * the book to the member and returning the book to the book store.
 */
 
 
package bookstore;

public class Book
{
    //Declaring attributes of the Book class
    
    //String to store the book name.
    private String description; 
    //String to store the date when the book is borrowe.
    private String dateOfBorrow;
    
    //String to store name of member
    private String memberName; 
    //String to store the date of book to be returned.
    private String dateOfReturn; 
    
    //the number of days the book is lent.
    private int numberOfDays; 
    //the down payment as whole number.
    private int downPayment;
    
    //the daily fine rate imposed if returned late, a whole number
    private int dailyRate; 
    //the total fine that the book has accumulated to-date.
     private int totalRate; 
    //either book is borrowed or not as true or false.
    private boolean borrowed; 
    
    
    /**
     * Creating a constructor.
     * The constructor will enable all the attributes to be initially set,
     * when an instance of the class is created.
     * The instance of Book class has parameters , the description, 
     * the down payment and the daily rate.
     * 
     * In addition, the constructor sets the member's name, the date of borrow,
     * the date of return to "" (an empty String) and the number of days borrowed and
     * the total rate accumulated to 0.
     * The borrowed status is also set to false.
     */
    
    public Book (String dDescription, int dDownPayment, int dDailyRate)
    {
        //initializing the variables as commented above
        description = dDescription;
        dateOfBorrow = "";
        memberName = "";
        dateOfReturn = "";
        numberOfDays = 0;
        downPayment = dDownPayment;
        dailyRate = dDailyRate;
        totalRate = 0;
        borrowed = false;
        
    }
    
    /***
     * Creating methods for returning the description of book,
     * the down payment, the date of borrow, the date of return,
     * the daily rate, the number of days borrowed and the member's name.
     */
    
    //method to retrieve the description of book.
    public String getDescription()
    {
        //return statement for the description.
        return description;     
    }
    
    //method to retrieve the down payment.
    public int getDownPayment()
    {
        //return statement for the down payment.
        return downPayment;     
    }
    
    //method to retrieve the date of borrow.
    public String getDateOfBorrow()
    {
        //return statement for the date of borrow.
        return dateOfBorrow;    
    }
    
    //method to retrieve the date of return.
    public String getDateOfReturn()
    {
        //return statement for the date of return.
        return dateOfReturn;    
    }
    
    //method to retrieve the daily rate.
    public int getDailyrate()
    {
        //return statement for the daily fine rate.
        return dailyRate;       
    }
    
    //method to retrieve the number of days borrowed.
    public int getNumberOfdays()
    {
        //return statement for the number of days borrowed.
        return numberOfDays;    
    }
    
    //method to retrieve the member's name.
    public String getMemberName()
    {
        //return statement for the member's name.
        return memberName;      
    }
    
    /**
     * Creating a method that sets the daily rate to a new value.
     * The method accepts the new value of the daily rate as a parameter.
     */
    
    //method to set the daily rate.
    public void setDailyRate (int newDailyRate)
    {
        dailyRate = newDailyRate;
    }
    
    /**
     * Creating a method that sets the down payment to a new value.
     * The method accepts the new value of the down payment as a parameter.
     */
    
    //method to set the down payment.
    public void setDownPayment (int newDownPayment)
    {
        downPayment = newDownPayment;
    }
    
    /**
     * Creating a method to issue the book to a member.
     * This method accepts, as parameter, a new member's name, the date of book lend,
     * the date on which the book is to be returned and the number of days the book is required.
     * 
     * If the book is already issued, an appropriate message is output to the member.
     * 
     * If the book is available, the member's name, the date 
     * on which the book is borrowed, the date on which the book is to be returned and 
     * the number of days the book is required are all updated by parameter values.
     * 
     * Also the loan status is changed to true and 
     * the amount paid by the member, which is equal to the daily rate * the number of days,
     * is added to the total borrowed accumulated for that book.
     */
    
    public void issueBook (String name, String borrowDate, String returnDate, int lentDays)
    {
        if (borrowed == false) {
            memberName = name;
            dateOfBorrow = borrowDate;
            dateOfReturn = returnDate;
            numberOfDays = lentDays;
            
            totalRate = (dailyRate * numberOfDays) + totalRate; 
            
            System.out.printf("#### The Book is issued now. ####",
                            "#### The Book Should be returned by: ",dateOfReturn, " ####",
                             "#### Total Rate is: Rs. ", totalRate, " ####");
                             
            borrowed = true;
                             
        }
        else {
            System.out.println("#### The Book is already issued. ####");
            System.out.println("#### The Book was previously issued on: " + dateOfBorrow + " ####");
            System.out.println("#### The Book will be returned by: " + dateOfReturn + " ####");
            System.out.println("#### The Book was lent for " + numberOfDays + " " + "days" + " ####");
        }
    }
    
    /**
     * Creating a method for returning the book to the book store.
     * 
     * If the book is not borrowed, an error message is output.
     * 
     * If the book is borrowed, the method sets back, as attributes,
     * the member's name to "", the number of days borrowed to 0,
     * the date of borrow to "", the date of return to "" and
     * the borrowed status to false.
     */
    
    //method to return the book
    public void bookReturn ()
    {
        if (borrowed == false) {
            System.err.println("## ERROR: Sorry, No Books borrowed." + " ##" );
            System.err.println("## Cannot Return the Book unless borrowed." + " ##");    
        }
        else {
            memberName = "";
            numberOfDays = 0;
            dateOfBorrow = "";
            dateOfReturn = "";
            borrowed = false;  
        }
    }
    
    /**
     * Creating a method to display the description of a particular book and
     * also its total rent collected to-date.
     */
    
    //method to display the book description
    public void displayDescription ()
    {
        System.out.println("#### The description of the Book is: " + description + " ####");
        System.out.println("#### The total rent collected to-date is Rs: " + totalRate + " ####");
    }
}