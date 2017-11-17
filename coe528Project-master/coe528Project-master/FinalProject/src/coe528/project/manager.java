
package coe528.project;


import java.util.ArrayList;

public class manager {
 /*OVERIVIEW Manager class contains the managers credentials to access the system, manager can create a movie and give access to
    other class to access its informatoin on movie objects*/
    private final String userName = "admin";
    private final String adminPassword = "admin";
    private final int accountNumber = 0;
    static private ArrayList< movies> movieArr = new ArrayList<movies>();
    static private ArrayList<customer> activeusers = new ArrayList<customer>();
    
     /* Abstraction Function:
        AF(r) = 

        Rep Invariant:

        */

    public manager() {

    }

    public void addandRemoveMovie(String movieName, int numSeats, double ticketPrice, int movieNumber,int status, int index1) {// check the movie number
        /*
        Requires:a string movieName that isnt null, length greater than zero, an integer numSeats that is greater than zero,
        a double ticketPrice that is greater than zero
        Modifies: adds a new movie object into the movieArr arraylist, adds a new string of title into movieTitles arraylist
        Effects: new movie object added to movieArr, new string added to MovieTitles        
        */
        if(status==0){
        movieArr.add(new movies(movieName, numSeats, ticketPrice));
        }else movieArr.remove(index1);

    }

    public void deleteMovie(String movieName, int index1){
        movieArr.remove(index1);
    
    
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
    
    public boolean repok(){
        return false;
    }

}
