import java.util.*;

public class PatikaStore {

    Scanner input = new Scanner(System.in);
    private static final TreeSet<Brand> brandTreeSet = new TreeSet<>(new BrandComparator());
    private Set<Notebook> notebookSet;
    private String newName;

    static {
        brandTreeSet.add(new Brand("Samsung"));
        brandTreeSet.add(new Brand("Lenovo"));
        brandTreeSet.add(new Brand("Apple"));
        brandTreeSet.add(new Brand("Huawei"));
        brandTreeSet.add(new Brand("Casper"));
        brandTreeSet.add(new Brand("Asus"));
        brandTreeSet.add(new Brand("HP"));
        brandTreeSet.add(new Brand("Xiaomi"));
        brandTreeSet.add(new Brand("Monster"));
    }

    static void printBrand() {
        for (Brand brand:brandTreeSet) {
            System.out.println(brand.getName());
        }
    }

    void run() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("""
                    1 - Notebook İşlemleri
                    2 - Cep Telefonu İşlemleri
                    3 - Marka Listele
                    0 - Çıkış Yap""");
            System.out.print("Tercihiniz: ");
            int menuChoice = input.nextInt();

            switch (menuChoice) {
                case 1:
                    //Notebook
                    getNotebook();
                    break;
                case 2:
                    //Cep telefonu
                    break;
                case 3:
                    //marka
                    System.out.println("Markalar\n---------------");
                    printBrand();
                    break;
                case 0:
                    //çıkış
                    System.out.println("Tekrar bekleriz!!!");
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter valid data!");
                    run();
                    return;
            }
        }
    }

    void getNotebook() {
        notebookSet = new LinkedHashSet<>();
        notebookSet.add(new Notebook("HUAWEI Matebook 14 ",7000.0,new Brand("Huawei"),512,14.0,16));
        notebookSet.add(new Notebook("LENOVO V14 IGL ",3699.0,new Brand("Lenovo"),1024,14.0,8));
        notebookSet.add(new Notebook("ASUS Tuf Gaming  ",8199.0,new Brand("Asus"),2048,15.6,32));
        printNotebook(notebookSet);
    }

    void printNotebook(Set<Notebook> set) {
        String format = "| %-2s | %-30s | %-8s | %-10s | %-10s | %-10s | %-10s |%n";
        String line = "------------------------------------------------------------------------------------------------------------";

        System.out.println(line);
        System.out.printf(format, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println(line);

        for (Notebook n : set) {
            System.out.printf(
                    format,
                    Notebook.id,
                    n.getName(),
                    n.getPrice() + "TL",
                    n.getBrand().getName(),
                    n.getStorage(),
                    n.getScreenSize(),
                    n.getRam()
            );
        }

        System.out.println(line);
    }

    void crudProduct() {
        int crudChoice = input.nextInt();
        System.out.println("Urun eklemek icin 1 basiniz.");
        System.out.println("Urun silmek icin 2 basiniz.");
        System.out.println("Cikmak için 0 basiniz.");
        switch (crudChoice) {
            case 1:
                add();
            case 2:

        }
    }

    void add() {
        System.out.print("Urun adi girin: ");
        newName = input.nextLine();
        System.out.print("Urun fiyati girin: ");
        double newPrice = input.nextDouble();
        Brand newBrand = new Brand(getBrandName());
        System.out.print("Urun depolamasi girin: ");
        int newStorage = input.nextInt();
        System.out.print("Urun ekrani girin: ");
        double newScreenSize = input.nextDouble();
        System.out.print("Urun ram'ini girin: ");
        int newRam = input.nextInt();
        Notebook newNotebook = new Notebook(newName,newPrice,newBrand,newStorage,newScreenSize,newRam);
        notebookSet.add(newNotebook);
    }

    private String getBrandName() {
        String brand="";
        Optional<String> optionalBrand = Arrays.stream(newName.split(" ")).findFirst();
        if (optionalBrand.isPresent()) {
            brand = optionalBrand.get().toLowerCase();
        }
        return brand.replace(brand.charAt(0), brand.toUpperCase().charAt(0));
    }

}
