public abstract class Product {

    private String name;
    private double price;
    private Brand brand;
    private int storage;
    private double screenSize;

    public Product(String name, double price, Brand brand, int storage, double screenSize) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    static void add() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
