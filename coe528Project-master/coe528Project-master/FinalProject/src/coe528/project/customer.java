package coe528.project;

/**OVERVIEW: Customer class initiates a customer object, this is where all of the customers information is stored and where the customer can purchase
     *refund ticket. Information on the customers ticket purchase is also stored here.
     *Information on the number of seats purchased, ticket price and title of the movie they will be viewing. 
     *This class is mutable as the customer can order
     *tickets to the movie of their choice, they can refund and get a different price
     **/
public class customer {

    

    private String Username;
    private String password;
    private int accnum, seatnum = 0;
    private String title;
    private double totalprice;
    private Seating booked;
    private movies movie1;
    private int age;

      
       /**
        *Requires:no requirements
        *Modifies:no modification
        *Effects: returns customers username
         **/
    public String getUsername() {
        

        return Username;
    }
        /**
        *Requires:no requirements
        *Modifies:no modification
        *Effects: returns customers age
         **/
    public int getAge() {
        
        return age;
    }
        /**
        *Requires: an integer that is greater than zero
        *Modifies: no modification
        *Effects: sets customers age
         **/
    public void setAge(int age) {
        

        this.age = age;
    }
        /**
        *Requires: no requirement
        *Modifies: no modification
        *Effects: returns customers movie
         **/
    public movies getMovie1() {
        

        return movie1;
    }
        /**
        *Requires: a movie object, object can technically be null, but will not occur due to login screen procedure
        *Modifies: no modification
        *Effects: sets movie customers is interested in
         **/
    public void setMovie1(movies movie1) {
        

        this.movie1 = movie1;
    }
        /**
        *Requires: movies object, integer j (either a 1 or 0): determine state of booked object. 
        *Integer k greater than 0 less that 4: the number of seats 
        *the user is refunding/purchasing.
        *Modifies:no modification
        *Effects: creates a new booked object that follows state procedure based on its parameters
         **/
    public void setBooked(movies movies1, int j, int k) {
        

        booked = new Booked(movies1, j, k);
    }
        /**
        *Requires: no requirement
        *Modifies: no modification
        *Effects: returns customers password
         **/
    public String getPassword() {
       
        return password;
    }
        /**
        *Requires: no requirement
        *Modifies: no modification
        *Effects: returns customers account number
         **/
    public int getAccnum() {
        

        return accnum;
    }
        /**
        *Requires: A string(username) that is not null and has length greater that 0, 
        *String password that is not null and has length greater that 0, int accnum an integer than is greater than or equal to 1,
        *int age, an integer that is greater 0
        *Modifies: no modification
        *Effects: constructor sets the parameter of customer username,password, account number and age
         **/
    public customer(String Username, String password, int accnum, int age) {
        

        this.Username = Username;
        this.password = password;
        this.accnum = accnum;
        this.age = age;

    }
        /**
        *Requires: no requirement
        *Modifies:No modifications
        *Effects: returns the number of seats purchased by the customer 
         **/
    public int getSeatnum() {
        
        return seatnum;
    }
        /**
        *Requires: requires an integer greater than 0 less that 5
        *Modifies: sets the value of customers booked seats
        *Effects: returns the number of seats purchased by the customer 
         **/
    public void setSeatnum(int seatnum) {
       

        this.seatnum = seatnum;
    }
        /**
        *Requires: no requirement
        *Modifies:No modifications
        *Effects: returns the title of the movie purchased by the customer 
         **/
    public String getTitle() {
       
        return title;
    }
        /**
        *Requires: no requirement
        *Modifies: No modifications
        *Effects: returns the updated total price for the movie 
         **/
    public double getTotalprice() {
        

        return totalprice;
    }
        /**
        *Requires:int age greater than 0, int seats greater than 0, string movieName; cannot be null, length greater than 0, movies object cannot be null
        *int status any integer
        *Modifies: changes ticket price according to discounts
        *Effects:sets ticketPrice, sets movie to watch, sets # of seats purchased
        **/
    public void purchaseTicket(int age, int seats, String movieName, movies movies1, int status) {
        //customer should get discounts as applicable, based on age if they buy one ticket,number of seats purchased
       
        int seatnum1;
        totalprice = movies1.getTicketPrice();
        title = movies1.getMovie();

        if (status != 1) {
            seatnum1 = Math.abs(getSeatnum() - seats);

        } else {
            seatnum1 = seats;
        }

        seatnum = seats;
        setSeatnum(seatnum);
        setMovie1(movies1);

        if (seats == 1) {//discount on age, 10% discount
            if (age < 12 || age > 64) {
                totalprice = Math.round(totalprice * 0.9);
                System.out.println("Age discount");
                System.out.println("new ticket price $ " + totalprice);

            } else {
                System.out.println("full price ticket");
            }

        }
        if (seats == 2)//discount 5%
        {
            totalprice = Math.round(totalprice * 0.95);
            System.out.println("2 seat discount");
            System.out.println("new ticket price$ " + totalprice);
        }
        if (seats == 3)//discount 10%
        {
            totalprice = Math.round(totalprice * 0.9);
            System.out.println("3 seat discount");
            System.out.println("new ticket price$ " + totalprice);
        }
        if (seats == 4)//discount 20%
        {
            System.out.println("4 seat discount");

            totalprice = Math.round(totalprice * 0.8);
            System.out.println("new ticket price$ " + totalprice);
        }

        setBooked(movies1, 1, seatnum1);

    }
        /**
        *Require:movie object that isn't null
        *Modifies:no modifications
        *Effects: calls setbooked method
         **/

    public void refundTicket(movies movies1, int seats) {
        
        setBooked(movies1, 0, getSeatnum()); //this should be the calling to booked from refund ticket

        title = null;
        seatnum = 0;
        totalprice = 0;
    }
        /**
        *Requires: no requirement
        *Modifies:No modifications
        *Effects: returns the movie title, number of seats purchased and total price: for Movie purchased by the customer 
         **/
    public void SetinformationONticket() {

        
        if (getTitle() == null) {

            System.out.println("No purchases made, no info to display");
        } else {
            System.out.println(toString());
        }
    }
      /**Abstraction Function:
        *Customer object stores customer information
        *Represents the customer purchasing and refunding movie tickets
        *The number of seats purchased, ticket price and title of the movie are displayed
        **/
    @Override
    public String toString() {
        return " Movie Title: " + getTitle() + "\n Number of seats: " + getSeatnum() + "\n Price:$ " + getTotalprice();
    }
   /** Rep Invariant:
        *The customer can purchase between 1 to 4 seats per movie
        *The customer can only refund up to the amount of tickets they purchased
     **/
    public boolean repok() {
        if (seatnum > 0 && seatnum < 5) {
            return true;
        }
        return false;
    }
}
