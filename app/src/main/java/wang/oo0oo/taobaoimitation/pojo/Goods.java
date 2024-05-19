package wang.oo0oo.taobaoimitation.pojo;

public class Goods {
    private String name;
    private int imageId;
    private double price;
    private int monthlySales;
    private int postage;

    public Goods(String name, int imageId, double price, int monthlySales, int postage) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.monthlySales = monthlySales;
        this.postage = postage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(int monthlySales) {
        this.monthlySales = monthlySales;
    }

    public int getPostage() {
        return postage;
    }

    public void setPostage(int postage) {
        this.postage = postage;
    }
}
