package coe528.project;

import java.util.ArrayList;
    /**OVERIVIEW Manager class contains the managers credentials to access the system, manager can create/delete movies and give access to
    *other class to access its information on movie objects, this class is mutable as movieArr can change its avaiable seats 
    **/
public class manager {

    private final String userName = "admin";
    private final String adminPassword = "admin";
    private final int accountNumber = 0;
    static private ArrayList< movies> movieArr = new ArrayList<movies>();
    static private ArrayList<customer> activeusers = new ArrayList<customer>();

    
    
    public manager() {

    }
 /**
        *Requires:a string movieName that isnt null, length greater than zero, an integer numSeats that is greater than zero,
        *a double ticketPrice that is greater than zero, int index that is equal to or greater than 0, and int status that can be any integer
        *Modifies: adds a new movie object into the movieArr arraylist, adds a new string of title into movieTitles arraylist, also depending on the
        *int status we can alos remove a movie, therefore changing the movie array 
        *Effects: new movie object added to movieArr, new string added to MovieTitles when status=0 or movie object removed from the movie array
        *,if status is not 0        
         **/
    public void addandRemoveMovie(String movieName, int numSeats, double ticketPrice, int movieNumber, int status, int index1) {// check the movie number
       
        if (status == 0) {
            movieArr.add(new movies(movieName, numSeats, ticketPrice));
        } else {
            movieArr.remove(index1);
        }

    }
/**
        *Requires: requires a string username that isn't null(length greater than 0, a string password that isn't null, length 
        *greater than zero, an integer accNum that is greater than 0, an integer age that is greater than 0)
        *Modifies:adds a new customer into the active users 
        *Effects: creates a new customer in the program  
         **/
    public void createAccount(String username, String password, int accnum, int age) {
        
        activeusers.add(new customer(username, password, accnum, age));

    }
        /**
        *Requires:no requirements
        *Modifies:no modifications
        *Effects:returns admin's username
         **/
    public String getUserName() {
       
        return userName;
    }
/**
        *Requires:no requirements
        *Modifies:no modifications
        *Effects: returns admin's password
         **/
    public String getAdminPassword() {
        
        return adminPassword;
    }
        /**
        *Requires:no requirements
        *Modifies:no modifications
        *Effects:returns managers account number
         **/
    public int getAccountNum() {
        
        return accountNumber;
    }
    
        /**
        *Requires:no requirements
        *Modifies:no modifications
        *Effects:returns arrayList of screening movies
         **/
    public ArrayList<movies> getMovies() {
        
        return movieArr;
    }
/**
        *Requires:no requirements
        *Modifies:no modifications
        *Effects:returns arrayList of the users on the program
         **/

    public static ArrayList<customer> getList() {
        

        return activeusers;

    }
  /** Abstraction Function:
       * Represents a manager with a user name, password and account number
    **/
    @Override
    public String toString() {
        return "user name: " + userName + "\nadmin password: " + adminPassword + "\n account number: " + accountNumber;
    }
    /**Rep Invariant:
      *user name and password by default are "admin" and account number is 0
     **/
    public boolean repok() {
        if (userName == "admin" && adminPassword == "admin" && accountNumber == 0) {
            return true;
        }
        return false;
    }

}
