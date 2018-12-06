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
    private List<Item> cartaDeProductos;
    private List<User> assistants;
    private List<String> categories;
    private float rating = 3.5f;
    private Integer minAge;
    private String dressCode;
    private Bar bar;


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


    public List<User> getAssistants() {
        return assistants;
    }

    public List<String> getCategories() {
        return categories;
    }

    public int getImageFileDrawable() {
        return imageFileDrawable;
    }

    public Party(Integer id, String creator, String partyName, String description, String eventDate, String eventHour, String address, String place, Integer price, List<Item> cartaDeProductos) {
        this.id = id;
        this.creator = creator;
        this.partyName = partyName;
        this.description = description;
        this.eventDate = eventDate;
        this.eventHour = eventHour;
        this.address = address;
        this.place = place;
        this.price = price;
        this.cartaDeProductos = cartaDeProductos;
    }

    public void setImageFileDrawable(int imageFileDrawable) {
        this.imageFileDrawable = imageFileDrawable;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventHour(String eventHour) {
        this.eventHour = eventHour;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Item> getCartaDeProductos() {
        return cartaDeProductos;
    }

    public void setCartaDeProductos(List<Item> cartaDeProductos) {
        this.cartaDeProductos = cartaDeProductos;
    }

    public void setAssistants(List<User> assistants) {
        this.assistants = assistants;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
}
