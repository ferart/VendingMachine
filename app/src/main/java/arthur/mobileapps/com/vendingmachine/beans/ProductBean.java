package arthur.mobileapps.com.vendingmachine.beans;

import android.graphics.Color;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * POJO of the product to be sell
 */
public class ProductBean {

    private int status; //status of the product in stock, red not avalaible, green on stock
    private String name; //name of the product
    private int image;   //drawable image resource of the producto
    private float price; //price of the product
    private int stock;   //stock of this product

    public ProductBean(int image, float price, int stock) {
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.status= Color.rgb(0,100, 0);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;

        if (stock>5){ //if there is less than 5 products on stock, the card display a red warning, otherwise is green
            this.status= Color.rgb(0,100, 0);
        }else{
            this.status= Color.rgb(255,0, 0);
        }
    }
}
