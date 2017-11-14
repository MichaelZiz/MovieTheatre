
package coe528.project;

public class customer {
/*OVERVIEW: Customer class initiates a customer object, this is where all of the customers information is stored and where the customer can purchase
 refund ticket. Information on the customers ticket purchase is also stored here.
 Information on the number of seats purchased, ticket price and title of the movie they will be viewing. */
    
    private String Username;
    private String password;
    private int accnum, seatnum=0;
    private String title, q;
    private double totalprice;
    private Booked booked;
    private movies movie1;
    private int age;

    public String getUsername() {
        /*
        Requires:no requirements
        Modifies:no modificatoin
        Effects: returns customers username
        */
        
        return Username;
    }

    public int getAge() {
         /*
        Requires:no requirements
        Modifies:no modificatoin
        Effects: returns customers age
        */
        return age;
    }

    public void setAge(int age) {
         /*
        Requires: an integer that is greater than zero
        Modifies: no modificatoin
        Effects: sets customers age
        */        
        
        this.age = age;
    }

    public movies getMovie1() {
        /*
        Requires: no requirement
        Modifies: no modification
        Effects: returns customers movie
        */          
        
        return movie1;
    }

    public void setMovie1(movies movie1) {
        /*
        Requires: a movie object, object can technically be null, but will not occur due to login screen procedure
        Modifies: no modificatoin
        Effects: sets movie customers is interested in
        */        
                
        this.movie1 = movie1;
    }

    public void setBooked(movies movies1, int j, int k,int stat) {
         /*
        Requires: movies object, integer j (either a 1 or 0): determine state of booked object. 
        Integer k greater than 0 less that 4: the number of seats 
        the user is refunding/purchasing. integer status either a 1 or 2: determines the state in booked.incrementseats()
        Modifies:
        Effects: creates a new booked object that follows state procedure based on its parameters
        */
        
        booked = new Booked(movies1, j, k,stat);
    }

    public String getPassword() {
         /*
        Requires: no requirement
        Modifies: no modification
        Effects: returns customers password
        */
        return password;
    }

    public int getAccnum() {
         /*
        Requires: no requirement
        Modifies: no modification
        Effects: returns customers account number
        */
        
        return accnum;
    }

    public customer(String Username, String password, int accnum, int age) {
         /*
        Requires: A string(username) that is not null and has length greater that 0, 
        String password that is not null and has length greater that 0, int accnum an integer than is greater than or equal to 1,
        int age, an integer that is greater 0
        Modifies: no modification
        Effects: constructor sets the parameter of customer username,password, account number and age
        */

        this.Username = Username;
        this.password = password;
        this.accnum = accnum;
        this.age=age;

    }

    public int getSeatnum() {
        /*
        Requires: no requirement
        Modifies:No modifications
        Effects: returns the number of seats purchased by the customer 
        */
        return seatnum;
    }

    public void setSeatnum(int seatnum) {
        /*
        Requires: requires an integer greater than 0 less that 5
        Modifies: sets the value of customers booked seats
        Effects: returns the number of seats purchased by the customer 
        */
        
        
        this.seatnum = seatnum;
    }

    public String getTitle() {
        /*
        Requires: no requirement
        Modifies:No modifications
        Effects: returns the title of the movie purchased by the customer 
        */
        return title;
    }

    public double getTotalprice() {
         /*
        Requires: no requirement
        Modifies: No modifications
        Effects: returns the updated total price for the movie 
        */
        
        return totalprice;
    }

    public void purchaseTicket(int age, int seats, String movieName, movies movies1,int status) {
        //customer should get discounts as applicable, based on age if they buy one ticket,number of seats purchased
        //need access to movies array here

        totalprice = movies1.getTicketPrice();
        title = movies1.getMovie();
        seatnum = seats;
        setSeatnum(seatnum);
        setMovie1(movies1);
        System.out.println("seats"+seats);
        // need to decrement the amount of seats availble will make another class called booked that will access the seat booking
        // will be accessed via book.seatavailable()

        if (seats == 1) {//discount on age, 10% discount
            if (age < 12 || age > 64) {
                totalprice = totalprice * 0.9;
                System.out.println("Age discount");
                System.out.println("new ticket price $ " + totalprice);

            }else System.out.println("full price ticket");

        }
        if (seats == 2)//discount 5%
        {
            totalprice = totalprice * 0.95;
            System.out.println("2 seat discount");
            System.out.println("new ticket price$ " + totalprice);
        }
        if (seats == 3)//discount 10%
        {
            totalprice = totalprice * 0.9;
            System.out.println("3 seat discount");
            System.out.println("new ticket price$ " + totalprice);
        }
        if (seats == 4)//discount 20%
        {
            System.out.println("4 seat discount");

            totalprice = totalprice * 0.8;
            System.out.println("new ticket price$ " + totalprice);
        }
      if(status==1){
        setBooked(movies1, 1, seats, 1);}
      else{
      setBooked(movies1,1, seats/2, 2);
      }
        
        
       
        

    }

    public void refundTicket(movies movies1, int seats) {// check this out
        /*
        Require:movie object that isnt null
        Modifies:no modifications
        Effects: calls setbooked method
        */

        setBooked(movies1, 0, getSeatnum(),0); //this should be the calling to booked from refund ticket

        title = null;
        seatnum = 0;
        totalprice = 0;
    }

    public void SetinformationONticket() {
        
         /*
        Requires: no requirement
        Modifies:No modifications
        Effects: returns the movie title, number of seats purchased and total price: for Movie purchased by the customer 
        */
        //will use this method to possibly gather info from customer array in the main login screen
            if(getTitle()==null){
            
            System.out.println("No purchases made, no info to display");}
            else{
        System.out.println("Movie Title: " + getTitle() + "\n Number of seats" + getSeatnum() + "\n Price:$ " + getTotalprice());
            }
    }

}
