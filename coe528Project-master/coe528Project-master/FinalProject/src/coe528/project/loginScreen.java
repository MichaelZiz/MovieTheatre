package coe528.project;

import java.util.Scanner;
import java.util.ArrayList;

public class loginScreen {

    /*Overview: Login class contains the interface that the user is able to interact with, user is able to input credentials of their account
    Login starts off with manager access, as manager, you should create movies to be available to the public. Customers can access,
    and manage their accounts via login*/
    static private int k = 0, p = 1;
    private static ArrayList<customer> userspointer;
    private static ArrayList<String> titles = new ArrayList<String>();
    static private ArrayList<movies> movieArr = new ArrayList<movies>();
     
    /* Abstraction Function:
        represents a string array list of titles
        represents a movies array list of movie objects
        represents a customer array list of userspointers

        Rep Invariant:
        The string array list, titles can not be null and length must be greater than or equal to 0
        The movies array list, movieArr can not be null and the length must be greater than or equal than 0
        The customer array list, userspointer can not be null
        */
    
    public static manager Managersetup(manager one, int stat1) {
        /*
        Requires: manager object can be null, or active manager object, int stat1 can be any integer 
        Modifies: adds movies into <movies> arraylist in manager class. 
        Effects: creates movies for the customers to choose from and returns the modified manager object
        
         */
        String password, name;
        int x = 0, x1 = 0, z1 = 0, qw = 0, b = 0;
        if (stat1 == 0) {
            System.out.println("Security: Manager Setup: please enter/re Enter a password of 5 characters length, user automatically set as admin (admin,admin)");
            while (x == 0) {
                Scanner v = new Scanner(System.in);
                password = v.nextLine();
                if (password.length() <= 5) {

                    if (password.equals(one.getAdminPassword()) == true) {

                        System.out.println("Password Accepted");
                        System.out.println("enter Username");

                        while (z1 == 0) {
                            if (v.hasNextLine() == true) {
                                name = v.nextLine();
                                if (name.equals(one.getUserName())) {
                                    System.out.println("Username Accepted");
                                    x = 1;
                                    z1 = 1;
                                } else {
                                    System.out.println("wrong Username or exceeds length 5 char");
                                }

                            } else {
                                System.out.println("enter a valid string");
                            }
                        }
                    } else {
                        System.out.println("wrong password");
                    }
                } else {
                    System.out.println("enter a password of 5 characters length");
                }
            }
        }

        System.out.println("As a manager you must create Movies. Can create 3 movies");

        do {

            System.out.println(" \n Press 1 to create Movie \n Press 2 To Delete Movie \n Press 3 to Logout of Manager");

            while (qw == 0) {
                Scanner q = new Scanner(System.in);
                if (q.hasNextInt() == true) {
                    b = q.nextInt();
                    if (b == 1 || b == 2 || b == 3) {
                        break;
                    } else {
                        System.out.println("enter 1 or 2");
                    }
                } else {
                    System.out.println("enter valid integer");
                }
            }

            if (b == 1 || b == 2 || b == 3) {//if statements corresponding to user input

                if (b == 1) {
                    String movieName = null;
                    double price;
                    int seatNum, y9 = 0, y8 = 0, y10 = 0;
                    System.out.println("Type in movie title to create"); //movie title cannot occur twice 

                    while (y10 == 0) {
                        Scanner v = new Scanner(System.in);
                        movieName = v.nextLine();
                        if (titles == null) {

                            y10 = 1;
                        } else {
                            if (titles.contains(movieName)) {
                                System.out.println("Movie title already exists, enter another title");

                            } else {
                                y10 = 1;
                            }
                        }
                    }
                    titles.add(movieName);

                    while (y9 == 0) {
                        Scanner yo = new Scanner(System.in);
                        System.out.println("enter ticket price, ticket price lies from 5 to 25 dollars");
                        if (yo.hasNextDouble() == true) {
                            price = yo.nextDouble();
                            if (price > 5 && price < 25.0) {

                                while (y8 == 0) {
                                    Scanner yo1 = new Scanner(System.in);
                                    System.out.println("enter # of available seats for the movie between 8 and 10 seats");
                                    if (yo1.hasNextInt() == true) {
                                        seatNum = yo1.nextInt();
                                        if (seatNum > 7 && seatNum < 11) {// can change the seat limit, 2-4 seats per movie
                                            if (k > -1 && k < 3) {//can change the movie limit, make 2 movies

                                                one.addandRemoveMovie(movieName, seatNum, price, k, 0, 0);
                                                y8 = 1;
                                                y9 = 1;
                                                k++;
                                                System.out.println("movie created");

                                            } else {
                                                System.out.println("reached maximum amount of movies to create for the day");
                                                y8 = 1;
                                                y9 = 1;

                                            }
                                        } else {
                                            System.out.println("movie theater capacity lies from 8 to 10 seats ");
                                        }
                                    } else {
                                        System.out.println("Enter a valid decimal number");
                                    }
                                }

                            }
                        } else {
                            System.out.println("ticket prices can only be between 5 and 25 dollars");
                        }
                    }

                }

                if (b == 3) {//Exit Manager
                    System.out.println("exiting manager");
                    x1 = 1;
                }
                if (b == 2) {//need to remove from titles array too
                    int y11 = 0;
                    String movieName1 = null;
                    //System.out.println(titles.size());
                    if (titles.size() != 0) {

                        System.out.println("Type in movie title to delete, can only delete movie if no one bought tickets to the movie"); //movie title cannot occur twice 

                        if (titles.size() == 0) {
                            System.out.println("no titles exist");
                        } else {
                            for (int i = 0; i <= titles.size() - 1; i++) {
                                System.out.println("Movie: " + titles.get(i));

                            }
                        }

                        while (y11 == 0) {
                            Scanner v = new Scanner(System.in);
                            movieName1 = v.nextLine();
                            if (titles == null) {

                                y11 = 1;
                            } else {
                                if (titles.contains(movieName1)) {

                                    int k1 = 0;
                                    k1 = titles.indexOf(movieName1);

                                    if (movieArr.size() == 0 || movieArr.get(k1).SeatsAvailable() == movieArr.get(k1).getSeattotal()) {
                                        System.out.println("No purchases made, removed movie");
                                        titles.remove(movieName1);
                                        one.addandRemoveMovie(null, 0, 0.0, 0, 1, k1);
                                        y11 = 1;
                                    } else {
                                        System.out.println("Cannot remove movie, purchases already made");
                                        y11 = 1;
                                    }
                                    //  System.out.println("Movie title already exists, enter another title");

                                } else {
                                    System.out.println("movie doesnt exist");
                                    y11 = 1;
                                }
                            }
                        }
                    } else {
                        System.out.println("no movies to remove");
                    }

                }
            } else {
                System.out.println("Enter a valid number to access directory");
            }
        } while (x1 == 0);

        return one;
    }

