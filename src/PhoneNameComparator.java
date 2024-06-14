import java.util.Comparator;

public class PhoneNameComparator implements Comparator<Phone> {
    @Override
    public int compare(Phone p1, Phone p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
