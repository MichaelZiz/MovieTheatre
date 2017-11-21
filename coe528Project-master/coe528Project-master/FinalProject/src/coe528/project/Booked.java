package coe528.project;

public class Booked {

    /*Overview Booked is able to increment or decrement the number of seats available for a certain movie, based on
    the refunds and purchases made towards that particular movie. Booked is not a mutable class, it only changes the the object that movies1 points to.
     */
    private movies movies1;// a movies object is needed in order to access the seat array and adjust the seats available for that
    //movie based on the increment(refunding seats) and the decrement method(purchasing seats)

    /* Abstraction Function:
        movies1 represents an object to increment and decrement the number of seats available for a movie
        displays the seats booked and seats refunded

        Rep Invariant:
        The number of seats being incremented can not exceed the number of seats available
        The number of seats being decremented can not go below 0
     */
    public Booked(movies movies1, int j, int k) {
        /*
        Requires:Movie object that contains information on the particular movie cannot be null, integer j either 1 or 0( state for adding/refunding seats),
        integer k greater than zero 
        Modifies: sets the movie object
        Effects: sets the movie object and initializes the seat increment or decrement based on state of j        
         */

        this.movies1 = movies1;

        if (j == 1) {// the variablej acts as a STATE INDICATOR when, j=1 we are reserving seats
            SeatsAvailableDecremenet(k);// 

        }
        if (j == 0) {//when j=0 we are returning seats 

            SeatsAvailableIncremenet(k);

        }
        //toString(k);
        //repok(k);

    }

    public void SeatsAvailableDecremenet(int k) {
        /*
        Requires:integer k thats is greater than 0
        Modifies: movies.seats array,when seats are booked most imediate cell becomes 1 
        Effects: changes the movies seats to 1 when seats have been booked
         */

        //k is the number of seats to reserve
        //number of available seats after purchase of tickets
        int count = k;
       
        for (int i = 0; i < movies1.seats.length; i++) {
            if (movies1.seats[i] == 0 && count > 0) {
                movies1.seats[i] = 1;
                count--;
                //System.out.println("count in array"+count+"");
            }
        }

        System.out.println("seats booked: " + k);

    }

    public void SeatsAvailableIncremenet(int k) {
        /*
        Requires: integer k that is greater than 0 
        Effects: movies.seats array, when seats are removed cell becomes a 0
        Modifies: changes the movies seats to 0 when seats have been refunded     
         */

        // is the number of seats to return
        //number of available seats after a refund
        int count = k;
       
        for (int i = 0; i < movies1.seats.length; i++) {
            if (movies1.seats[i] == 1 && count > 0) {
                movies1.seats[i] = 0;
                count--;

            }
            

        }

        System.out.println("seats refunded: " + k);

    }

    public String toString(int k) {
        return "Availible seats: " + k;
    }

    public boolean repok(int k) {
        if (k >= 0 && k <= movies1.seats.length) {
            return true;
        }
        return false;
    }

}
