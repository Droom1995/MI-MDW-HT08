package services;

import database.Flight;
import database.FlightDB;
import database.Person;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Oleksandr on 05.12.2016.
 */
@WebService
public class FlightOrderService {
    FlightDB flightDb;

    public FlightOrderService(){
        System.out.println("==================================TEST==============");
    	flightDb = FlightDB.getInstance();
        System.out.println(flightDb==null);
    }
    
    public List<Flight> getBookings(){
        return flightDb.getAllBookings();
    }

    public boolean addBooking(String name, String startAirport, String endAirport, String depTime, String arrTime){
        Flight flight = new Flight();
        Person person = new Person(name);
        flight.setPerson(person);
        flight.setDeparture(startAirport,depTime);
        flight.setArrival(endAirport,arrTime);
        flightDb.addBooking(flight);
        return true;
    }


    public boolean updateBooking(int id, String name, String startAirport, String endAirport, String depTime, String arrTime){
    	Flight flight = flightDb.getBooking(id);
    	if(flight == null)
    		return false;
        Person person = new Person(name);
        flight.setPerson(person);
        flight.setDeparture(startAirport,depTime);
        flight.setArrival(endAirport,arrTime);
        flightDb.addBooking(flight);
        return true;
    }

    public boolean removeBooking(int id){
        return flightDb.removeBooking(id);
    }
}
