package coupon;

public class Item {
    public String name;
    public String category;
    public int price;


    public Item(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
