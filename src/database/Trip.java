package database;


public class Trip{
    private String name;
    private int capacity;
    private int id;
    private int occupied;

    public Trip(){

    }

    public Trip(int id, String name, int capacity) {
        this.name = name;
        this.id = id;
        this.capacity = capacity;
        this.occupied = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public boolean incOccupied(){
        if(occupied==capacity)
            return false;
        occupied++;
        return true;
    }
}