package escuelaing.com.co.bowmobileapp.data.entities;

import java.util.List;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String type;
    private int id;
    private List<Party> myParties;


    public User(String email, String name, int id, String password, String type){
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = id;
        this.type = type;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Party> getMyParties() {
        return myParties;
    }

    public void setMyParties(List<Party> myParties) {
        this.myParties = myParties;
    }

    public void addParty(Party selectedParty) {
        this.myParties.add(selectedParty);
    }
}