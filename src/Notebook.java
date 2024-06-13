public class Notebook extends Product {

    public static int id;
    private int ram;

    public Notebook(String name, double price, Brand brand, int storage, double screenSize, int ram) {
        super(name, price, brand, storage, screenSize);
        Notebook.id++;
        this.ram = ram;
    }

    int getRam() {
        return ram;
    }

    void setRam(int ram) {
        this.ram = ram;
    }

}
