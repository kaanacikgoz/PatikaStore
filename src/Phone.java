public class Phone extends Product {

    private int camera;
    private double battery;
    private int ram;
    private String color;


    public Phone(String name, double price, Brand brand, int storage, double screenSize, int camera, double battery, int ram, String color) {
        super(name, price, brand, storage, screenSize);
        this.camera = camera;
        this.battery =  battery;
        this.ram = ram;
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
