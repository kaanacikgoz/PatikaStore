import java.util.*;

public class PatikaStore {

    Scanner input = new Scanner(System.in);
    private static final TreeSet<Brand> brandTreeSet = new TreeSet<>(new BrandComparator());
    private static final TreeSet<Notebook> notebookIdTreeSet = new TreeSet<>(new NotebookIdComparator());
    private static final TreeSet<Notebook> notebookNameTreeSet = new TreeSet<>(new NotebookNameComparator());
    private static final TreeSet<Phone> phoneIdTreeSet = new TreeSet<>(new PhoneIdComparator());
    private static final TreeSet<Phone> phoneNameTreeSet = new TreeSet<>(new PhoneNameComparator());
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

    static {
        notebookIdTreeSet.add(new Notebook("HUAWEI Matebook 14 ",7000.0,new Brand("Huawei"),512,14.0,16));
        notebookIdTreeSet.add(new Notebook("LENOVO V14 IGL ",3699.0,new Brand("Lenovo"),1024,14.0,8));
        notebookIdTreeSet.add(new Notebook("ASUS Tuf Gaming  ",8199.0,new Brand("Asus"),2048,15.6,32));
    }

    static {
        phoneIdTreeSet.add(new Phone("SAMSUNG GALAXY A51 ", 3199.0, new Brand("Samsung"), 128, 6.5, 32, 4000.0, 6, "Siyah"));
        phoneIdTreeSet.add(new Phone("Iphone 11 64 GB ", 7379.0, new Brand("Apple"), 64, 6.1, 5, 3046.0, 6, "Mavi"));
        phoneIdTreeSet.add(new Phone("Redmi Note 10 Pro 8GB", 4012.0, new Brand("Xiaomi"), 128, 6.5, 35, 4000.0, 12, "Beyaz"));
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
                    printNotebook(notebookIdTreeSet);
                    crudNotebook();
                    break;
                case 2:
                    printPhone(phoneIdTreeSet);
                    crudPhone();
                    break;
                case 3:
                    System.out.println("Markalar\n---------------");
                    printBrand();
                    break;
                case 0:
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

    private void printNotebook(Set<Notebook> whichSet) {
        String format = "| %-2s | %-30s | %-9s | %-10s | %-10s | %-10s | %-10s |%n";
        String line = "-------------------------------------------------------------------------------------------------------";

        System.out.println(line);
        System.out.printf(format, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println(line);

        for (Notebook n : whichSet) {
            System.out.printf(
                    format,
                    n.getId(),
                    n.getName(),
                    n.getPrice() + " TL",
                    n.getBrand().getName(),
                    n.getStorage(),
                    n.getScreenSize(),
                    n.getRam()
            );
        }

        System.out.println(line);
    }

    private void printPhone(Set<Phone> whichSet) {
        String format = "| %-2s | %-30s | %-9s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n";
        String line = "----------------------------------------------------------------------------------------------------------------------------------------------";

        System.out.println(line);
        System.out.printf(format, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println(line);

        for (Phone p : whichSet) {
            System.out.printf(
                    format,
                    p.getId(),
                    p.getName(),
                    p.getPrice() + " TL",
                    p.getBrand().getName(),
                    p.getStorage(),
                    p.getScreenSize(),
                    p.getCamera(),
                    p.getBattery(),
                    p.getRam(),
                    p.getColor()
            );
        }
        System.out.println(line);
    }

    private void crudNotebook() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Urun eklemek icin 1 basiniz.\nUrun silmek icin 2 basiniz.\nUrun filtrelemek icin 3 basiniz.\nCikmak için 0 basiniz.");
            int crudChoice = input.nextInt();
            input.nextLine();
            switch (crudChoice) {
                case 1:
                    addNotebook();
                    break;
                case 2:
                    deleteNotebook();
                    break;
                case 3:
                    filterNotebook();
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter valid data!");
                    crudNotebook();
                    return;
            }
        }
    }

    private void crudPhone() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Urun eklemek icin 1 basiniz.\nUrun silmek icin 2 basiniz.\nUrun filtrelemek icin 3 basiniz.\nCikmak için 0 basiniz.");
            int crudChoice = input.nextInt();
            input.nextLine();
            switch (crudChoice) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    deletePhone();
                    break;
                case 3:
                    filterPhone();
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter valid data!");
                    crudPhone();
                    return;
            }
        }
    }

    // This method add new notebook
    private void addNotebook() {
        System.out.print("Urun adi girin: ");
        newName = input.nextLine();    // Brand name should come first in newName!!!
        System.out.print("Urun fiyati girin: ");
        double newPrice = input.nextDouble();
        Brand newBrand = new Brand(getBrandName());
        System.out.print("Urun depolamasi girin: ");
        int newStorage = input.nextInt();
        System.out.print("Urun ekrani girin: ");
        double newScreenSize = input.nextDouble();
        System.out.print("Urun ram'ini girin: ");
        int newRam = input.nextInt();

        if (isMatch(newBrand.getName())) {
            Notebook newNotebook = new Notebook(newName,newPrice,newBrand,newStorage,newScreenSize,newRam);
            notebookIdTreeSet.add(newNotebook);
            notebookNameTreeSet.add(newNotebook);
            System.out.println("New product added succesfully!");
        } else {
            System.out.println("Böyle bir marka bulunmadığı için ürün eklenememiştir!");
        }
        printNotebook(notebookIdTreeSet);
    }

    private void addPhone() {
        System.out.print("Urun adi girin: ");
        newName = input.nextLine();    // Brand name should come first in newName!!!
        System.out.print("Urun fiyati girin: ");
        double newPrice = input.nextDouble();
        Brand newBrand = new Brand(getBrandName());
        System.out.print("Urun depolamasi girin: ");
        int newStorage = input.nextInt();
        System.out.print("Urun ekrani girin: ");
        double newScreenSize = input.nextDouble();
        System.out.print("Urun ram'ini girin: ");
        int newRam = input.nextInt();

        if (isMatch(newBrand.getName())) {
            Notebook newNotebook = new Notebook(newName,newPrice,newBrand,newStorage,newScreenSize,newRam);
            notebookIdTreeSet.add(newNotebook);
            notebookNameTreeSet.add(newNotebook);
            System.out.println("New product added succesfully!");
        } else {
            System.out.println("Böyle bir marka bulunmadığı için ürün eklenememiştir!");
        }
        printNotebook(notebookIdTreeSet);
    }

    private void deleteNotebook() {
        if (notebookIdTreeSet.isEmpty()) {
            System.out.println("Silenecek bir ürün bulunmamaktadır!");
        } else {
            printNotebook(notebookIdTreeSet);
            System.out.println("Silmek istediğiniz ürünün id'sini giriniz");
            int deleteId = input.nextInt();

            Notebook removeNotebook = null;
            for (Notebook notebook : notebookIdTreeSet) {
                if (notebook.getId() == deleteId) {
                    removeNotebook = notebook;
                    break;
                }
            }

            if (removeNotebook != null) {
                notebookIdTreeSet.remove(removeNotebook);
                notebookNameTreeSet.remove(removeNotebook);
                System.out.println("Ürün başarıyla silindi.");
            } else {
                System.out.println("Böyle bir ürün bulunmamaktadır!");
            }
        }
        printNotebook(notebookIdTreeSet);
    }

    private void deletePhone() {
        if (notebookIdTreeSet.isEmpty()) {
            System.out.println("Silenecek bir ürün bulunmamaktadır!");
        } else {
            printNotebook(notebookIdTreeSet);
            System.out.println("Silmek istediğiniz ürünün id'sini giriniz");
            int deleteId = input.nextInt();

            Notebook removeNotebook = null;
            for (Notebook notebook : notebookIdTreeSet) {
                if (notebook.getId() == deleteId) {
                    removeNotebook = notebook;
                    break;
                }
            }

            if (removeNotebook != null) {
                notebookIdTreeSet.remove(removeNotebook);
                notebookNameTreeSet.remove(removeNotebook);
                System.out.println("Ürün başarıyla silindi.");
            } else {
                System.out.println("Böyle bir ürün bulunmamaktadır!");
            }
        }
        printNotebook(notebookIdTreeSet);
    }

    private int sortChoose() {
        System.out.println("1 - Sort by id\n2 - Sort by name\n3- Exit");
        return input.nextInt();
    }

    private void filterNotebook() {
        boolean isExit = false;
        while (!isExit) {
            switch (sortChoose()) {
                case 1:
                    printNotebook(notebookIdTreeSet);
                    break;
                case 2:
                    sortByName();
                    break;
                case 3:
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter valid data.");
                    filterNotebook();
                    return;
            }
        }
    }

    private void filterPhone() {
        boolean isExit = false;
        while (!isExit) {
            switch (sortChoose()) {
                case 1:
                    printNotebook(notebookIdTreeSet);
                    break;
                case 2:
                    sortByName();
                    break;
                case 3:
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter valid data.");
                    filterNotebook();
                    return;
            }
        }
    }

    private void sortByName() {
        notebookNameTreeSet.addAll(notebookIdTreeSet);
        printNotebook(notebookNameTreeSet);
    }

    // This method returns first word in newName variable in addNotebook().
    private String getBrandName() {
        String brand="";
        Optional<String> optionalBrand = Arrays.stream(newName.split(" ")).findFirst();
        if (optionalBrand.isPresent()) {
            brand = optionalBrand.get().toLowerCase();
        }
        return brand.replace(brand.charAt(0), brand.toUpperCase().charAt(0));
    }

    private boolean isMatch(String brandName) {
        for (Brand brand:brandTreeSet) {
            if (brand.getName().equals(brandName)) {
                return true;
            }
        }
        return false;
    }

}
