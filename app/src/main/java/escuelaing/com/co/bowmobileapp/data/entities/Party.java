package escuelaing.com.co.bowmobileapp.data.entities;

import java.util.List;

public class Party {
    private Integer id;
    private String creator;
    private String partyName;
    private String description;
    private String eventDate;
    private String eventHour;
    private String address;
    private String place;
    private Integer price;
    private String optionalDescription;
    private List<User> assistants;
    private List<String> categories;


    public Integer getId() {
        return id;
    }

    public String getCreator() {
        return creator;
    }

    public String getPartyName() {
        return partyName;
    }

    public String getDescription() {
        return description;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventHour() {
        return eventHour;
    }

    public String getAddress() {
        return address;
    }

    public String getPlace() {
        return place;
    }

    public Integer getPrice() {
        return price;
    }

    public String getOptionalDescription() {
        return optionalDescription;
    }

    public List<User> getAssistants() {
        return assistants;
    }

    public List<String> getCategories() {
        return categories;
    }
}
