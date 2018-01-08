package feup.com.flash_sales.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by jhonny on 06-01-2018.
 */

public class Store {

    private Address address;
    private String name;
    private String description;
    private String image;

    public Store(){}

    public Store(Address address, String name, String description,String image) {
        this.address = address;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
