package feup.com.flash_sales.model;

/**
 * Created by jhonny on 05-01-2018.
 */

public class Promotion {

    private String name;
    private String description;
    private String image;
    private String price;
    private String storeId;

    public Promotion(String name, String description, String image, String pric1e,String storeId) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.storeId = storeId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}
