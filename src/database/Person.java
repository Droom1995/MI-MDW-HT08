package database;

/**
 * Created by Oleksandr on 05.12.2016.
 */
public class Person {

    private String firstName;
    private String lastName;
    
    public Person(){
    	
    }

    public Person(String inputName){
        String name[] = inputName.split(" ");
        firstName = name[0];
        if(name.length>1)
        	lastName = name[1];
        else
        	lastName = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}
