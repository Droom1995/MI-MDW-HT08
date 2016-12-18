package database;

import java.io.Serializable;

public class Flight implements Serializable{
    Person person;
    int id;
    String departure;
    String arrival;

    public Flight(){

    }


    public Flight(int id, Person person){
        this.person = person;
        this.id = id;
    }


    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeparture(String airport, String time){
        departure = airport + time;
    }

    public void setArrival(String airport, String time){
        arrival = airport + time;
    }

    public String toString(){
        return person.toString();
    }
}