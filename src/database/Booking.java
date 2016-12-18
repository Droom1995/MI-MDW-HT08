package database;

/**
 * Created by Oleksandr on 17.12.2016.
 */
import java.util.ArrayList;



public class Booking{
    int id;
    Trip trip;


    Person person;

    public Booking(int id, Trip trip, Person person){
        this.id = id;
        this.trip = trip;
        this.person = person;

    }

    public Booking(Trip trip){
        this.trip = trip;

    }

    public int getId() {
        return id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

}
