
package coe528.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class manager {
 /*OVERIVIEW Manager class contains the managers credentials to access the system, manager can create a movie and give access to
    other class to access its informatoin on movie objects*/
    private final String userName = "admin";
    private final String adminPassword = "admin";
    private final int accountNumber = 0;
    static private ArrayList< movies> movieArr = new ArrayList<movies>();
    static private ArrayList<String> MovieTitles = new ArrayList<String>();
    static private ArrayList<customer> activeusers = new ArrayList<customer>();

    public manager() {

    }

    public void addMovie(String movieName, int numSeats, double ticketPrice, int movieNumber) {// check the movie number
        /*
        Requires:a string movieName that isnt null, length greater than zero, an integer numSeats that is greater than zero,
        a double ticketPrice that is greater than zero
        Modifies: adds a new movie object into the movieArr arraylist, adds a new string of title into movieTitles arraylist
        Effects: new movie object added to movieArr, new string added to MovieTitles        
        */
        movieArr.add(new movies(movieName, numSeats, ticketPrice));
        MovieTitles.add(movieName);

    }

    public static ArrayList<String> getMovieTitles() {
        /*
        Requires:no requirements
        Modifies:no modifications
        Effects:returns arraylist of movie titles
        */
        return MovieTitles;
    }

    public void createAccount(String username, String password, int accnum, int age) {
         /*
        Requires: requires a string username that isnt null(length greater than 0, a string password that isnt null, length 
        greater than zero, an integer accnum that is greater than 0, an integer age that is greater than 0)
        Modifies:adds a new customer into the active users 
        Effects: creates a new customer in the program  
        */
        activeusers.add(new customer(username, password, accnum, age));

    }

    public String getUserName() {
         /*
        Requires:no requirements
        Modifies:no modifications
        Effects:returns admins username
        */
        return userName;
    }

    public String getAdminPassword() {
         /*
        Requires:no requirements
        Modifies:no modifications
        Effects: returns admins password
        */
        return adminPassword;
    }

    public int getAccountNum() {
         /*
        Requires:no requirements
        Modifies:no modifications
        Effects:returns managers account number
        */
        return accountNumber;
    }

    public ArrayList<movies> getMovies() {
         /*
        Requires:no requirements
        Modifies:no modifications
        Effects:returns arraylist of screening movies
        */
        return movieArr;
    }

    public static ArrayList<customer> getList() {
         /*
        Requires:no requirements
        Modifies:no modifications
        Effects:returns arraylist of the users on the program
        */

        return activeusers;

    }

}
