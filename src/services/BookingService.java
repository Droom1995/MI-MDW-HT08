package services;

import database.*;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Oleksandr on 05.12.2016.
 */
@WebService
public class BookingService {
    TripDB tripDB;

    public BookingService(){
        tripDB = TripDB.getInstance();
    }

    public List<Trip> getBookings(){
        return tripDB.getAllTrips();
    }

    public boolean addBooking(String name, int id){
        tripDB.addBooking(name, id);
        return true;
    }


    public boolean addTrip(String name, int capacity){
        tripDB.addTrip(name, capacity);
        return true;
    }

}
