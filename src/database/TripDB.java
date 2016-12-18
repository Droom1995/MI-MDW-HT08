package database;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Oleksandr on 17.12.2016.
 */
public class TripDB {
    private static TripDB instance = null;
    private Hashtable<Integer, Trip> ht = new Hashtable<Integer, Trip>(); // for trips
    private Hashtable<Integer, Booking> bookings = new Hashtable<Integer, Booking>();

    public TripDB(){
        addTrip("Trip1", 5);
        addBooking("Booking1", 0);
    }

    public static TripDB getInstance() {
        if (instance == null)
            instance = new TripDB();
        return instance;
    }

    public void addTrip(String name, int capacity){
        int id = ht.size();
        Trip t = new Trip(id, name,capacity);
        ht.put(id,t);
    }

    public ArrayList<Trip> getAllTrips(){
        return new ArrayList<Trip>(ht.values());

    }

    public Trip getTrip(int id) {
        return ht.get(id);
    }

    public Booking addBooking(String name, int id){
        if(ht.get(id).incOccupied()){
            Person p = new Person(name);
            Booking t = new Booking(bookings.size()+1,getTrip(id),p);
            bookings.put(t.getId(), t);
            return t;
        }
        return null;
    }

    public Booking getBooking(int id) {
        return bookings.get(id);
    }

    public ArrayList<Booking> getAllBookings(){
        return new ArrayList<Booking>(bookings.values());
    }
}
