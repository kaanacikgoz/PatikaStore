import java.util.Comparator;

public class PhoneNameComparator implements Comparator<Phone> {
    @Override
    public int compare(Phone p1, Phone p2) {
        return p1.getBrand().getName().compareTo(p2.getBrand().getName());
    }
}
