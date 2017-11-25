
package coe528.project;

/**
 *Interface is used in order to promote the decoupling of class booked with customer
 */
public interface Seating {
    
    
    public void SeatsAvailableDecremenet(int k);
    public void SeatsAvailableIncremenet(int k);
    
}
