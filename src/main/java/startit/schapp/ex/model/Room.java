package startit.schapp.ex.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

//this class will create room objects based on the room table in the db
@Component//Spring bean(am gasit pe stackoverflow ca adnotarea de bean nu ar fi mandatory in cazul entitatilor
//totusi Spring nu recunoaste componenta fara adnotare)
@Entity//JPA mandatory annotation that marks a class that needs to be mapped to a table
//tie class to the rooms table
@Table(name = "rooms", uniqueConstraints = {
        @UniqueConstraint(columnNames = "roomid")})
public class Room {

    @Id//JPA mandatory annotation which declares a property as the id
    @Column(name = "roomid")
    private Integer id;

    //other columns in the db mapped to class properties
    @Column(name="roomlocation")
    private String building;

    @Column(name="roomname")
    private String name;

    @Column(name="roomcapacity")
    private int capacity;

    @Column(name="roomhasprojector")
    private int hasProjector;

    //default and parametrized constructor
    Room() {
    }



    public Room(Integer id, String building, String name, int capacity, int hasProjector) {
        this.id=id;
        this.building = building;
        this.name = name;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
    }

    //standard setters and getters
    private Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private int getHasProjector() {
        return hasProjector;
    }

    private String projector(){
        if(getHasProjector()==1){return "yes";} else return "no";
    }

    public void setHasProjector(int hasProjector) {
        this.hasProjector = hasProjector;
    }

    //object to string custom method
    //might not be needed as i plan to put together the object as a string outside the class. will see
    public String toString(){
        return
                 "RoomID: " + getId()
               + ", Room name: " + getName()
               + ", Room capacity: " + getCapacity()
               + ", Room has projector: " + projector();
    }
}
