package escuelaing.com.co.bowmobileapp.data.entities;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String type;
    private int id;


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
}