    public static void CustomerAccess(int i, ArrayList<customer> userspointer1, ArrayList<String> titles1, ArrayList<movies> movies1) {
        /*
        Requires: int i >= 0, arraylist <string> can't be null, length greater than 0, 
        arraylist <string> can't be null, length greater than 0, arraylist<movies> cant be null, length greater than 0 
        Modifies: customer objects that purchase and refund tickets will have a state change to the movies tickets and seats purchased. 
        Effects: users movie information will be updated upon purchase or refund, view info on tickets and movie titles. 
         */
        int y = 0, x = 0;

        do {
            int x1 = 0;
            int b = 0;
            System.out.println(" \n Press 1 Purchase Ticket\n Press 2 to View Info on Booking\n "
                    + "Press 3 Refund Tickets\n Press 4 for titles playing\n Press 5 Exits");

            while (x1 == 0) {
                Scanner v = new Scanner(System.in);
                if (v.hasNextInt() == true) {
                    b = v.nextInt();
                    x1 = 1;
                } else {
                    System.out.println("enter an integer");
                }
            }

            if (b == 1 || b == 2 || b == 3 || b == 4 || b == 5) {//if statements corresponding to user input

                if (b == 1) {//Purchase Tickets
                    if (movies1.isEmpty() == false) {
                        int age = 0, y1 = 0;
                        //Enter age

                        //enter seats and need to check the seat availability, need to pass through movies seats
                        //
                        System.out.println("Available movies");
                        String q = "\n";
                        for (int k = 0; k <= movies1.size() - 1; k++) { // check the movies with a for loop that loops through and matches the name hence also matching the number of seast along with it
                            if (movies1.get(k) == null) {
                            } else {
                                q = "Movie: " + (k + 1) + " " + movies1.get(k).movieName + "\n" + q;
                                System.out.println(q);
                            }

                        }

                        int lp = 0;
                        String titlerequest;
                        do {
                            // ask user to input a string of movie title they like to attend 
                            // title doesnt exist then loop and ask them to  do it again 
                            System.out.println("enter a movie title");
                            Scanner moviet = new Scanner(System.in);
                            titlerequest = moviet.nextLine();
                            if (userspointer1.get(i).getTitle() == null || titlerequest.equals(userspointer1.get(i).getTitle())) {
                                //System.out.println("here");
                                if (titles1.contains(titlerequest)) {
                                    int j = 0;
                                    for (int k1 = 0; k1 < movies1.size() - 1; k1++) {
                                        j = titles1.indexOf(titlerequest);
                                    }

                                    if (titlerequest.equals(movies1.get(j).getMovie())) {

                                        if (movies1.get(j).SeatsAvailable() > 0) {

                                            System.out.println("Available seats");
                                            System.out.println(movies1.get(j).SeatsAvailable());
                                            System.out.println("enter Number of seats you would like to purchase(limited to 4 per person)");
                                            int p1 = 0, seatholder;
                                            while (p1 == 0) {
                                                Scanner seatsnum = new Scanner(System.in);
                                                if (seatsnum.hasNextInt() == true) {
                                                    seatholder = seatsnum.nextInt();
                                                    if (userspointer1.get(i).getSeatnum() == 0) { //customer can still purchase tickets as long as his seat balance is below 4 ADDED
                                                        if (seatholder > 0 && seatholder <= movies1.get(j).SeatsAvailable()) {
                                                            if (seatholder < 5 && seatholder > 0) {
                                                                userspointer1.get(i).purchaseTicket(userspointer1.get(i).getAge(), seatholder, titlerequest, movies1.get(j), 1);
                                                                // should have a away to decrement the seats in movie and from customer point to movie so user can later access info
                                                                p1 = 1;
                                                                lp = 1;
                                                                break;
                                                            } else {
                                                                System.out.println(" enter any seat number from 1-4");
                                                            }

                                                        } else {
                                                            System.out.println("seat number should be less than or equal to the available seats");
                                                        }

                                                    } else {
                                                        //
                                                        if (seatholder > 0 && seatholder <= movies1.get(j).SeatsAvailable()) {
                                                            if ((seatholder + userspointer1.get(i).getSeatnum()) <= 4 && seatholder > 0) {
                                                                System.out.println("seat");
                                                                userspointer1.get(i).purchaseTicket(userspointer1.get(i).getAge(), userspointer1.get(i).getSeatnum() + seatholder, titlerequest, movies1.get(j), 2);

                                                                p1 = 1;
                                                                lp = 1;
                                                                break;
                                                            } else {
                                                                if (userspointer1.get(i).getSeatnum() == 4) {
                                                                    lp = 1;
                                                                    p1 = 1;
                                                                    System.out.println("already have max tickets");
                                                                } else {
                                                                    System.out.println(" enter any seat number from 1-4, new seats exceeds 4");
                                                                }
                                                            }

                                                        } else {
                                                            System.out.println("seat number should be less than or equal to the available seats");
                                                        }

                                                        //      
                                                    }

                                                } else {
                                                    System.out.println("enter an integer");
                                                }

                                            }
                                        } else {
                                            System.out.println("No seats available for this movie");
                                            lp = 1;
                                        }
                                    } else {
                                        System.out.println("title doesn't exist");
                                    }

                                    // }
                                } else {

                                    System.out.println("enter a valid movie title from the selection \n" + q);

                                }

                            } else {
                                lp = 1;
                                System.out.println("you already purchased tickets, refund tickets to buy tickets to another movie");
                            }

                        } while (lp == 0);

                    } else {
                        System.out.println("no movies available");
                    }
                }

                if (b == 2) {//View Info on customers account his/her purchases, #of seats, movie title, 

                    userspointer1.get(i).SetinformationONticket();

                }
                if (b == 3) {//Refund tickets
                    int lp1 = 0;

                    do {

                        if (userspointer1.get(i).getTitle() == null) {
                            System.out.println("You haven't purchased any tickets, no tickets to refund");
                            lp1 = 1;
                        } else {
                            System.out.println("will be refunding this booking");
                            userspointer1.get(i).SetinformationONticket();

                            userspointer1.get(i).refundTicket(userspointer1.get(i).getMovie1(), userspointer1.get(i).getSeatnum());
                            lp1 = 1;

                        }

                    } while (lp1 == 0);

                }

                if (b == 5) {//exit
                    x = 1;
                }

                if (b == 4) {
                    String q = "\n";
                    // view movies playing

                    if (movies1.isEmpty() == false) {
                        System.out.println("Available movies");
                        for (int io = 0; io <= movies1.size() - 1; io++) { // check the movies with a for loop that loops through and matches the name hence also matching the number of seast along with it

                            if (movies1.get(io) == null) {

                            } else {
                                q = "Movie: " + (io + 1) + " " + movies1.get(io).movieName + " Seats avaiable: " + movies1.get(io).SeatsAvailable();

                                System.out.println(q);
                            }

                        }
                    } else {
                        System.out.println("No movies Available");
                    }

                }
            } else {
                System.out.println("Enter a valid number to access directory");
            }
        } while (x == 0);

    }

