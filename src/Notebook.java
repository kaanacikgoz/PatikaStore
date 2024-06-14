public class Notebook extends Product {

    private static int counter = 0;
    public int id;
    private int ram;

    public Notebook(String name, double price, Brand brand, int storage, double screenSize, int ram) {
        super(name, price, brand, storage, screenSize);
        this.id = ++counter;
        this.ram = ram;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getId() {
        return id;
    }

}
