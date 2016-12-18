package database;

/**
 * Created by Oleksandr on 05.12.2016.
 */
import java.util.ArrayList;
import java.util.Hashtable;

public class FlightDB {
    private static FlightDB instance = null;
    private Hashtable<Integer, Flight> bookings = new Hashtable<Integer, Flight>();

    public FlightDB(){

    }

    public static FlightDB getInstance() {
        if (instance == null)
            instance = new FlightDB();
        return instance;
    }


    public ArrayList<Flight> getAllBookings(){
        return new ArrayList<Flight>(bookings.values());

    }

    public void addBooking(Flight flight){
        flight.setId(bookings.size());
        bookings.put(flight.getId(), flight);
    }

    public boolean updateBooking(Flight flight){
    	if(!bookings.containsKey(flight.getId()))
    		return false;
        bookings.put(flight.getId(), flight);
        return true;
    }

    public Flight getBooking(int id) {
    	System.out.println(id);
    	if(!bookings.containsKey(id))
    		return null;
        return bookings.get(id);
    }

    public boolean removeBooking(int id){
    	if(bookings.containsKey(id)){
    		bookings.remove(id);
    		return true;
    	}
    	return false;
    }

}
