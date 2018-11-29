package escuelaing.com.co.bowmobileapp.data.entities;

import java.io.Serializable;
import java.util.List;

public class Party implements Serializable {
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


    //Desde la vista de administrador debe haber la opcion para que el admin cargue una imagen y se agregue a
    //Drawables y se haga un set del numero asignado de drawable a este atributo para que desde esta vista pueda
    //llamarlo usando findById(R.drawable.imageFileDrawable)
    private int imageFileDrawable;

    public Party(){}

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

    public int getImageFileDrawable() {
        return imageFileDrawable;
    }

    public Party(Integer id, String creator, String partyName, String description, String eventDate, String eventHour, String address, String place, Integer price, String optionalDescription) {
        this.id = id;
        this.creator = creator;
        this.partyName = partyName;
        this.description = description;
        this.eventDate = eventDate;
        this.eventHour = eventHour;
        this.address = address;
        this.place = place;
        this.price = price;
        this.optionalDescription = optionalDescription;
    }

    public void setImageFileDrawable(int imageFileDrawable) {
        this.imageFileDrawable = imageFileDrawable;
    }
}
