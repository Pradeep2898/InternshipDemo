package test.intern.com.intern;

/**
 * Created by admin on 09-Jan-19.
 */

public class FruitModel {

    private String name,userdetail;
    private int image_drawable;

    public String getUserdetail() {return userdetail;}

    public void setUserdetail(String userdetail) {this.userdetail = userdetail;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_drawable() {
        return image_drawable;
    }

    public void setImage_drawable(int image_drawable) {
        this.image_drawable = image_drawable;
    }
}