    @Override
    public String toString(){
        return "length of titles array: " + titles.size() + "/n length of movie array: " + movieArr.size()+ "/n length of userspointer: " + userspointer.size();
    }
    public boolean repok(){
        if (titles != null && titles.size() >= 0){
            if (movieArr != null && movieArr.size() >= 0 ){
                if (userspointer != null ){
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {

        manager one = new manager();
        System.out.println("Manager unique number is 0");

        one = Managersetup(one, 0);
        //exit manager

        System.out.println("Accesssing Main directory");

        String name, password;
        int x = 0, accnum = 0;//set it zero here no account will have 0 for users
        while (x == 0) {
            int access;
            System.out.println("Press 1 to enter to Login As customer (or Manager)\nPress 2 to Register as a user\nPress 3 To exit");
            Scanner q = new Scanner(System.in);
            if (q.hasNextInt() == true) {
                access = q.nextInt();

                if (access == 1) {

                    System.out.println("Login: enter Username ");
                    Scanner h = new Scanner(System.in);
                    name = h.nextLine();
                    System.out.println("Login: enter password");
                    password = h.nextLine();
                    System.out.println("Enter account number");
                    int x1 = 0;
                    while (x1 == 0) {

                        Scanner pop = new Scanner(System.in);
                        if (pop.hasNextInt() == true) {
                            accnum = pop.nextInt();
                            x1 = 1;
                        } else {
                            System.out.println("enter an integer");

                        }

                    }
                    // useful info needed for purchase ticket
                    userspointer = one.getList();

                    movieArr = one.getMovies();
                    int counter1 = 0;
                    try {

                        if (password.equals(one.getAdminPassword()) && name.equals(one.getUserName()) && accnum == one.getAccountNum()) {//check manager login

                            Managersetup(one, 1);
                        } //else
                        if (userspointer.size() >= 1) {
                            for (int i = 0; i <= userspointer.size() - 1; i++) {

                                if (password.equals(userspointer.get(i).getPassword()) && name.equals(userspointer.get(i).getUsername()) && accnum == userspointer.get(i).getAccnum()) {
                                    System.out.println("Logged into Account: " + name);

                                    CustomerAccess(i, userspointer, titles, movieArr);// customer access account here, customer will have access to customer profile arraylist
                                    System.out.println("logged out");
                                    counter1++;
                                } else {

                                }
                            }

                            if (counter1 > 0) {

                            } else {
                                System.out.println("account doesnt exist");
                            }

                        } else {
                            System.out.println("account doesnt exist");
                        }
                    } catch (IndexOutOfBoundsException a) {
                        System.out.println("account doesnt exist");
                    }

                }
                if (access == 2) {// register as a user only a Username and Password is required account number is given to user 

                    String name1, password1;
                    userspointer = one.getList();
                    Scanner h = new Scanner(System.in);
                    System.out.println("Login: enter password for new account");
                    password1 = h.nextLine();
                    int x3 = 0;
                    while (x3 == 0) {
                        System.out.println("Login: enter Username ");
                        int dido = 0;
                        Scanner v = new Scanner(System.in);
                        name1 = v.nextLine();

                        int y1 = 0, age = 0;
                        while (y1 == 0) {
                            System.out.println("enter age (11-99)");
                            Scanner v1 = new Scanner(System.in);
                            if (v1.hasNextInt() == true) {
                                age = v1.nextInt();
                                if (age > 10 && age < 100) {

                                    y1 = 1;
                                } else {
                                    System.out.println("enter value for age  from 11 to 99");
                                }
                            } else {
                                System.out.println("enter a valid integer for age");
                            }
                        }

                        try {

                            if (userspointer.isEmpty() == true) {
                                System.out.println("Unique Account Number is: " + p);
                                one.createAccount(name1, password1, p++, age);

                                x3 = 1;
                            } else {
                                for (int i = 0; i <= userspointer.size() - 1; i++) {

                                    if (name1.equals(userspointer.get(i).getUsername())) {
                                        dido++;
                                    }
                                }

                                if (dido > 0) {
                                    System.out.println("Username already exists, choose another name, Enter another Username");
                                } else {
                                    System.out.println("Unique Account Number is: " + p);
                                    one.createAccount(name1, password1, p++, age);

                                    x3 = 1;
                                }

                            }

                        } catch (NullPointerException ex) {
                            System.out.println("Unique Account Number is: " + p);
                            one.createAccount(name1, password1, p++, age);

                            x3 = 1;

                        }

                    }

                }
                if (access == 3) {
                    x = 1;

                }

            } else {
                System.out.println("enter an integer");
            }

        }

    }

}
